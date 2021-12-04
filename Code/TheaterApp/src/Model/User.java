package Model;

/**
 * This is the base class for a user.
 */
public abstract class User {
	/**
	 * Holds all information required for payment.
	 */
	protected PaymentInfo myPaymentInfo;
	
	/**
	 * Getter for payment information.
	 */
	public PaymentInfo getPaymentInfo() {
		return myPaymentInfo;
	}
	
	/**
	 * Setter for payment information.
	 */
	public void setPaymentInfo(PaymentInfo val) {
		myPaymentInfo = val;
	}
}
