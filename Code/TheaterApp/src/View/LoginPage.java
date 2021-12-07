package View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginPage extends Page{

	@Override
	public String[] interactWithUser() {
		boolean attemptLogin = false;
		String username = "";
		String password = "";

    	try {
    		System.out.println("Login page, press q at any time to quit");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Username: ");
            username = reader.readLine();
            if (!username.equals("q")) {
        		System.out.println("Password: ");
                password = reader.readLine(); 
                if (!password.equals("q")) { 
	        		System.out.println("Attempt Login? [Y/N]");
	                String yesOrNo = reader.readLine();
	                if (yesOrNo.equals("Y") || yesOrNo.equals("y"))
	                	attemptLogin = true;    
                }
            }
    	}
    	catch (Exception e) { 	}

		return new String[] {Boolean.toString(attemptLogin), username, password};
	}

	@Override
	public void sendMessage(String message) {
		boolean loginSuccessful = Boolean.parseBoolean(message);

		if (loginSuccessful)
			System.out.println("Login is successful");
		else
			System.out.println("Login is NOT successful");
	}
}
