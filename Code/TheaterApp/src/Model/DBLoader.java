package Model;

import java.lang.reflect.Array;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * This class is used to load data from a database into a model.
 */
public class DBLoader {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/movieapp";
	static final String USERNAME = "root";
	static final String PASSWORD = "water";

	public DBLoader() throws SQLException {
	}

	public static Connection getConn() {
		try {
			return DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		} catch(Exception e) {System.out.println(e);}
		return null;
	}

	/** Loads the information for all theaters from storage
	 *
	 *  PROMISES: Returns the list of all theaters
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Theater> loadTheaters(){
		// Tested. Confirmed it works.
		ArrayList<Theater> myTheaters = new ArrayList<>();
		try {
			Connection conn = DBLoader.getConn();
			String query = "SELECT theaterName, postalCode, movieListID FROM theater;";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			if (res != null) {
				while (res.next()) {
					HashMap<Movie, ArrayList<Showing>> theater_schedule = new HashMap<>();
					String tName = res.getString(1);
					String pCode = res.getString(2);
					int movielistid = res.getInt(3);
					ArrayList<Movie> tMovies = DBLoader.loadMovies(new TheaterApp(), tName);
					for (Movie movie : tMovies) {
						ArrayList<Showing> movie_showings = DBLoader.loadShowings(movie);
						theater_schedule.put(movie, movie_showings);
					}
					myTheaters.add(new Theater(pCode, tName, theater_schedule));
				}
			}
		} catch(Exception e) {System.out.println(e);}
		return myTheaters;
	}

	/** Loads the information for all movies from storage
	 *
	 *  PROMISES: Returns the list of all movies
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Movie> loadMovies(TheaterApp myObserver) {
		// Tested. Works as expected
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		try {
			String query = String.format("SELECT movieName, exclusiveNews, showtimeListID FROM movie");
			Connection con = DBLoader.getConn();
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			if (res != null) {
				while (res.next()) {
					String movie_name = res.getString(1);
					String news = res.getString(2);
					int showtimelistID = res.getInt(3);
					myMovies.add(new Movie(movie_name, news, myObserver, showtimelistID));
				}
			}
		} catch(Exception e) {System.out.println(e);}
		return myMovies;
	}

	/** Loads the information for movies for a specific theater given by theater name
	 *  PROMISES: Returns the list of all movies
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Movie> loadMovies(TheaterApp myObserver, String theater_name) {
		// Tested. Works as expected
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		try {
			String query = String.format("SELECT M.movieName, exclusiveNews, showtimeListID FROM "+
					"theater as T join movielist as ML on T.movieListID = ML.id "+
					"join movie as M on ML.movieName = M.movieName "+
					"WHERE T.theaterName=?;");
			Connection con = DBLoader.getConn();
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, theater_name);
			ResultSet res = statement.executeQuery();
			if (res != null) {
				while (res.next()) {
					String movie_name = res.getString(1);
					String news = res.getString(2);
					int showtimelistID = res.getInt(3);
					myMovies.add(new Movie(movie_name, news, myObserver, showtimelistID));
				}
			}
		} catch (Exception e) {System.out.println(e);}
		return myMovies;
	}

	/**
	 * Loads showings for a given movie
	 * @param m Movie
	 * @return arraylist of showings
	 */
	public static ArrayList<Showing> loadShowings(Movie m){
		// Tested. Works as expected.
		ArrayList<Showing> myShowings = new ArrayList<>();
		try {
			Connection conn = DBLoader.getConn();
			String query = "SELECT datee, totalRows, totalCols, ticketListID from "+
					"movie as M join showtimelist as SL on M.showtimeListID = SL.Id "+
					"join showtime S on SL.showtimeID = S.id "+
					"WHERE (M.showtimeListID=? AND M.movieName=?);";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, m.getShowingListID());
			statement.setString(2, m.getTitle());
			ResultSet res = statement.executeQuery();
			if (res != null) {
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
				while (res.next()) {
					Timestamp datetime = res.getTimestamp(1);
					int rows = res.getInt(2);
					int cols = res.getInt(3);
					int ticketListID = res.getInt(4);
					ArrayList<Ticket> showtime_tickets = DBLoader.loadTickets(ticketListID);
					myShowings.add(new Showing("void", showtime_tickets, datetime));
				}
			}
		} catch(Exception e) {System.out.println(e);}
		return myShowings;
	}

	/**
	 * Loads tickets from a database for a given showing
	 * @param listID ticket db array id
	 * @return arraylist of tickets
	 */
	public static ArrayList<Ticket> loadTickets(int listID) {
		// Tested. Works as expected.
		ArrayList<Ticket> myTickets = new ArrayList<>();
		try {
			Connection conn = DBLoader.getConn();
			String query = "SELECT id, ticketStatus, seatRow, seatCol, cost FROM "+
					"ticketlist as TL join ticket as T on TL.ticketID = T.ID "+
					"WHERE TL.ticketListID=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, listID);
			ResultSet res = statement.executeQuery();
			if (res != null) {
				while (res.next()) {
					String ticketID = String.valueOf(res.getInt(1));
					boolean isSold = res.getBoolean(2);
					int row = res.getInt(3);
					int col = res.getInt(4);
					double cost = res.getDouble(5);
					myTickets.add(new Ticket(ticketID, cost, isSold, row, col));
				}
			}
		} catch(Exception e) {System.out.println(e);}
		return myTickets;
	}

	/** Loads the information for all users from storage
	 *
	 *  PROMISES: Returns the list of all users
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<RegisteredUser> loadUsers(){
		// Tested. Works as expected
		ArrayList<RegisteredUser> myUsers = new ArrayList<RegisteredUser>();
		try {
			Connection con = DBLoader.getConn();
			String query1 = "SELECT username, password, fname, lname, email FROM reguser";
			PreparedStatement statement = con.prepareStatement(query1);
			ResultSet res = statement.executeQuery();
			if (res != null) {
				while (res.next()) {
					String name = res.getString(3) + " " + res.getString(4);
					String email = res.getString(5);
					String username = res.getString(1);
					String password = res.getString(2);
					PaymentInfo user_paymentInfo =DBLoader.loadPaymentInfo(username, email, name);
					RegisteredUser user = new RegisteredUser(username, password, name, user_paymentInfo);
					myUsers.add(user);
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return myUsers;
	}

	/**
	 * Provides payment information from the database for a given user
	 * @param uname username
	 * @param email user email
	 * @param name user full name
	 * @return Payment Information object
	 */
	public static PaymentInfo loadPaymentInfo(String uname, String email, String name) {
		// Tested. Works as expected
		try {
			Connection con = DBLoader.getConn();
			String query = "SELECT number, month, year, cvv FROM paymentinfo WHERE username=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, uname);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				int card_num = Integer.parseInt(resultSet.getString(1));
				int month = resultSet.getInt(2);
				int year = resultSet.getInt(3);
				int cvv = Integer.parseInt(resultSet.getString(4));
				return new PaymentInfo(email, name, card_num, cvv, month, year);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return new PaymentInfo();
	}

	/**
	 * Adds new registered user record
	 * @return true if added successfully
	 */
	public static boolean addRegisteredUser(String username, String password, String name,
									 String phone, String email, String cardName, String cardNumber,
									 int cvv, int month, int year) {
		// Tested. Works as expected.
		try {
			Connection conn =DBLoader.getConn();
			String queryUser = "INSERT INTO reguser(username, fname, lname, phone, email, password) "+
					"VALUES (?, ?, ?, ?, ?, ?); ";
			PreparedStatement statementUser = conn.prepareStatement(queryUser);
			statementUser.setString(1, username);
			statementUser.setString(2, name.split(" ")[0]);
			statementUser.setString(3, name.split(" ")[1]);
			statementUser.setString(4, phone);
			statementUser.setString(5, email);
			statementUser.setString(6, password);
			statementUser.executeUpdate();
			DBLoader.addPaymentInfo(cardNumber, month, year, cvv, username);
			return true;
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Adds new paymentInfo record
	 */
	public static void addPaymentInfo(String cardNumber, int month, int year, int cvv, String username) {
		// Tested. Works
		try {
			Connection conn =DBLoader.getConn();
			String query = "INSERT INTO paymentInfo(number, month, year, cvv, username) "+
					"VALUES (?, ?, ?, ?, ?); ";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, cardNumber);
			statement.setInt(2, month);
			statement.setInt(3, year);
			statement.setInt(4, cvv);
			statement.setString(5, username);
			statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	/** Loads the information for all active vouchers from storage
	 *  Note that a voucher is only valid for one year after its issue date.
	 *
	 *  PROMISES: Returns the list of all active vouchers
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Voucher> loadActiveVouchers(){
		ArrayList<Voucher> myVouchers = new ArrayList<Voucher>();
		//TODO: Add vouchers
		// Note that a voucher is only active until the expiry date
		return myVouchers;
	}

	public static void main(String[] args) throws SQLException {
//		boolean userAdded = DBLoader.addRegisteredUser("m1", "m123", "m1 m2", "40306316",
//				"m12@gmail.com", "M1M2", "45551222", 111, 1, 2021);
//		ArrayList<Theater> ths = DBLoader.loadTheaters();
//		for (Theater t : ths) {
//			System.out.println(t.getTheaterName() + ":" + t.getPostalCode() + t.getMySchedule().toString());
//		}
		// DBLoader.loadMovies(new TheaterApp());
//		ArrayList<RegisteredUser> users =DBLoader.loadUsers();
//		System.out.println(users.get(0).getName());
//		System.out.println(users.get(6).getName());
		// theater(postalcode: from theater table, dictionary<movie, arraylist<showings>>
		// -> need movie -> showings
		// loadmovies
		// movie(title, theaterApp)
		// showing(
	}
}