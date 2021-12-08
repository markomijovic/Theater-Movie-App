package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.LoginPage;
import Model.TheaterApp;

public class LoginPageController extends ViewController {
	public LoginPage loginView;
	//public TheaterApp theaterApp;
	public LoginPageController(LoginPage loginView) {
		this.loginView = loginView;
		loginView.addButtonActionListener(new RegUserListener(), new BackListener());
	}
	
	class RegUserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		
		String username = loginView.userText.getText();
		String password = loginView.passwordText.getText();
		boolean x = Boolean.parseBoolean(app.login(username, password)[0]);
		System.out.println(x);
		if (x) {
			loginView.setVisible(false);
			showBrowsePage();
		}
		
		}
	}
	
	class BackListener implements ActionListener {
		@Override
		//AppSeting.option="GuestLogin";
		public void actionPerformed(ActionEvent e) {
		loginView.setVisible(false);
		System.out.println("Back button pressed");
		showHomePage();
		}
	}

}


