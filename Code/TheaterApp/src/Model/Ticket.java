package Model;

public class Ticket {

	private boolean sold;
	private int theaterId;
	private int movieId;
	private int showingId;
	private int id;
	private double cost;

	Ticket (int id, double cost) {
		this.id = id;
		this.cost = cost;
		this.sold = false;
	}
	
	public int getId() {
		return id;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public int getMovieId() {
		return movieId;
	}

	public int getShowingId() {
		return showingId;
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
