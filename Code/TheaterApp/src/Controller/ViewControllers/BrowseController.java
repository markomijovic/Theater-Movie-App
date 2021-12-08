package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.PaymentInfo;
import Model.Showing;
import Model.Theater;
import View.BrowseMoviePage;
import View.BrowseSeatPage;
import View.BrowseShowtimePage;
import View.BrowseTheaterPage;
import View.PaymentPage;
import Model.TheaterApp;

public class BrowseController extends ViewController {
	
	public BrowseTheaterPage theaterBrowse;
	public BrowseMoviePage movieBrowse;
	public BrowseShowtimePage showtimeBrowse;
	public BrowseSeatPage seatBrowse;
	public PaymentPage paymentPage;
	
	public BrowseController(BrowseTheaterPage theaterBrowse,
							BrowseMoviePage movieBrowse,
							BrowseShowtimePage showtimeBrowse,
							BrowseSeatPage seatBrowse,
							PaymentPage paymentPage) {
		this.theaterBrowse = theaterBrowse;
		this.movieBrowse = movieBrowse;
		this.showtimeBrowse = showtimeBrowse;
		this.seatBrowse = seatBrowse;
		this.paymentPage = paymentPage;
		String[] myListOfTheaters = app.getTheaters();
		String res = "";
		for (String s : myListOfTheaters) {
			res += s + "\n" + "-----------" + "\n\n";
		}
		theaterBrowse.displayArea.setText(res);
		theaterBrowse.setVisible(true);
		theaterBrowse.addButtonActionListener(new HomepageListener(), new SelectTheaterListener());
		movieBrowse.addButtonActionListener(new HomepageListener(), new SelectMovieListener());
		showtimeBrowse.addButtonActionListener(new HomepageListener(), new SelectShowtimeListener());
		seatBrowse.addButtonActionListener(new HomepageListener(), new PayTicketListener());
		paymentPage.addButtonActionListener(new HomepageListener(), new BuyTicketListener());
	}
	
	class HomepageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theaterBrowse.setVisible(false);
			movieBrowse.setVisible(false);
			showtimeBrowse.setVisible(false);
			seatBrowse.setVisible(false);
			paymentPage.setVisible(false);
			System.out.println("Homepage button pressed");
			showHomePage();
		}
	}
	class SelectTheaterListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> myListOfMovies = app.getMovies(theaterBrowse.selectionText.getText());
			String res = "";
			for (String s : myListOfMovies) {res += s + "\n";}
			theaterBrowse.setVisible(false);
			movieBrowse.displayArea.setText(res);
			movieBrowse.setVisible(true);

			System.out.println("Theater selected");
		}
	}
	// This one shows showings for a movie selection
	class SelectMovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theaterBrowse.setVisible(false);
			ArrayList<Showing> myListOfShowings = app.getShowings(theaterBrowse.selectionText.getText(), movieBrowse.selectionText.getText());
			String res = "";
			for (Showing s : myListOfShowings) {res += s.getShowingInfo()+"\n";}
			movieBrowse.setVisible(false);
			showtimeBrowse.displayArea.setText(res);
			showtimeBrowse.setVisible(true);
			System.out.println("Movie selected");
		}
	}
	// Shows seats for a showing selection
	class SelectShowtimeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			movieBrowse.setVisible(false);
			String[][] res = app.getSeats(theaterBrowse.selectionText.getText(),
													  movieBrowse.selectionText.getText(), showtimeBrowse.selectionText.getText());
			String actualRES="";
			for (int i = 0; i < 5; i++) {
				actualRES += "row"+(i+1)+": ";
				for (int j = 0; j < 5; j++) {
					actualRES += res[i][j] + "  ";
				}
				actualRES += "\n";
			}
			actualRES += "   col: 1, 2, 3, 4, 5";
			showtimeBrowse.setVisible(false);
			seatBrowse.displayArea.setText(actualRES);
			seatBrowse.setVisible(true);
			System.out.println("Showtime selected");
		}
	}
	class PayTicketListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			seatBrowse.setVisible(false);
			PaymentInfo myPaymentInfo = app.getPaymentInfo();
			if (myPaymentInfo != null) {
				paymentPage.emailText.setText(myPaymentInfo.getEmail());
				paymentPage.nameOnCardText.setText(myPaymentInfo.getNameOnCard());
				paymentPage.cardNumberText.setText(Integer.toString(myPaymentInfo.getCreditCardNumber()));
				paymentPage.cvvText.setText(Integer.toString(myPaymentInfo.getCCV()));
				paymentPage.expiryMonthText.setText(Integer.toString(myPaymentInfo.getExpiryMonth()));
				paymentPage.expiryYearText.setText(Integer.toString(myPaymentInfo.getExpiryYear()));
			}
			paymentPage.setVisible(true);
			System.out.println("Payment page selected");
		}
	}
	class BuyTicketListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showtimeBrowse.setVisible(false);
			System.out.println("Seat selected");
			app.buyTicket(theaterBrowse.selectionText.getText(),
					movieBrowse.selectionText.getText(),
					showtimeBrowse.selectionText.getText(),
					Integer.valueOf(seatBrowse.rowText.getText()),
					Integer.valueOf(seatBrowse.columnText.getText()),
					new PaymentInfo(paymentPage.emailText.getText(),
							paymentPage.nameOnCardText.getText(),
							Integer.valueOf(paymentPage.cardNumberText.getText()),
							Integer.valueOf(paymentPage.cvvText.getText()),
							Integer.valueOf(paymentPage.expiryMonthText.getText()),
							Integer.valueOf(paymentPage.expiryYearText.getText())));
//			seatBrowse.selectionText.getText(), myPaymentInfo);
		}
	}
}