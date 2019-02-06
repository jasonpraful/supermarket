/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jason Francis
 */
public class EmailVerification {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;
    Properties emailProperties1;
    Session mailSession1;
    MimeMessage emailMessage1;
    Order order = new Order();

    int number = (int) Math.round((Math.random() * 9000) + 1000);

    java.util.Random x = new java.util.Random();
    String newMessage = order.mailOrder;

    public void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    public void createEmailMessage() throws AddressException,
            MessagingException {

        String emailSubject = "Shopping System OTP";
        System.out.println("OTP is:- " + number);
        String emailBody = "Hi,\n The OTP to complete registration is- " + number;

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");//for a html email
        //emailMessage.setText(emailBody);// for a text email

    }

    public void createEmailMessage1() throws AddressException,
            MessagingException {

        String emailSubject = "Shopping System Order Confirmation";
        System.out.println("order email sent");
        String emailBody = order.getOrderMessage();

        mailSession1 = Session.getDefaultInstance(emailProperties1, null);
        emailMessage1 = new MimeMessage(mailSession1);

        emailMessage1.setSubject(emailSubject);
        emailMessage1.setContent(emailBody, "text/html");//for a html email
        //emailMessage.setText(emailBody);// for a text email

    }
    Transport transport;

    public void connectMailBox() throws AddressException, MessagingException {
        String emailHost = "smtp.gmail.com";
        String fromUser = "shopingprojkect@gmail.com";//just the id alone without @gmail.com
        String fromUserEmailPassword = "Shopping@1";
        transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);

    }

    public void sendEmail(String src) throws AddressException, MessagingException {

        String toEmails = src;
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

    public void sendEmail1(String src) throws AddressException, MessagingException {

        String toEmails = src;
        emailMessage1.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));
        transport.sendMessage(emailMessage1, emailMessage1.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

}
