package Model;

import java.util.ArrayList;

/**
 * UserSystem is a Singleton pattern that is used to manage the 
 * log in, registration and storage of registered users.
 */
public class UserSystem {
	/**
	 * Only instance for the user system.
	 */
	private static UserSystem myInstance;
	/**
	 * UserSystem holds a list of all registered users.
	 */
	private ArrayList<RegisteredUser> myUsers;
	
	/**
	 * When the system is created, user information is loaded from the 
	 * database via DBLoader static class.
	 */
	private UserSystem(DBLoader loader) {
		myUsers = loader.loadUsers();
	}
	
	/**
	 * Returns the only instance of UserSystem. If there is no instance,
	 * one is created.
	 */
	public static UserSystem getInstance(DBLoader loader) {
		if (myInstance == null)
			return new UserSystem(loader);
		else
			return myInstance;
	}

	/**
	 * Search for a registered user.
	 * PROMISES: A registered user object with the given username
	 * REQUIRES: Username for user
	 */
	private RegisteredUser searchUser(String username) {
		RegisteredUser retVal = null;

		int numUsers = myUsers.size();
		for (int i = 0; i < numUsers; i++) {
			if (myUsers.get(i).getUsername().equals(username)) {
				retVal = myUsers.get(i);
				break;
			}
		}
		
		return retVal;
	}

	/**
	 * Returns the RegisteredUser object upon a successful log in.
	 * If log in is unsuccessful, null is returned.
	 * PROMISES: To search for username in the database, then validate the given password.
	 *           If successful, the user is returned, otherwise null is returned.
	 * REQUIRES: username and password to be attempted
	 */
	public RegisteredUser login(String username, String password) {
		RegisteredUser retVal = searchUser(username);

		if (retVal != null) {
			if (!retVal.validatePassword(password))
				retVal = null;
		}
		
		return retVal;
	}

	/**
	 * Registers a user into the user system.
	 * PROMISES: To create a registered user and add it to the database.
	 * REQUIRES: All data members for registered user.
	 */
	public RegisteredUser register(String username, String password, String name,
								   String phone, String email, String cardName, String cardNumber,
								   int cvv, int month, int year, DBLoader loader) {
		System.out.println("here");
		RegisteredUser retVal = null;
		PaymentInfo newInfo = new PaymentInfo(email, name, Integer.parseInt(cardNumber), cvv, month, year);
		if (searchUser(username) == null) {
			retVal = new RegisteredUser(username, password, name, newInfo);
			loader.addRegisteredUser(username, password, name, phone, email, cardName, cardNumber, cvv, month, year);
		}
		return retVal;
	}
	
	/**
	 * Returns list of all registered users.
	 */
	public ArrayList<RegisteredUser> getMyUsers() {
		return myUsers;
	}
}
