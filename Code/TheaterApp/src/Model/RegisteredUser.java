package Model;

public class RegisteredUser extends User{
	
	private String username;
	private String password;
	private String name;
	private String address;
	
	RegisteredUser(String username, String password, String name, String address, PaymentInfo myPaymentInfo){
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.myPaymentInfo = myPaymentInfo;
	}
	
	public boolean validatePassword(String input) {
		return password.equals(input);
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
}
