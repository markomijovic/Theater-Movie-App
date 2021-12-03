package Model;

import java.util.ArrayList;

public class DBLoader {
	
	public static ArrayList<Theater> loadTheaters(){
		ArrayList<Theater> myTheaters = new ArrayList<Theater>();
		//TODO: Add a couple of theater entries
		return myTheaters;
	}

	public static ArrayList<Movie> loadMovies(){
		ArrayList<Movie> myMovies = new ArrayList<Movie>();
		//TODO: Add a couple of movie entries
		return myMovies;
	}

	public static ArrayList<RegisteredUser> loadUsers(){
		ArrayList<RegisteredUser> myUsers = new ArrayList<RegisteredUser>();
		//TODO: Add a couple of users
		return myUsers;
	}

	public static ArrayList<Ticket> loadActiveTickets(){
		ArrayList<Ticket> myActiveTickets = new ArrayList<Ticket>();
		//TODO: Add tickets
		// Note that a ticket is only valid if its showing is today or later
		return myActiveTickets;
	}
	
	public static ArrayList<Voucher> loadActiveVouchers(){
		ArrayList<Voucher> myVouchers = new ArrayList<Voucher>();
		//TODO: Add vouchers
		// Note that a voucher is only active until the expiry date
		return myVouchers;
	}
}
