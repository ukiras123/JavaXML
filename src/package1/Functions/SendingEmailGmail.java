package package1.Functions;

import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmailGmail extends Object {
	public static void main(String[] args) {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			private int i = 10;

			@Override
			public void run() {
				try {
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.auth", "true");
					props.put("mail.debug", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.port", "465");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class",
							"javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.socketFactory.fallback", "false");
					Session mailSession = Session.getInstance(props,
							new javax.mail.Authenticator() {
								@Override
								protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication(
											"kiran9.canvas@gmail.com",
											"7starhotel");
								}
							});
					mailSession.setDebug(true);
					Message msg = new MimeMessage(mailSession);
					msg.setFrom(new InternetAddress("kiran9.canvas@gmail.com"));
					msg.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse("ukiras@gmail.com"));
					msg.setSentDate(new Date());
					msg.setSubject("This is from java");
					msg.setText("Hello from my first e-mail sent with JavaMail");
					Transport.send(msg);
				} catch (Exception E) {
					System.out.println("Oops something has gone pearshaped!");
					System.out.println(E);
				}
				System.out.println("10 Seconds Later");
				if (--i < 1)
					timer.cancel(); // Count down ten times, then cancel
			}
		}, 10000, 10000 // Note the second argument for repetition
		);
	}
}