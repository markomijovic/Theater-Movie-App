package View;

public class TheaterUI {
	private Page activePage;
	
	public TheaterUI() {
		activePage = new HomePage();
	}
	
	public String[] interactWithUser() {
		return activePage.interactWithUser();
	}

	public void sendMessage(String message) {
		activePage.sendMessage(message);
	}
	
	public void switchPage(int pageId) {
		switch (pageId) {
		case 0: 
			activePage = new HomePage();
			break;
		case 1:
			activePage = new LoginPage();
			break;
		default:
			activePage = new HomePage();
			break;
		}
	}
}
