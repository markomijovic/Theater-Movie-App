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
	/**
	 * Dollar cost for the ticket.
	 */
	private double cost;

	/**
	 * Constructor for ticket initializes data members. 
	 */
	Ticket (String id, double cost, boolean sold) {
		this.id = id;
		this.cost = cost;
		this.sold = sold;
	}
	
	/**
	 * Returns id for ticket.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Returns the cost of the ticket.
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Changes status of ticket to bought.
	 */
	public void buyTicket() {
		sold = true;
	}
	
	/**
	 * Returns status of ticket.
	 * True if sold.
	 */
	public boolean isSold() {
		return sold;
	}

	/**
	 * Sets ticket to not sold.
	 */
	public void returnTicket() {
		sold = false;
	}
	
	/**
	 * Gets the seat information.
	 */
	public String getSeatInfo() {
		String status = "available";
		if (sold)
			status = "unavailable";
		return id + "(" + status + ")";
	}
}
