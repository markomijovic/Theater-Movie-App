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
    
    public void showLoginPage() {
    	
    	LoginPage p = new LoginPage();
    	LoginPageController q= new LoginPageController(p);
        p.display();
  
    }

    public void showBuyPage(){}

    public void showRegisterPage(){}
    
    public void showRegUserPage(){};
    
    public void showGuestUserPage(){};

    class QuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
