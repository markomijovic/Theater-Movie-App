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
