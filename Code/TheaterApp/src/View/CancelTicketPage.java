package View;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CancelTicketPage extends Page {
	
	private  JLabel ticketIDLabel;
	public  JTextField ticketIDText;
	public  JButton cancel;
	public  JLabel regUserSuccess;
	private  JButton back;
	
	public CancelTicketPage() {
		this.setSize(350, 400);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Cancel Ticket Page");
        title.setBounds(100, 15, 570, 20);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);
	
        ticketIDLabel = new JLabel("Ticket ID");
        ticketIDLabel.setBounds(10,70,80,25);
    	this.add( ticketIDLabel);
    	
    	ticketIDText = new JTextField(20);
    	ticketIDText.setBounds(100,70,165,25);
    	this.add(ticketIDText);
    	
    	cancel = new JButton("Confirm Cancellation");
    	cancel.setBounds(85,130,175,25);
    	this.add(cancel);
    	
    	back = new JButton("Back");
    	back.setBounds(85,200,175,25);
    	this.add(back);
    	
	}
	
	public void addButtonActionListener(ActionListener CancelListener, ActionListener BackListener) {
		cancel.addActionListener(CancelListener);
		back.addActionListener(BackListener);
		
	}

}