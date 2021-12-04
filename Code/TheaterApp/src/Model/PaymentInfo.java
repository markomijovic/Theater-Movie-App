package Model;

/**
 * A class representing all required information for successful payment.
 */
public class PaymentInfo {
	/**
	 * E-mail to be notified of purchases.
	 */
	private String email;
	/**
	 * Name on card.
	 */
	private String nameOnCard;
	/**
	 * Card number
	 */
	private int creditCardNumber;
	/**
	 * Security code on back of card
	 */
	private int ccv;
	/**
	 * Month of expiry date for card.
	 */
	private int expiryMonth;
	/**
	 * Year of expiry date for card.
	 */
	private int expiryYear;
	
	/**
	 * Default constructor with default values.
	 */
	PaymentInfo() {
		this.email = "";
		this.nameOnCard = "";
		this.creditCardNumber = -1;
		this.ccv = -1;
		this.expiryMonth = -1;
		this.expiryYear = -1;		
	}
	
	/**
	 * Constructor for a valid payment information object.
	 */
	PaymentInfo( String email,
				 String nameOnCard,
				 int creditCardNumber,
				 int ccv,
				 int expiryMonth,
				 int expiryYear ) {
		this.email = email;
		this.nameOnCard = nameOnCard;
		this.creditCardNumber = creditCardNumber;
		this.ccv = ccv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}
	
	/**
	 * Returns email information
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Returns credit card number
	 */
	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * Returns expiry month
	 */
	public int getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * Returns expiry year
	 */
	public int getExpiryYear() {
		return expiryYear;
	}
}
