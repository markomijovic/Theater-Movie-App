package Model;

import java.lang.reflect.Array;
import java.sql.*;
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
	public static ArrayList<Theater> loadTheaters(ArrayList<Movie> listOfAllMovies){
		ArrayList<Theater> myTheaters = new ArrayList<>();

		HashMap<Movie, ArrayList<Showing>> mySchedule = new HashMap<Movie, ArrayList<Showing>>();

		int numMovies = listOfAllMovies.size();
		for (int i = 0; i < numMovies; i++) {
			Movie myMovie = listOfAllMovies.get(i);

			ArrayList<Ticket> myTickets = new ArrayList<Ticket>();
			Ticket myTicket = new Ticket("A2", 14.99, false);
			myTickets.add(myTicket);

			ArrayList<Showing> myShowings = new ArrayList<Showing>();
			Showing myShowing = new Showing("Room 1", myTickets, new Date());
			myShowings.add(myShowing);

			if(myShowings.size() > 0)
				mySchedule.put(myMovie, myShowings);
		}

		//Theater myTheater = new Theater("POSTALCODE", mySchedule);

		//TODO: Add a couple of theater entries
		//myTheaters.add(myTheater);
		return myTheaters;
	}

	/** Loads the information for all movies from storage
	 *
	 *  PROMISES: Returns the list of all movies
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Movie> loadMovies(TheaterApp myObserver) {
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		/*
		try {
			String query = String.format("SELECT movieName, exclusiveNews, showtimeListID FROM movie WHERE theaterName=?;");
			Connection con=DriverManager.getConnection(
					DB_URL,USERNAME,PASSWORD);
			PreparedStatement statement = con.prepareStatement(query);
			//statement.setString(1, t.getTheaterName());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
						int type = resultSetMetaData.getColumnType(i);
						if (type == Types.VARCHAR || type == Types.CHAR) {
							System.out.println(resultSet.getString(i));
						} else {
							System.out.println(resultSet.getInt(i));
						}
					}
					System.out.println("-----------");
				}
			}
		} catch(Exception e) {System.out.println(e);}
		*/

		Movie myMovie = new Movie("Die Hard", "Coming next fall", "Best Christmas movie", "Bruce Willis", myObserver);
		myMovies.add(myMovie);
		return myMovies;
	}

	public static ArrayList<Showing> loadShowings(Movie m){
		ArrayList<Showing> myShowings = new ArrayList<>();
		return myShowings;
	}

	public static ArrayList<Ticket> loadTickets(Showing s) {
		ArrayList<Ticket> myTickets = new ArrayList<>();
		String query = String.format("");
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