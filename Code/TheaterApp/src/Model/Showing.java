package Model;

import java.util.ArrayList;
import java.util.Date;

public class Showing {

	private int id;
	private ArrayList<Ticket> myTickets;
	private Date showtime;
	
	public ArrayList<Ticket> getMyTickets() {
		return myTickets;
	}
	
	public int getId() {
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
