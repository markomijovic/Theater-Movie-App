package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a showing for a movie, this includes the room information
 * as well as the time for the movie.
 */
public class Showing {
	/**
	 * Room number + time.
	 */
	private String id;
	/**
	 * List of all tickets for this showing.
	 */
	private ArrayList<Ticket> myTickets;
	/**
	 * Time for showing.
	 */
	private Timestamp showtime;
	
	/**
	 * Constructor for Showing inititalizes all data members.
	 */
	Showing (String id, ArrayList<Ticket> myTickets, Timestamp showtime){
		this.id = id;
		this.myTickets = myTickets;
		this.showtime = showtime;
	}

	/** 
	 * Searches a for a ticket.
	 * 
	 * PROMISES: Returns ticket with specified id at the showing.
	 * REQUIRES: Valid showing and ticket id.
	 */
	public Ticket searchTicket(String ticketId) {
		Ticket retVal = null;
		
		int numTickets = myTickets.size();
		for (int i = 0; i < numTickets; i++) {
			if (myTickets.get(i).getId().equals(ticketId)) {
				retVal = myTickets.get(i);
				break;
			}
		}
		
		return retVal;
	}

	/**
	 * Returns list of tickets for this showing.
	 */
	public ArrayList<Ticket> getMyTickets() {
		return myTickets;
	}
	
	/**
	 * Returns id for showing.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns time for showing.
	 */
	public Timestamp getShowtime() {
		return showtime;
	}
	
	/**
	 * Returns room number and time.
	 */
	public String getShowingInfo() {
		return id + "\nTime: " + showtime.toString();
	}
	
}
