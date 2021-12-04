package Model;

import java.util.Date;

public class Voucher {

	private Date issueDate;
	private double refundValue;
	private int id;
	
	Voucher(Date issueDate, double refundValue) {
		this.issueDate = issueDate;
		this.refundValue = refundValue;
	}
	
	public int getId() {
		return id;
	}
	public double getRefundValue() {
		return refundValue;
	}
	public String getInformation() {
		//TODO
		return "";
	}
}
