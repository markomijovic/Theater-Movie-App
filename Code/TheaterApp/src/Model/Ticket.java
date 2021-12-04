package Model;

/**
 * Represents a ticket.
 */
public class Ticket {

	/**
	 * The status of the ticket, whether it is sold (true) or not sold (false)
	 */
	private boolean sold;
	/**
	 * Id for ticket is row and column, example A2.
	 */
	private String id;
	private double cost;

	Ticket (String id, double cost) {
		this.id = id;
		this.cost = cost;
		this.sold = false;
	}
	
	public String getId() {
		return id;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void buyTicket() {
		sold = true;
	}
	
	public boolean isSold() {
		return sold;
	}

	public void returnTicket() {
		sold = false;
	}
	
	public String getSeatInfo() {
		//TODO
		return "";
	}
}
