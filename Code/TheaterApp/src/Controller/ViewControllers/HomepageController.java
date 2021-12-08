package Controller.ViewControllers;

import View.HomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomepageController extends ViewController {
    public HomePage theView;
    public HomepageController(HomePage theView) {
        this.theView = theView;
        theView.addButtonActionListener(new BrowseListener(),
                new BuyListener(), new RegisterListener(),
                new LoginListener(), new CancelListener());
    }

    class BrowseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //AppSeting.option="buy";
            theView.setVisible(false);
            showBrowsePage();
        }
    }

    class BuyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //AppSeting.option="booking";
            theView.setVisible(false);
            //showBuyPage();
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setVisible(false);
            showRegisterPage();
        }
    }
    
    
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //AppSeting.option="goToLogin";
            theView.setVisible(false);
            showLoginPage();
        }
    }
    
    class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //AppSeting.option="goToLogin";
            theView.setVisible(false);
            showCancelTicketPage();
        }
    }
    
    
    
}
