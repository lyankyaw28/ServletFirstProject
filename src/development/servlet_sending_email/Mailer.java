package development.servlet_sending_email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	public static void send(String to, String subject, String msg) {
		final String fromEmail = "compasstaxiinfo@gmail.com";// change accordingly
		final String emailPassword = "yngwie500";
		// 1st step) Get the session object
		Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", fromEmail);
        props.put("mail.smtp.password", emailPassword);
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, emailPassword);
            }
        });
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
            // set message headers
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			try {
				message.setFrom(new InternetAddress(fromEmail, "Compass"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			message.setReplyTo(InternetAddress.parse(fromEmail, false));
			message.setSubject(subject, "UTF-8");
			message.setSentDate(new Date());
			message.setText(msg);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
