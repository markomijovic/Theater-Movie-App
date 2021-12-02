package Model;

public class PaymentInfo {
	private String email;
	private String nameOnCard;
	private int creditCardNumber;
	private int ccv;
	private int expiryMonth;
	private int expiryYear;
	
	PaymentInfo() {
		this.email = "";
		this.nameOnCard = "";
		this.creditCardNumber = -1;
		this.ccv = -1;
		this.expiryMonth = -1;
		this.expiryYear = -1;		
	}
	
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
}
