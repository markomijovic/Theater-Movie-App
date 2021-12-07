package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.TheaterApp;
import View.*;

public class ViewController {
	
	protected TheaterApp app = new TheaterApp();
	
    public void showBrowsePage() {
    	BrowseTheaterPage p = new BrowseTheaterPage();
    	BrowseController q= new BrowseController(p);
        p.display();
    }
    
    public void showHomePage() {
    	HomePage p = new HomePage();
    	HomepageController q= new HomepageController(p);
        p.display();
    }
    
    public void showCancelTicketPage() {
    	CancelTicketPage p = new CancelTicketPage();
    	CancelTicketController q= new CancelTicketController(p);
        p.display();
    }
    
    public void showLoginPage() {
    	
    	LoginPage p = new LoginPage();
    	LoginPageController q= new LoginPageController(p);
        p.display();
  
    }

    public void showBuyPage(){}

    public void showRegisterPage(){
    	RegisterPage p = new RegisterPage();
    	RegisterPageController q= new RegisterPageController(p);
        p.display();
    }
    

    class QuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
