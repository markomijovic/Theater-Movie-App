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
	static final String PASSWORD = "";

	public DBLoader() throws SQLException {
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
		
		Theater myTheater = new Theater("POSTALCODE", mySchedule);
		
		//TODO: Add a couple of theater entries
		myTheaters.add(myTheater);
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
		
		Movie myMovie = new Movie("Die Hard", "Best Christmas movie", "Enjoy the movie", "Bruce Willis", myObserver);
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
		ArrayList<RegisteredUser> myUsers = new ArrayList<RegisteredUser>();
		
		PaymentInfo myPaymentInfo = new PaymentInfo();
		RegisteredUser myUser = new RegisteredUser("gabe", "1234", "Gabriel", "Calgary", myPaymentInfo);
		//TODO: Add a couple of users
		myUsers.add(myUser);
		return myUsers;
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

	/*public static void main(String[] args) throws SQLException {
		DBLoader.loadMovies(null);

		// loadtheater
		// theater(postalcode: from theater table, dictionary<movie, arraylist<showings>>
		// -> need movie -> showings

		// loadmovies
		// movie(title, theaterApp)

		// showing(
	}*/
}
