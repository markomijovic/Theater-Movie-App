package Model;

import java.util.Date;
import java.util.ArrayList;

public class TheaterApp {
	double ANNUAL_FEE = 20.0;
	double ADMINISTRATION_FEE = 0.15;
	double MIN_CANCEL_NOTICE_HOURS = 72.0;
	
	private ArrayList<Theater> myTheaters;
	private ArrayList<Movie> myMovies;
	private ArrayList<Ticket> myActiveTickets;
	private ArrayList<Voucher> myActiveVouchers;
	private UserSystem myUserSystem;
	private MessageSystem myMessageSystem;
	private PaymentSystem myPaymentSystem;
	
	private User currentUser;
	
	public TheaterApp() {
		myTheaters = DBLoader.loadTheaters();
		myMovies = DBLoader.loadMovies();
		myActiveTickets = DBLoader.loadActiveTickets();
		myActiveVouchers = DBLoader.loadActiveVouchers();
		myUserSystem = UserSystem.getInstance();
		myMessageSystem = new MessageSystem();
		myPaymentSystem = new PaymentSystem();
		currentUser = new OrdinaryUser();
	}
	
	private Theater searchTheater(int theaterId) {
		Theater retVal = null;
		
		int numTheaters = myTheaters.size();
		for (int i = 0; i < numTheaters; i++) {
			if (myTheaters.get(i).getId() == theaterId) {
				retVal = myTheaters.get(i);
				break;
			}
		}
		
		return retVal;
	}

	private Movie searchMovie(int movieId) {
		Movie retVal = null;
		
		int numMovies = myMovies.size();
		for (int i = 0; i < numMovies; i++) {
			if (myMovies.get(i).getId() == movieId) {
				retVal = myMovies.get(i);
				break;
			}
		}
		
		return retVal;
	}

	private Showing searchShowing(int theaterId, int movieId, int showingId) {
		Showing retVal = null;

		Theater myTheater = searchTheater(theaterId);
		Movie myMovie = searchMovie(movieId);
		
		if (myTheater != null && myMovie != null) {
			ArrayList<Showing> myShowings = myTheater.getShowings(myMovie);
			if (myShowings != null) {
				int numShowings = myShowings.size();
				for (int i = 0; i < numShowings; i++) {
					if (myShowings.get(i).getId() == showingId) {
						retVal = myShowings.get(i);
						break;
					}
				}
			}
		}
		
		return retVal;
	}

	private Ticket searchActiveTicket(int ticketId) {
		Ticket retVal = null;
		
		int numTickets = myActiveTickets.size();
		for (int i = 0; i < numTickets; i++) {
			if (myActiveTickets.get(i).getId() == ticketId) {
				retVal = myActiveTickets.get(i);
				break;
			}
		}
		
		return retVal;
	}

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

	private Voucher issueVoucher(User currentUser, Ticket myTicket) {
		double amount = myTicket.getCost();
		
		if (!(currentUser instanceof RegisteredUser))
			amount *= (1.0 - ADMINISTRATION_FEE);
		
		Voucher voucher = new Voucher(new Date(), amount);
		return voucher;
	}

	private boolean canCancelTicket(Date showtime, Date cancellationDate) {
		boolean retVal = false;
		
		if ((showtime.getTime() - cancellationDate.getTime()) / 3600000.0 <= 72.0)
			retVal = true;
		
		return retVal;
	}
	
	public ArrayList<String> getTheaters(){
		ArrayList<String> retVal = new ArrayList<String>();
		
		int numTheaters = myTheaters.size();
		for (int i = 0; i < numTheaters; i++)
			retVal.add(myTheaters.get(i).getTheaterInfo());
		
		return retVal;
	}
	
	public ArrayList<String> getMovies(int theaterId){
		ArrayList<String> retVal = new ArrayList<String>();
		
		Theater myTheater = searchTheater(theaterId);
		
		if (myTheater != null) {
			int numMovies = myTheater.getMyMovies().size();
			for (int i = 0; i < numMovies; i++)
				retVal.add(myTheater.getMyMovies().get(i).getMovieInfo());
		}
		
		return retVal;
	}

	public ArrayList<String> getShowings(int theaterId, int movieId) {
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
		
		return retVal;
	}
	
	public ArrayList<String> getSeats(int theaterId, int movieId, int showingId) {
		ArrayList<String> retVal = new ArrayList<String>();
		
		Showing myShowing = searchShowing(theaterId, movieId, showingId);
		if (myShowing != null) {
			ArrayList<Ticket> myTickets = myShowing.getMyTickets();
			int numSeats = myTickets.size();
			for (int i = 0; i < numSeats; i++) {
				retVal.add(myTickets.get(i).getSeatInfo());
			}
		}
		
		return retVal;
	}
	
	public boolean login(String username, String password) {
		boolean retVal = false;
		
		User search = myUserSystem.login(username, password);
		
		if (search != null) {
			currentUser = search;
			retVal = true;
		}
		
		return retVal;
	}

	public boolean logout() {
		currentUser = new OrdinaryUser();
		return true;
	}
	
	public boolean enterPaymentInfo(String email,
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
		
		return retVal;
	}
	
	public boolean register(String username, String password, String name, String address) {
		boolean retVal = false;

		PaymentInfo myPaymentInfo = currentUser.getPaymentInfo();

		if (myPaymentSystem.validPaymentInfo(myPaymentInfo)) {
			RegisteredUser myRegisteredUser = myUserSystem.register(username, password, name, address, myPaymentInfo);
			
			if (myRegisteredUser != null) {
				myPaymentSystem.charge(myPaymentInfo, ANNUAL_FEE);
				currentUser = myRegisteredUser;
				retVal = true;
			}				
		}
		
		return retVal;
	}
	
	public boolean buyTicket(int ticketId) {
		boolean retVal = false;
		
		Ticket myTicket = searchActiveTicket(ticketId);
		
		if (myTicket != null) {
			if (!myTicket.isSold())
				retVal = myPaymentSystem.charge(currentUser.getPaymentInfo(), myTicket.getCost());
			
			if (retVal) {
				myTicket.buyTicket();
				myMessageSystem.sendTicketPurchaseConfirmationEmail(currentUser, myTicket);
			}
		}
		
		return retVal;
	}
	
	public boolean cancelTicket(int ticketId) {
		boolean retVal = false;
		
		Ticket myTicket = searchActiveTicket(ticketId);
		
		if (myTicket != null) {
			if (myTicket.isSold()) {
				Showing myShowing = searchShowing(myTicket.getTheaterId(), 
												  myTicket.getMovieId(), 
												  myTicket.getShowingId());
				if (canCancelTicket(myShowing.getShowtime(), new Date())) {
					myTicket.returnTicket();
					issueVoucher(currentUser, myTicket);
					myMessageSystem.sendTicketRefundConfirmationEmail(currentUser, myTicket);					
				}
			}
		}
		
		return retVal;
	}
}
