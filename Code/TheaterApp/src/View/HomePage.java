package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomePage extends Page {
    private JButton browseButton;
    private JButton buyButton;
    private JButton registerButton;
    private JButton loginButton;
    private JButton cancelButton;
    
    public HomePage() {
        this.setSize(350, 600);
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
        loginButton=new JButton("Login");
        loginButton.setBounds(50, 390, 237, 43);
        this.add(loginButton);
        cancelButton=new JButton("Cancel Ticket");
        cancelButton.setBounds(50, 490, 237, 43);
        this.add(cancelButton);
    }

    public void addButtonActionListener(ActionListener browseListener,
                                  ActionListener buyListener,
                                  ActionListener registerListener,
                                  ActionListener loginListener,
                                  ActionListener cancelListener) {
        browseButton.addActionListener(browseListener);
        buyButton.addActionListener(buyListener);
        registerButton.addActionListener(registerListener);
        loginButton.addActionListener(loginListener);
        cancelButton.addActionListener(cancelListener);
    }


// 	@Override
// 	public String[] interactWithUser() {
// 		String[] result = {"-1"};
// 		System.out.println("Please select an action to be done: ");
// 		System.out.println("(1) Log in");
// 		System.out.println("(2) Register");
// 		System.out.println("(3) Browse Theaters");
// 		System.out.println("(4) Cancel a Ticket");
// 		System.out.println("(5) Quit");

//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
//         int option = -1;
//         while (option < 0) {
//             // Reading data using readLine
//         	try {
//                 option = Integer.parseInt(reader.readLine());
//                 if (option < 0 || option > 4)
//                 	option = -1;
//         	}
//         	catch (Exception e) {
//         		option = -1;
//         	}
//         }
        
//         result[0] = Integer.toString(option);
// 		return result;
// 	}
}
