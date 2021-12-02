package Model;

import java.util.Date;

public class Voucher {

	private Date issueDate;
	private double amount;
	private int id;
	
	Voucher(Date issueDate, double amount) {
		this.issueDate = issueDate;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
}
