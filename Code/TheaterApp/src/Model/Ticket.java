package Model;

public class Ticket {

	private boolean sold;
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
