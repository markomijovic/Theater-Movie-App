package Controller.ViewControllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.CancelTicketPage;

public class CancelTicketController extends ViewController {
	
	public CancelTicketPage theView;
	
	public CancelTicketController(CancelTicketPage theView) {
		this.theView = theView;
		theView.addButtonActionListener(new CancelListener(), new BackListener());
	}
	
	
	class CancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		theView.setVisible(false);
		System.out.println("Cancel Button Pressed");
		//Cancel the ticket from DB
		}
	}
	
	class BackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		theView.setVisible(false);
		System.out.println("Back button pressed");
		showHomePage();
		}
	}
	
}
