package pl.kocie_stopki.kocie.controller;

import org.springframework.mail.javamail.JavaMailSender;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailCreateISend {
    public static void sendMail(String recepient) {
        System.out.println("Prepering na Email to customer");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);

        String myAccountEmail = "kociestopkiapi@gmail.com";
        String password = "K0[i3...";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMassage(session, myAccountEmail, recepient);
    }

    private static Message prepareMassage(Session session,String myAccountEmail,String recepient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Order confirmation mail");
            message.setSentDate(new Date());
            message.setText("Dear Customer," +
                    " \n Your order data are in PDF file attachment." +
                    " \n We hope we see You again." +
                    " \n Team of KocieStopki.com");

            FileDataSource fileDataSource = new FileDataSource("order.pdf");


            message.setDataHandler(new DataHandler(fileDataSource));
            message.setFileName(fileDataSource.getName());

        } catch (MessagingException e) {
            Logger.getLogger(JavaMailSender.class.getName()).log(Level.SEVERE, null,e);
        }
        return null;
    }
}
