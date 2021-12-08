package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomePage extends Page {
    private JButton browseButton;
    private JButton registerButton;
    private JButton loginButton;
    private JButton cancelButton;
    
    public HomePage() {
        this.setSize(350, 500);
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
        registerButton=new JButton("Register");
        registerButton.setBounds(50, 190, 237, 43);
        this.add(registerButton);
        loginButton=new JButton("Login");
        loginButton.setBounds(50, 290, 237, 43);
        this.add(loginButton);
        cancelButton=new JButton("Cancel a Ticket");
        cancelButton.setBounds(50, 390, 237, 43);
        this.add(cancelButton);
    }

    public void addButtonActionListener(ActionListener browseListener,
                                  ActionListener registerListener,
                                  ActionListener loginListener,
                                  ActionListener cancelListener) {
        browseButton.addActionListener(browseListener);
        registerButton.addActionListener(registerListener);
        loginButton.addActionListener(loginListener);
        cancelButton.addActionListener(cancelListener);
    }
}
