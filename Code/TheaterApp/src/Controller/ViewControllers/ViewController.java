package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.TheaterApp;
import View.*;

public class ViewController {
	
	public TheaterApp app = TheaterApp.getInstance();

    public void showBrowsePage() {
    	BrowseTheaterPage theater = new BrowseTheaterPage();
    	BrowseMoviePage movie = new BrowseMoviePage();
    	BrowseShowtimePage showtime = new BrowseShowtimePage();
    	BrowseSeatPage seat = new BrowseSeatPage();
    	PaymentPage pay = new PaymentPage();
    	ViewController q= new BrowseController(theater, movie, showtime, seat, pay);
    	theater.display();
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
