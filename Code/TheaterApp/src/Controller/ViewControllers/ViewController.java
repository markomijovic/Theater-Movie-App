package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.TheaterApp;
import View.*;

public class ViewController {
	
	protected TheaterApp app = new TheaterApp();
	
    public void showBrowsePage() {
        System.out.println("clicked browse");
    }
    
    public void showLoginPage() {
    	
    	LoginPage p = new LoginPage();
    	LoginPageController q= new LoginPageController(p);
        p.display();
    	
        //System.out.println("clicked browse");
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
