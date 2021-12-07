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
			//showBrowsePage();
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
