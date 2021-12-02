package Model;

public class PaymentSystem {
	
	public boolean validPaymentInfo(PaymentInfo myPaymentInfo) {
		//TODO
		return false;
	}
	
	public boolean charge(PaymentInfo myPaymentInfo, double amount) {
		boolean retVal = false;
		
		if (validPaymentInfo(myPaymentInfo)) {
			retVal = true;
		}
		
		return retVal;
	}
}
