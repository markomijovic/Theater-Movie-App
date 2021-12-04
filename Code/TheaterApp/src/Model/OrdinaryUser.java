package Model;

/**
 * This class represents an ordinary user for the system.
 */
public class OrdinaryUser extends User{

	/**
	 * Default constructor for ordinary user.
	 * Assigns an empty payment information object.
	 */
	OrdinaryUser() {
		this.myPaymentInfo = new PaymentInfo();
	}
}
