package Model;

import java.util.ArrayList;

/**
 * This class is used to send messages to users via e-mail.
 */
public class MessageSystem {
	
	/** Sends message to an email.
	 * 
	 *  PROMISES: Sends a given message to a given e-email
	 *  REQUIRES: Valid email and message to be sent
	 */
	private void sendEmail (String email, String message) {
		// To be implemented...
		System.out.println("Email sent to user with email:  \"" + email + "\"");
		System.out.println("Message sent: ");
		System.out.println(message);
	}

	/** Sends ticket purchase confirmation message to a user.
	 * 
	 *  PROMISES: Sends the ticket and purchase information to a user
	 *  REQUIRES: Purchased ticket and buyer
	 */
	public void sendTicketPurchaseConfirmationEmail(User myUser, Ticket myTicket) {
		String message = "Ticket " + myTicket.getId() +
						 " was purchased for $ " + Double.toString(myTicket.getCost()) +
						 "\nTicket information: \n" + myTicket.getSeatInfo();
		sendEmail(myUser.getPaymentInfo().getEmail(), message);
	}

	/** Sends ticket refund confirmation message to a user.
	 * 
	 *  PROMISES: Sends the ticket and refund information to a user
	 *  REQUIRES: Purchased ticket and buyer and voucher
	 */
	public void sendTicketRefundConfirmationEmail(User myUser, Ticket myTicket, Voucher myVoucher) {
		boolean isRegisteredUser = myUser instanceof RegisteredUser;
		String message = "Ticket " + myTicket.getId() +
						 " was refunded for $ " + Double.toString(myVoucher.getRefundValue()) +
						 "\nTicket information: \n" + myTicket.getSeatInfo() +
						 "\nVoucher information: \n" + myVoucher.getInformation();

		if (isRegisteredUser)
			message += "Note that a 15% Administration fee was applied to refund";
		
		sendEmail(myUser.getPaymentInfo().getEmail(), message);
	}

	/** Sends exclusive movie news to all registered users.
	 * 
	 *  PROMISES: Sends exclusive movie news to all registered users.
	 *  REQUIRES: List of registered users and movie news
	 */
	public void sendExclusiveMovieNewsEmail(ArrayList<RegisteredUser> myUsers, String movieNews) {
		for (int i = 0; i < myUsers.size(); i++) {
			String message = "Hey " + myUsers.get(i).getName() +
					 ", we have some exclusive movie news for you:\n " + 
					 movieNews;

			sendEmail(myUsers.get(i).getPaymentInfo().getEmail(), message);
		}
	}
}
