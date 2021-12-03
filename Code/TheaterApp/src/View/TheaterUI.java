package View;

public class TheaterUI {
	private Page activePage;
	
	public TheaterUI() {
		activePage = new HomePage();
	}
	
	public String[] interactWithUser(String[] modelInput) {
		return activePage.interactWithUser(modelInput);
	}
	
	public void switchPage(int pageId) {
		switch (pageId) {
		case 0: 
			activePage = new HomePage();
			break;
		default:
			activePage = new HomePage();
			break;
		}
	}
}
