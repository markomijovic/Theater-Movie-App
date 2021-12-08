package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BrowseSeatPage extends Page {
	public  JTextField selectionText;
	public  JButton buyTicketButton;
	public  JButton homepageButton;
	public JTextArea displayArea;
	
	public BrowseSeatPage() {
		this.setSize(470, 400);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setLayout(null);
        JLabel title = new JLabel("Browse Seats Page");
        title.setBounds(130, 15, 570, 30);
        title.setFont(new Font("Ariel", Font.BOLD, 20));
        this.add(title);

        JLabel selectionPromptLabel = new JLabel("Seat Id: ");
        selectionPromptLabel.setBounds(10,70,80,25);
        this.add(selectionPromptLabel);
	
        selectionText = new JTextField(20);
        selectionText.setBounds(100,70,165,25);
        this.add(selectionText);
	
        buyTicketButton = new JButton("Buy Ticket");
        buyTicketButton.setBounds(275,70,160,25);
        this.add(buyTicketButton);

        JPanel middlePanel = new JPanel ();
        middlePanel.setBounds(10,110,430,175);
        displayArea = new JTextArea(10,37 );
        displayArea.setEditable ( false ); // set textArea non-editable
        JScrollPane scroll = new JScrollPane ( displayArea );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        middlePanel.add ( scroll );
        this.add(middlePanel);

        homepageButton = new JButton("Homepage");
        homepageButton.setBounds(155,300,160,25);
        this.add(homepageButton);
	}
	
	public static void main ( String[] args )
	{
		Page m = new BrowseSeatPage();
		m.display();
	}
}
