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
			case 0: 
				modelInput = myUI.interactWithUser();
				pageId = Integer.parseInt(modelInput[0]);
				break;
			case 1:
				boolean done = false;
				while (!done) {
					modelInput = myUI.interactWithUser();
					if (Boolean.getBoolean(modelInput[0])) {
						modelOutput = myModel.login(modelInput[1], modelInput[2]);
						myUI.sendMessage(modelOutput[0]);
					}
					else
						done = true;
				}
				pageId = 0;
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
