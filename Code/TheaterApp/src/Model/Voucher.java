package Model;

import java.util.Date;

/**
 * This class represents a ticket refund that is valid for one year.
 */
public class Voucher {
	/**
	 * Date of issue for voucher.
	 */
	private Date issueDate;
	/**
	 * Date of expiry for voucher.
	 */
	private Date expiryDate;
	/**
	 * Dollar value for the voucher.
	 */
	private double refundValue;
	/**
	 * Unique id for voucher.
	 */
	private int id;
	
	/**
	 * Constructor for voucher initializes all data members.
	 */
	Voucher(Date issueDate, double refundValue, int id) {
		this.issueDate = issueDate;
		this.expiryDate = new Date(issueDate.getDay(), issueDate.getMonth(), issueDate.getYear() + 1);
		this.refundValue = refundValue;
		this.id = id;
	}

	/**
	 * Returns all required information for the voucher.
	 */
	public String getInformation() {
		return "Voucher id: " + Integer.toString(id) + "\n" +
			   "Voucher value: $" + Double.toString(refundValue) + "\n" +
			   "Issue date: " + issueDate.toString() + "\n" +
			   "Expiry date: " + expiryDate.toString();
	}
	
	/**
	 * Returns voucher id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns voucher dollar value.
	 */
	public double getRefundValue() {
		return refundValue;
	}
}
