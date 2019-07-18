package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaMail {

    @FXML
    private TextField email;

    @FXML
    private TextField message;

    @FXML
    private TextField subjectOfUser;

    private String USER_NAME = "breastcancerdetection10@gmail.com";  // GMail user name of sender (just the part before "@gmail.com")
    private String PASSWORD = "breastcancer"; // GMail password of sender

    private String RECIPIENT = "ayush.b.1998@gmail.com";

   /* public static void main(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = " 1st TrialMail from Ayush";
        String body = "hi ayush bob!";

        sendFromGMail(from, pass, to, subject, body);
    } */

    public void sendMail(ActionEvent event){

        String from = USER_NAME;
        String pass = PASSWORD;
        String personto = email.getText();
        String[]to =  { personto };
        String body= message.getText();
        String subject = subjectOfUser.getText();
        sendFromGMail(from, pass, to, subject, body);
    }
    public void sendFromGMail(String from, String pass, String[] to, String subject, String body) {

        // STEP 1 -> Get the session Object
        //////////////////////////////////////////////
        Properties props = System.getProperties();
        String host = "smtp.gmail.com"; //this is the smtp server provided by gmail. Either we can download
        //external smtp server but here we are using smtp server of gmail

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");


        Session session = Session.getDefaultInstance(props); //  Getting the session Object passing properties as paramater.

        //STEP 2 -> Composing the message
        ////////////////////////////////////////////////////
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);

            // STEP 3 -> Send the message
            //////////////////////////////////////////////////

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}