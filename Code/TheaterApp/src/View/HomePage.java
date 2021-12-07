package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePage extends Page {
    private JButton browseButton;
    private JButton buyButton;
    private JButton registerButton;
    public HomePage() {
        this.setSize(350, 400);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title=new JLabel("Movie Ticket System");
        title.setBounds(70, 15, 570, 20);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);

        browseButton=new JButton("Browse");
        browseButton.setBounds(50, 90, 237, 43);
        this.add(browseButton);
        buyButton=new JButton("Buy Tickets");
        buyButton.setBounds(50, 190, 237, 43);
        this.add(buyButton);
        registerButton=new JButton("Register");
        registerButton.setBounds(50, 290, 237, 43);
        this.add(registerButton);
    }

    public void addButtonActionListener(ActionListener browseListener,
                                  ActionListener buyListener,
                                  ActionListener registerListener) {
        browseButton.addActionListener(browseListener);
        buyButton.addActionListener(buyListener);
        registerButton.addActionListener(registerListener);
    }

    public void display() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        HomePage p = new HomePage();
        p.display();
    }
}
