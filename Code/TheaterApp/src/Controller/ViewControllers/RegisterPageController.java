package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.RegisterPage;

public class RegisterPageController extends ViewController {
	public RegisterPage theView;
	public RegisterPageController (RegisterPage theView) {
		this.theView = theView;
		theView.addButtonActionListener(new RegisterListener(), new BackListener());
	}
	
	class RegisterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Register Button working");
			theView.setVisible(false);
			String username = theView.userText.getText();
			String password = theView.passwordText.getText();
			String name = theView.nameText.getText();
			String phone = theView.phoneText.getText();
			String email = theView.emailText.getText();
			String nameOnCard = theView.nameOnCardText.getText();
			String cardNumberText = theView.cardNumberText.getText();
			int cvv = Integer.valueOf(theView.cvvText.getText());
			int month = Integer.valueOf(theView.expiryMonthText.getText());
			int year = Integer.valueOf(theView.expiryYearText.getText());
			app.register(username, password, name, phone, email, nameOnCard, cardNumberText, cvv, month, year);
		}
	}
	
	class BackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Back Button working");
			 theView.setVisible(false);
			showHomePage();
		}
	}
	
	
}
