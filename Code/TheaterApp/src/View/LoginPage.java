package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends Page{
	private  JLabel usernameLabel;
	public  JTextField userText;
	private  JLabel passwordLabel;
	public  JPasswordField passwordText;
	public  JButton login;
	private  JButton guest;
	public  JLabel regUserSuccess;
	
	public LoginPage() {
		this.setSize(350, 400);
        this.setLocation(300, 300);
        //this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Login Page");
        title.setBounds(10, 10, 570, 20);
        title.setFont(new Font("Ariel", Font.BOLD, 10));
        this.add(title);

  	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	usernameLabel = new JLabel("Username");
	usernameLabel.setBounds(10,20,80,25);
	this.add(usernameLabel);
	
	userText = new JTextField(20);
	userText.setBounds(100,20,165,25);
	this.add(userText);
	
	
	passwordLabel = new JLabel("Password");
	passwordLabel.setBounds(10,50,80,25);
	this.add(passwordLabel);
	
	
	passwordText = new JPasswordField(20);
	passwordText.setBounds(100,50,165,25);
	this.add(passwordText);
	
	login = new JButton("Registered User Login");
	login.setBounds(10,80,175,25);
	this.add(login);
	
	
	guest = new JButton("Continue as Guest");
	guest.setBounds(180,80,175,25);
	this.add(guest);
	
	regUserSuccess = new JLabel("");
	regUserSuccess.setBounds(10,120,200,25);
	this.add(regUserSuccess);
	}
	
	
	public void addButtonActionListener(ActionListener RegUserListener, ActionListener GuestListener) {
		login.addActionListener(RegUserListener);
		guest.addActionListener(GuestListener);
	}
	
	 public void display() {
	        this.setVisible(true);
	 }
	 
	 public static void main(String[] args) {
	        LoginPage p = new LoginPage();
	        p.display();
	 }
	
	
}

	
	
//	@Override
//	public String[] interactWithUser() {
//		boolean attemptLogin = false;
//		String username = "";
//		String password = "";
//
//    	try {
//    		System.out.println("Login page, press q at any time to quit");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    		System.out.println("Username: ");
//            username = reader.readLine();
//            if (!username.equals("q")) {
//        		System.out.println("Password: ");
//                password = reader.readLine(); 
//                if (!password.equals("q")) { 
//	        		System.out.println("Attempt Login? [Y/N]");
//	                String yesOrNo = reader.readLine();
//	                if (yesOrNo.equals("Y") || yesOrNo.equals("y"))
//	                	attemptLogin = true;    
//                }
//            }
//    	}
//    	catch (Exception e) { 	}
//
//		return new String[] {Boolean.toString(attemptLogin), username, password};
//	}
//
//	@Override
//	public void sendMessage(String[] message) {
//		boolean loginSuccessful = Boolean.parseBoolean(message[0]);
//
//		if (loginSuccessful)
//			System.out.println("Login is successful");
//		else
//			System.out.println("Login is NOT successful");
//	}
//}
