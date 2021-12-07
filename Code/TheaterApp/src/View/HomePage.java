package View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomePage extends Page {

	@Override
	public String[] interactWithUser() {
		String[] result = {"-1"};
		System.out.println("Please select an action to be done: ");
		System.out.println("(1) Log in");
		System.out.println("(2) Register");
		System.out.println("(3) Browse Theaters");
		System.out.println("(4) Cancel a Ticket");
		System.out.println("(5) Quit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        int option = -1;
        while (option < 0) {
            // Reading data using readLine
        	try {
                option = Integer.parseInt(reader.readLine());
                if (option < 0 || option > 4)
                	option = -1;
        	}
        	catch (Exception e) {
        		option = -1;
        	}
        }
        
        result[0] = Integer.toString(option);
		return result;
	}
}
