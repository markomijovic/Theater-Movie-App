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
		String[] modelInput = null;
		String[] modelOutput = null;
		
		while (pageId >= 0) {
			myUI.switchPage(pageId);
			
			switch (pageId) {
			case 0: //Homepage
				modelInput = myUI.interactWithUser();
				pageId = Integer.parseInt(modelInput[0]);
				break;
			case 1: //Login
				boolean done = false;
				while (!done) {
					modelInput = myUI.interactWithUser();
					if (Boolean.parseBoolean(modelInput[0])) {
						modelOutput = myModel.login(modelInput[1], modelInput[2]);
						myUI.sendMessage(modelOutput[0]);
						if (Boolean.parseBoolean(modelOutput[0])) {
							pageId = 0;
							done = true;
						}
					}
					else
						done = true;
				}
				pageId = 0;
				break;
			case 2: //Register
				break;
			case 3: //Browse Theater
				break;
			case 4: //Cancel ticket
				break;
			default: //Homepage
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
