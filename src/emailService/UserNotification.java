package emailService;


import java.util.LinkedList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Product;
import model.User;
 
public class UserNotification {
 
	final String username = "dummy.trial.2000@gmail.com";
	final String password = "Abhijeet@15864";
	final String sub = "Confirmation of purchase order from the ReadER";
	
	public void sentMail(User user, LinkedList<Product> c) {
  
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props, new javax.mail.Authenticator() { protected PasswordAuthentication getPasswordAuthentication() {  return new PasswordAuthentication(username, password); } });
 		try {

			Message m1 = new MimeMessage(session);
			m1.setFrom(new InternetAddress(username));
			m1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			m1.setSubject(sub);
			String text = generateText(user,c);
			m1.setText(text);
 
			Transport.send(m1);
 
			System.out.println("The mail has been send to the customer.");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private String generateText(User user,LinkedList<Product> c){
		
		String text="";
		text = "Thank you "+user.getFirstName()+" for purchasing items from the ReadER\n\n"+"Your items will be shiped to :\n"+user.getAddress1()+" "+user.getAddress2()+"\n\n";
		text += "\n\nDetails of Purchase: \n";
		
		for(int i=0;i<c.size();i++){
			Product p = c.get(i); 
			String item="";
			item.valueOf(i+1);
			text += "\n\nITEM "+item+"\n"+"Product purchased: "+p.getProductName()+"\n"+"Product price: "+p.getPrice()+"\n"+"Product Code"+p.getProductCode()+"\n\n"; 
		}
		
		text += "Thank you for purchasing the items with us. \n They will be shiped to your destination in 3/4 businnes days.\n\nThanks,\ntheReadER";
		
		return text;
		
	}
	
}

