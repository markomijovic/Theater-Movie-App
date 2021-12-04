package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a showing for a movie, this includes the room information
 * as well as the time for the movie.
 */
public class Showing {
	
	private String id;
	private int numRows;
	private int numCols;
	private String theaterId;
	private String movieId;
	private ArrayList<Ticket> myTickets;
	private Date showtime;
	
	Showing (){
		
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

	public ArrayList<Ticket> getMyTickets() {
		return myTickets;
	}
	
	public String getId() {
		return id;
	}

	public Date getShowtime() {
		return showtime;
	}
	
	public String getShowingInfo() {
		//TODO
		return "";
	}
	
}
