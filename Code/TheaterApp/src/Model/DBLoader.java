package Model;

import java.util.ArrayList;

/**
 * This class is used to load data from a database into a model.
 */
public class DBLoader {
	
	/** Loads the information for all theaters from storage
	 * 
	 *  PROMISES: Returns the list of all theaters
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Theater> loadTheaters(ArrayList<Movie> listOfAllMovies){
		ArrayList<Theater> myTheaters = new ArrayList<Theater>();
		//TODO: Add a couple of theater entries
		return myTheaters;
	}

	/** Loads the information for all movies from storage
	 * 
	 *  PROMISES: Returns the list of all movies
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<Movie> loadMovies(){
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		//TODO: Add a couple of movie entries
		return myMovies;
	}

	/** Loads the information for all users from storage
	 * 
	 *  PROMISES: Returns the list of all users
	 *  REQUIRES: Connection to information storage
	 */
	public static ArrayList<RegisteredUser> loadUsers(){
		ArrayList<RegisteredUser> myUsers = new ArrayList<RegisteredUser>();
		//TODO: Add a couple of users
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
}
