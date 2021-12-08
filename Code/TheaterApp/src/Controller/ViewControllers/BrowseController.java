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
	
	public BrowseController(BrowseTheaterPage theaterBrowse,
							BrowseMoviePage movieBrowse,
							BrowseShowtimePage showtimeBrowse,
							BrowseSeatPage seatBrowse) {
		this.theaterBrowse = theaterBrowse;
		this.movieBrowse = movieBrowse;
		this.showtimeBrowse = showtimeBrowse;
		this.seatBrowse = seatBrowse;
		theaterBrowse.addButtonActionListener(new HomepageListener(), new SelectTheaterListener());
		movieBrowse.addButtonActionListener(new HomepageListener(), new SelectMovieListener());
		showtimeBrowse.addButtonActionListener(new HomepageListener(), new SelectShowtimeListener());
		seatBrowse.addButtonActionListener(new HomepageListener(), new BuyTicketListener());
	}
	
	class HomepageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theaterBrowse.setVisible(false);
			movieBrowse.setVisible(false);
			showtimeBrowse.setVisible(false);
			seatBrowse.setVisible(false);
			System.out.println("Homepage button pressed");
			showHomePage();
		}
	}
	class SelectTheaterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Theater selected");
		}
	}
	class SelectMovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Movie selected");
		}
	}
	class SelectShowtimeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Showtime selected");
		}
	}
	class BuyTicketListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			seatBrowse.setVisible(false);
			System.out.println("Seat selected");
			showBuyPage(theaterBrowse.selectionText.getText(), 
					    movieBrowse.selectionText.getText(), 
					    showtimeBrowse.selectionText.getText(), 
					    seatBrowse.selectionText.getText());
		}
	}

}