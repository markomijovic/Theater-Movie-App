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
	public  JLabel regUserSuccess;
	private  JButton back;
	
	
	public LoginPage() {
		this.setSize(350, 400);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Login Page");
        title.setBounds(120, 15, 570, 30);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);

	usernameLabel = new JLabel("Username");
	usernameLabel.setBounds(10,70,80,25);
	this.add(usernameLabel);
	
	userText = new JTextField(20);
	userText.setBounds(100,70,165,25);
	this.add(userText);
	
	
	passwordLabel = new JLabel("Password");
	passwordLabel.setBounds(10,100,80,25);
	this.add(passwordLabel);
	
	
	passwordText = new JPasswordField(20);
	passwordText.setBounds(100,100,165,25);
	this.add(passwordText);
	
	login = new JButton("Login");
	login.setBounds(85,240,175,25);
	this.add(login);
	
	back = new JButton("Homepage");
	back.setBounds(85,280,175,25);
	this.add(back);
	
	regUserSuccess = new JLabel("");
	regUserSuccess.setBounds(10,170,200,25);
	this.add(regUserSuccess);
	}
	
	
	public void addButtonActionListener(ActionListener RegUserListener, ActionListener BackListener) {
		login.addActionListener(RegUserListener);
		back.addActionListener(BackListener);
		
	}
}