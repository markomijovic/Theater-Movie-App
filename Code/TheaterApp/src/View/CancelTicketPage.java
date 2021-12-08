package View;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CancelTicketPage extends Page {

	private  JLabel theaterIDLabel;
	public  JTextField theaterIDText;
	private  JLabel movieIDLabel;
	public  JTextField movieIDText;
	private  JLabel showtimeIDLabel;
	public  JTextField showtimeIDText;
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

        theaterIDLabel = new JLabel("Theater ID");
        theaterIDLabel.setBounds(10,70,80,25);
    	this.add( theaterIDLabel);
    	
    	theaterIDText = new JTextField(20);
    	theaterIDText.setBounds(100,70,165,25);
    	this.add(theaterIDText);

        movieIDLabel = new JLabel("Movie ID");
        movieIDLabel.setBounds(10,100,80,25);
    	this.add( movieIDLabel);
    	
    	movieIDText = new JTextField(20);
    	movieIDText.setBounds(100,100,165,25);
    	this.add(movieIDText);

        showtimeIDLabel = new JLabel("Showtime ID");
        showtimeIDLabel.setBounds(10,130,80,25);
    	this.add( showtimeIDLabel);
    	
    	showtimeIDText = new JTextField(20);
    	showtimeIDText.setBounds(100,130,165,25);
    	this.add(showtimeIDText);
    	
        ticketIDLabel = new JLabel("Ticket ID");
        ticketIDLabel.setBounds(10,160,80,25);
    	this.add( ticketIDLabel);
    	
    	ticketIDText = new JTextField(20);
    	ticketIDText.setBounds(100,160,165,25);
    	this.add(ticketIDText);
    	
    	cancel = new JButton("Confirm Cancellation");
    	cancel.setBounds(85,130,200,25);
    	this.add(cancel);
    	
    	back = new JButton("Back");
    	back.setBounds(85,200,250,25);
    	this.add(back);
    	
	}
	
	public void addButtonActionListener(ActionListener CancelListener, ActionListener BackListener) {
		cancel.addActionListener(CancelListener);
		back.addActionListener(BackListener);
		
	}

}