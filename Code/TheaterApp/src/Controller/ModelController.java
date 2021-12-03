package Controller;

import Model.TheaterApp;
import View.TheaterUI;

public class ModelController {
	
	private TheaterApp myModel;
	private TheaterUI myUI;
	
	ModelController() {
		myModel = new TheaterApp();
		myUI = new TheaterUI();
	}

	public void run() {
		int pageId = 0;
		String[] result;
		
		while (pageId >= 0) {
			switch (pageId) {
			case 0: 
				result = myUI.interactWithUser(null);
				pageId = Integer.parseInt(result[0]);
				myUI.switchPage(pageId);
				break;
			default:
				pageId = -1;
				break;
			}
		}
	}
	
	public static void main (String[] arg) {
		ModelController app = new ModelController();
		app.run();
	}
}
