package Model;

/**
 * This class represents a registered user whose information is stored in a database.
 */
public class RegisteredUser extends User{
	
	/**
	 * username for log in. This can be used as a unique id.
	 */
	private String username;
	/**
	 * password to authenticate log in
	 */
	private String password;
	/**
	 * First name of user
	 */
	private String name;
	/**
	 * Address for user
	 */
	private String address;
	
	/**
	 * Constructor initializing all data members.
	 */
	RegisteredUser(String username, String password, String name, String address, PaymentInfo myPaymentInfo){
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.myPaymentInfo = myPaymentInfo;
	}
	
	/**
	 * Checks whether a given password matches the one on file.

	 */
	public boolean validatePassword(String input) {
		return password.equals(input);
	}
	
	/**
	 * Returns the username for the user. This is the unique id for the user.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Returns the name of the user.
	 */
	public String getName() {
		return name;
	}
}
