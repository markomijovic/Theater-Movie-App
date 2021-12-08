package View;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PaymentPage extends Page {
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
	
	
	
	public  JButton buy;
	private JButton back;
	
	public PaymentPage() {
		this.setSize(350, 500);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Register Page");
        title.setBounds(120, 15, 570, 20);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);
        
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
    	
    	buy = new JButton("Buy");
    	buy.setBounds(100,370,175,25);
    	this.add(buy);
    	
    	back = new JButton("Homepage");
    	back.setBounds(100,400,175,25);
    	this.add(back);
    	
      	}
	
	public void addButtonActionListener(ActionListener HomePageListener, ActionListener BuyTicketListener) {
		buy.addActionListener(BuyTicketListener);
		back.addActionListener(HomePageListener);
	}
}
