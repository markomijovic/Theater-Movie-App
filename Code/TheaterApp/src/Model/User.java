package Model;

public abstract class User {
	protected PaymentInfo myPaymentInfo;
	
	public PaymentInfo getPaymentInfo() {
		return myPaymentInfo;
	}
	
	public void setPaymentInfo(PaymentInfo val) {
		myPaymentInfo = val;
	}
}
