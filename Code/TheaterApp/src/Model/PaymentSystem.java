package Model;

/**
 * This class represents the payment system that processes the payment information
 */
public class PaymentSystem {
	
	/**
	 * Checks whether payment information is valid.
	 * PROMISES: Returns true if valid email and credit card information
	 * REQUIRES: Payment information object
	 */
	public boolean validPaymentInfo(PaymentInfo myPaymentInfo) {
		boolean retVal = validEmail(myPaymentInfo.getEmail());
		retVal = retVal && validCreditCardNumber(myPaymentInfo.getCreditCardNumber());
		retVal = retVal && !expired(myPaymentInfo.getExpiryMonth(), myPaymentInfo.getExpiryYear());
		return retVal;
	}

	/**
	 * Checks whether email is valid.
	 * PROMISES: Returns true if valid email
	 * REQUIRES: Email to be checked
	 */
	public boolean validEmail(String email) {
		//TODO
		return true;
	}

	/**
	 * Checks whether credit card number is valid.
	 * PROMISES: Returns true if valid number
	 * REQUIRES: Number to be checked
	 */
	public boolean validCreditCardNumber(int number) {
		//TODO
		return true;
	}

	/**
	 * Checks whether card is not expired.
	 * PROMISES: Returns true if card is expired
	 * REQUIRES: The expiration month and year of the card
	 */
	public boolean expired(int month, int year) {
		//TODO
		return true;
	}
	
	/**
	 * Charges the payment information a specified amount.
	 * PROMISES: Returns true if payment was successfully processed
	 * REQUIRES: The payment information and amount to be charged
	 */
	public boolean charge(PaymentInfo myPaymentInfo, double amount) {
		boolean retVal = false;
		
		if (validPaymentInfo(myPaymentInfo)) {
			retVal = true;
		}
		
		return retVal;
	}
}
