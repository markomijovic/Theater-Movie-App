package View;

public class LoginPage extends Page{

	@Override
	public String[] interactWithUser() {
		boolean attemptLogin = false;
		String username = "";
		String password = "";
		//TODO: populate username, password and whether user
		// pressed "LogIn" (true) or "HomePage" (false)
		return new String[] {Boolean.toString(attemptLogin), username, password};
	}

	@Override
	public void sendMessage(String message) {
		//Display result from model to user whether log in was successful or not
	}
}
