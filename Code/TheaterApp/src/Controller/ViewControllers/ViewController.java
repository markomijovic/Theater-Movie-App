package Controller.ViewControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.*;

public class ViewController {
    public void showBrowsePage() {
        System.out.println("clicked browse");
    }

    public void showBuyPage(){}

    public void showRegisterPage(){}

    class QuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
