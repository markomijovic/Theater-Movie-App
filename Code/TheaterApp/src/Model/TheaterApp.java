package Model;

import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.ArrayList;

/**
 * This is the main class for the back-end. It runs all operations.

 */
public class TheaterApp {
	double ANNUAL_FEE = 20.0;
	double ADMINISTRATION_FEE = 0.15;
	double MIN_CANCEL_NOTICE_HOURS = 72.0;
    static int UNIQUE_ID = 0;
    int uid = ++UNIQUE_ID;
	
    /**
     * This is a list of all theater locations.
     */
	private ArrayList<Theater> myTheaters;
	/**
	 * This is a list of all movies.
	 */
	private ArrayList<Movie> myMovies;
	/**
	 * This is a list of all vouchers that are not expired.
	 */
	private ArrayList<Voucher> myActiveVouchers;
	/**
	 * This is the system that deals with registered user login/registration.
	 */
	private UserSystem myUserSystem;
	/**
	 * System to send email messages.
	 */
	private MessageSystem myMessageSystem;
	/**
	 * System to charge payment.
	 */
	private PaymentSystem myPaymentSystem;
	/**
	 * User currently using the app, by default this is an ordinary user.
	 */
	private User currentUser;
	
	/**
	 * Default constructor for the app is a Factory method.
	 * An ordinary user is instantiated by default. 
	 * Login/Registration system is instantiated.
	 * Message system is instantiated.
	 * Payment system is instantiated.
	 * Theater and Movie information is loaded from the database.
	 */
	public TheaterApp() {
		currentUser = new OrdinaryUser();
		myMessageSystem = new MessageSystem();
		myPaymentSystem = new PaymentSystem();
		myUserSystem = UserSystem.getInstance();
		myActiveVouchers = DBLoader.loadActiveVouchers();
		myMovies = DBLoader.loadMovies(this);
		myTheaters = DBLoader.loadTheaters();
	}
	
	/** 
	 * Searches a for a theater based on its id.
	 * 
	 * PROMISES: Returns theater with specified id.
	 * REQUIRES: Valid theater id.
	 */
	private Theater searchTheater(String theaterId) {
		Theater retVal = null;
		
		int numTheaters = myTheaters.size();
		for (int i = 0; i < numTheaters; i++) {
			if (myTheaters.get(i).getPostalCode().equals(theaterId)) {
				retVal = myTheaters.get(i);
				break;
			}
		}
		
		return retVal;
	}
	
	/** 
	 * Searches a for a movie based on its id.
	 * 
	 * PROMISES: Returns movie with specified id.
	 * REQUIRES: Valid movie id.
	 */
	private Movie searchMovie(String movieId) {
		Movie retVal = null;
		
		int numMovies = myMovies.size();
		for (int i = 0; i < numMovies; i++) {
			if (myMovies.get(i).getTitle().equals(movieId)) {
				retVal = myMovies.get(i);
				break;
			}
		}
		
		return retVal;
	}

	/** 
	 * Searches a for a voucher based on its id.
	 * 
	 * PROMISES: Returns voucher with specified id.
	 * REQUIRES: Valid voucher id.
	 */
	private Voucher searchActiveVoucher(int voucherId) {
		Voucher retVal = null;
		
		int numVouchers = myActiveVouchers.size();
		for (int i = 0; i < numVouchers; i++) {
			if (myActiveVouchers.get(i).getId() == voucherId) {
				retVal = myActiveVouchers.get(i);
				break;
			}
		}
		
		return retVal;
	}

	/**
	 * Issues a voucher for a ticket to the current user.
	 * PROMISES: A voucher creation for a specific user.
	 * REQUIRES: User to give voucher to and ticket to be refunded.
	 */
	private Voucher issueVoucher(User currentUser, Ticket myTicket) {
		double amount = myTicket.getCost();
		
		if (!(currentUser instanceof RegisteredUser))
			amount *= (1.0 - ADMINISTRATION_FEE);
		
		Voucher voucher = new Voucher(new Date(), amount, uid);
		return voucher;
	}

	/**
	 * Checks whether a ticket can be cancelled. Cancellation must happen no later
	 * than 72 hours before the movie.
	 * PROMISES: Returns true if ticket can be cancelled
	 * REQUIRES: Showtime for movie and the cancellation date.
	 */
	private boolean canCancelTicket(Date showtime, Date cancellationDate) {
		boolean retVal = false;
		
		if ((showtime.getTime() - cancellationDate.getTime()) / 3600000.0 <= 72.0)
			retVal = true;
		
		return retVal;
	}
	
	/**
	 * Get a list of theaters and their information.
	 */
	public String[] getTheaters(){
		
		int numTheaters = myTheaters.size();
		String[] retVal = new String[numTheaters];
		
		for (int i = 0; i < numTheaters; i++)
			retVal[i] = myTheaters.get(i).getTheaterInfo();
		
		return retVal;
	}
	
	/**
	 * Get a list of movies for a specific theater location.
	 */
	public String[] getMovies(String theaterId){
		ArrayList<String> retVal = new ArrayList<String>();
		
		Theater myTheater = searchTheater(theaterId);
		
		if (myTheater != null) {
			Map<Movie, ArrayList<Showing>> mySchedule = myTheater.getMySchedule();
			for (Map.Entry<Movie, ArrayList<Showing>> set : mySchedule.entrySet()) {
				retVal.add(set.getKey().getMovieInfo());
			}
		}
		
		return (String[]) retVal.toArray();
	}

