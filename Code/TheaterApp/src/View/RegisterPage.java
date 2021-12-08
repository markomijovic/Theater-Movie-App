package View;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPage extends Page {
	private  JLabel usernameLabel;
	public  JTextField userText;
	private  JLabel passwordLabel;
	public  JTextField passwordText;
	private  JLabel nameLabel;
	public  JTextField nameText;
	private  JLabel phoneLabel;
	public  JTextField phoneText;
	private  JLabel emailLabel;
	public  JTextField emailText;
	private  JLabel nameOnCardLabel;
	public  JTextField nameOnCardText;
	private  JLabel cardNumberLabel; //name on card
	public  JTextField cardNumberText;
	private  JLabel cvvLabel; 
	public  JTextField cvvText;
	private  JLabel expiryMonthLabel; 
	public  JTextField expiryMonthText;
	private  JLabel expiryYearLabel; 
	public  JTextField expiryYearText;
	
	
	
	public  JButton register;
	private JButton back;
	public  JLabel regUserSuccess;
	
	public RegisterPage() {
		this.setSize(350, 500);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Register Page");
        title.setBounds(120, 15, 570, 20);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);
        
        
        usernameLabel = new JLabel("Username");
    	usernameLabel.setBounds(10,50,80,25);
    	this.add(usernameLabel);
    	
    	userText = new JTextField(20);
    	userText.setBounds(100,50,165,25);
    	this.add(userText);
        
    	passwordLabel = new JLabel("Password");
    	passwordLabel.setBounds(10,80,80,25);
    	this.add(passwordLabel);
    	
    	
    	passwordText = new JTextField(20);
    	passwordText.setBounds(100,80,165,25);
    	this.add(passwordText);
    	
    	nameLabel = new JLabel("Name");
    	nameLabel.setBounds(10,110,80,25);
    	this.add(nameLabel);
    	
    	
    	nameText = new JTextField(20);
    	nameText.setBounds(100,110,165,25);
    	this.add(nameText);
    	
    	phoneLabel = new JLabel("Phone");
    	phoneLabel.setBounds(10,140,80,25);
    	this.add(phoneLabel);

		phoneText = new JTextField(20);
		phoneText.setBounds(100,140,165,25);
		this.add(phoneText);
    	
    	emailLabel = new JLabel("Email");
    	emailLabel.setBounds(10,170,80,25);
    	this.add(emailLabel);
    	
    	
    	emailText = new JTextField(20);
    	emailText.setBounds(100,170,165,25);
    	this.add(emailText);
    	
    	nameOnCardLabel = new JLabel("Name on Card");
    	nameOnCardLabel.setBounds(10,200,150,25);
    	this.add(nameOnCardLabel);
    	
    	
    	nameOnCardText = new JTextField(20);
    	nameOnCardText.setBounds(100,200,165,25);
    	this.add(nameOnCardText);
    	
    	cardNumberLabel = new JLabel("Card Number");
    	cardNumberLabel.setBounds(10,230,150,25);
    	this.add(cardNumberLabel);
    	
    	
    	cardNumberText = new JTextField(20);
    	cardNumberText.setBounds(100,230,165,25);
    	this.add(cardNumberText);
    	
    	cvvLabel = new JLabel("CVV");
    	cvvLabel.setBounds(10,260,80,25);
    	this.add(cvvLabel);
    	
    	
    	cvvText = new JTextField(20);
    	cvvText.setBounds(100,260,165,25);
    	this.add(cvvText);
    	
    	expiryMonthLabel = new JLabel("Expiry Month");
    	expiryMonthLabel.setBounds(10,290,150,25);
    	this.add(expiryMonthLabel);
    	
    	
    	expiryMonthText = new JTextField(20);
    	expiryMonthText.setBounds(100,290,165,25);
    	this.add(expiryMonthText);
    	
    	expiryYearLabel = new JLabel("Expiry Year");
    	expiryYearLabel.setBounds(10,320,80,25);
    	this.add(expiryYearLabel);
    	
    	
    	expiryYearText = new JTextField(20);
    	expiryYearText.setBounds(100,320,165,25);
    	this.add(expiryYearText);
    	
    	register = new JButton("Register");
    	register.setBounds(100,370,175,25);
    	this.add(register);
    	
    	back = new JButton("Back");
    	back.setBounds(100,400,175,25);
    	this.add(back);
    	
      	}
	
	public void addButtonActionListener(ActionListener RegisterListener, ActionListener BackListener) {
		register.addActionListener(RegisterListener);
		back.addActionListener(BackListener);
	}
}
