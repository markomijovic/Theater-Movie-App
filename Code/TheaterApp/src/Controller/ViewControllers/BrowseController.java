package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.BrowseMoviePage;
import View.BrowseSeatPage;
import View.BrowseShowtimePage;
import View.BrowseTheaterPage;
import Model.TheaterApp;

public class BrowseController extends ViewController {
	
	public BrowseTheaterPage theaterBrowse;
	public BrowseMoviePage movieBrowse;
	public BrowseShowtimePage showtimeBrowse;
	public BrowseSeatPage seatBrowse;
	
	//public TheaterApp theaterApp;
	public BrowseController(BrowseTheaterPage theaterBrowse) {
		this.theaterBrowse = theaterBrowse;
		//theaterBrowse.addButtonActionListener(new RegUserListener(), new GuestListener());
	}
	
	class RegUserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
		System.out.println("something");
		//String username = loginView.userText.getText();
		 
		//boolean x = Boolean.parseBoolean(app.login(username, password)[0]);
		//System.out.println(x);
		
		}
	}
	
	class GuestListener implements ActionListener {
		@Override
		//AppSeting.option="GuestLogin";
		public void actionPerformed(ActionEvent e) {
		//loginView.setVisible(false);
		System.out.println("TEST");
		//showGuestUserPage();
		}
	}

}