package View;

public class BrowseMoviePage extends Page {

	@Override
	public String[] interactWithUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(String[] message) {
		int numTheaters = message.length;
		
		for (int i = 0; i < numTheaters; i++) {
			System.out.println(message[i]);
		}
	}

}
