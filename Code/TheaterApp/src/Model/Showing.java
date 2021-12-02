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
	
	public String getShowingInfo() {
		//TODO
		return "";
	}
	
	public boolean canCancelTicket(Date cancellationDate) {
		boolean retVal = false;
		
		if ((showtime.getTime() - cancellationDate.getTime()) / 3600000.0 <= 72.0)
			retVal = true;
		
		return retVal;
	}
}
