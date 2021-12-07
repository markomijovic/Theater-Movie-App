package View;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public abstract class Page extends JFrame {

	public abstract String[] interactWithUser();
	public void sendMessage(String[] message) {}
	public void loadModelInfo(String[] pageInput) {}

}
