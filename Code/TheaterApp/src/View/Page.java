package View;

public abstract class Page {

	public abstract String[] interactWithUser();
	public void sendMessage(String[] message) {}
	public void loadModelInfo(String[] pageInput) {}
}