	/** 
	 * Get a list of showings for a specific movie at a specific theater.
	 */
	public String[] getShowings(String theaterId, String movieId) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		Theater myTheater = searchTheater(theaterId);
		Movie myMovie = searchMovie(movieId);
		
		if (myTheater != null && myMovie != null) {
			ArrayList<Showing> myShowings = myTheater.getShowings(myMovie);
			if (myShowings != null) {
				int numShowings = myShowings.size();
				for (int i = 0; i < numShowings; i++)
					retVal.add(myShowings.get(i).getShowingInfo());
			}
		}
		
		return (String[]) retVal.toArray();
	}
	
	/**
	 * Get list of seats for a specific showing.
	 */
	public String[] getSeats(String theaterId, String movieId, String showingId) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		Theater myTheater = searchTheater(theaterId);
		Movie myMovie = searchMovie(movieId);
		if (myTheater != null && myMovie != null) {
			Showing myShowing = myTheater.searchShowing(myMovie, showingId);
			if (myShowing != null) {
				ArrayList<Ticket> myTickets = myShowing.getMyTickets();
				int numSeats = myTickets.size();
				for (int i = 0; i < numSeats; i++) {
					retVal.add(myTickets.get(i).getSeatInfo());
				}
			}
		}
		
		return (String[]) retVal.toArray();
	}
	
	/**
	 * Log in using a username and password. Login is validated using login system.
	 * If successful, current user is changed to the registered user. Otherwise,
	 * current user remains ordinary user.
	 */
	public String[] login(String username, String password) {
		boolean retVal = false;
		
		User search = myUserSystem.login(username, password);
		
		if (search != null) {
			currentUser = search;
			retVal = true;
		}
		
		return new String[] {Boolean.toString(retVal)};
	}

	/**
	 * Changes the current user to an ordinary user.
	 */
	public String[] logout() {
		currentUser = new OrdinaryUser();
		return new String[] {Boolean.toString(true)};
	}
	
	/**
	 * Attempts to enter the payment information for the current user.
	 */
	public String[] enterPaymentInfo(String email,
								 String nameOnCard,
								 int creditCardNumber,
								 int ccv,
								 int expiryMonth,
								 int expiryYear) {
		boolean retVal = false;
		
		PaymentInfo myPaymentInfo = new PaymentInfo( email,
													 nameOnCard,
													 creditCardNumber,
													 ccv,
													 expiryMonth,
													 expiryYear );
		retVal = myPaymentSystem.validPaymentInfo(myPaymentInfo);
		
		if (retVal)
			currentUser.setPaymentInfo(myPaymentInfo);
		
		return new String[] {Boolean.toString(retVal)};
	}
	
	/**
	 * Registers the current user as a registered user.
	 * Annual fee is charged.
	 */
	public String[] register(String username, String password, String name) {
		boolean retVal = false;

		PaymentInfo myPaymentInfo = currentUser.getPaymentInfo();

		if (myPaymentSystem.validPaymentInfo(myPaymentInfo)) {
			RegisteredUser myRegisteredUser = myUserSystem.register(username, password, name, myPaymentInfo);
			
			if (myRegisteredUser != null) {
				myPaymentSystem.charge(myPaymentInfo, ANNUAL_FEE);
				currentUser = myRegisteredUser;
				retVal = true;
			}				
		}

		return new String[] {Boolean.toString(retVal)};
	}
	
	/**
	 * Buys ticket at a specific theater, for a specific movie, at a specific showing, at a specific seat.
	 */
	public String[] buyTicket(String theaterId, String movieId, String showingId, String ticketId) {
		boolean retVal = false;

		Theater myTheater = searchTheater(theaterId);
		Movie myMovie = searchMovie(movieId);
		if (myTheater != null && myMovie != null) {
			Showing myShowing = myTheater.searchShowing(myMovie, showingId);
			Ticket myTicket = myShowing.searchTicket(ticketId);
			
			if (myTicket != null) {
				if (!myTicket.isSold())
					retVal = myPaymentSystem.charge(currentUser.getPaymentInfo(), myTicket.getCost());
				
				if (retVal) {
					myTicket.buyTicket();
					myMessageSystem.sendTicketPurchaseConfirmationEmail(currentUser, myTicket);
				}
			}
		}

		return new String[] {Boolean.toString(retVal)};
	}

	/**
	 * Cancels ticket at a specific theater, for a specific movie, at a specific showing, at a specific seat.
	 */
	public String[] cancelTicket(String theaterId, String movieId, String showingId, String ticketId) {
		boolean retVal = false;

		Theater myTheater = searchTheater(theaterId);
		Movie myMovie = searchMovie(movieId);
		if (myTheater != null && myMovie != null) {
			Showing myShowing = myTheater.searchShowing(myMovie, showingId);
			Ticket myTicket = myShowing.searchTicket(ticketId);
			
			if (myTicket != null) {
				if (myTicket.isSold()) {
					if (canCancelTicket(myShowing.getShowtime(), new Date())) {
						myTicket.returnTicket();
						Voucher myVoucher = issueVoucher(currentUser, myTicket);
						myMessageSystem.sendTicketRefundConfirmationEmail(currentUser, myTicket, myVoucher);					
					}
				}
			}
		}
		
		return new String[] {Boolean.toString(retVal)};
	}
	
	/**
	 * Sends exclusive movie news to all registered users.
	 */
	public void sendExclusiveMovieNews(String news) {
		myMessageSystem.sendExclusiveMovieNewsEmail(myUserSystem.getMyUsers(), news);

	}
}
