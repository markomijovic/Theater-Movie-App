package Model;

import java.util.ArrayList;

public class UserSystem {
	private static UserSystem myInstance;
	private ArrayList<RegisteredUser> myUsers;
	
	private UserSystem() {
		myUsers = DBLoader.loadUsers();
	}
	
	public static UserSystem getInstance() {
		if (myInstance == null)
			return new UserSystem();
		else
			return myInstance;
	}

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

	public RegisteredUser login(String username, String password) {
		RegisteredUser retVal = searchUser(username);

		if (retVal != null) {
			if (!retVal.validatePassword(password))
				retVal = null;
		}
		
		return retVal;
	}

	public RegisteredUser register(String username, String password, String name, String address, PaymentInfo myPaymentInfo) {
		RegisteredUser retVal = null;
		
		if (searchUser(username) == null) {
			retVal = new RegisteredUser(username, password, name, address, myPaymentInfo);
			myUsers.add(retVal);
		}
		
		return retVal;
	}
}
