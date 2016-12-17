package vitaCost;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendEmail {
	
	
	
	public static String getMessageFromFile(String path) {
		InputOutputFiles input = new InputOutputFiles();
		return input.readFromFile(path);
		
	}
	
	public static  void mainsend(float expected , float result) {
		Session session;
		String underFortyMessage = "the price is under";
		String upperFortyMessage = "the price is upper than";
		final String username = "henfaibishqa@gmail.com";
		final String to = "zzzi10@gmail.com";
		final String password = "itmaster";
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
	


		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		
	      try {

	          // Create a default MimeMessage object.
	          Message message = new MimeMessage(session);

	          // Set From: header field of the header.
	          message.setFrom(new InternetAddress(username));

	          // Set To: header field of the header.
	          message.setRecipients(Message.RecipientType.TO,
	             InternetAddress.parse(to));

	          // Set Subject: header field
				if (result<expected) {
	          
	          				message.setSubject(underFortyMessage + "  " + expected);
	          				message.setText("Dear Mail Crawler,"
	          						+ "\n\n No spam to my email, please!");
	          			}
	          			else {
	          				message.setSubject(upperFortyMessage + "  " + expected );
	          			}

	          // This mail has 2 part, the BODY and the embedded image
	          MimeMultipart multipart = new MimeMultipart("related");

	          // first part (the html)
	          String msg = getMessageFromFile(VitaCostTestBase.pathFora);
	          BodyPart messageBodyPart = new MimeBodyPart();
	          String htmlText = msg;
	          messageBodyPart.setContent(htmlText, "text/html");
	          // add it
	          multipart.addBodyPart(messageBodyPart);

	          // second part (the image)
	          messageBodyPart = new MimeBodyPart();
	          DataSource fds = new FileDataSource(
	        		  InputOutputFiles.fullPathDirectoryForScreenShots);

	          messageBodyPart.setDataHandler(new DataHandler(fds));
	          messageBodyPart.setFileName(new File(InputOutputFiles.fullPathDirectoryForScreenShots).getName());

	          // add image to the multipart
	          multipart.addBodyPart(messageBodyPart);

	          // put everything together
	          message.setContent(multipart);
	          // Send message
	          Transport.send(message);

	          System.out.println("Sent message successfully....");

	       } catch (MessagingException e) {
	          throw new RuntimeException(e);
	       }



}
}



