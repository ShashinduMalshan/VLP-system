package com.assignment.service.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationController {
    public TextField txtSubject;
    public TextArea txtBody;
    public String customerEmail = "shasidumalshan9579@gmail.com";




      
  
        private void sendEmailWithGmail(String from, String to, String subject, String messageBody) {

            String PASSWORD = "wqcb tmky fmwv mrgi";

            Properties props = new Properties();

            props.put("mail.smtp.auth", "true");

            props.put("mail.smtp.starttls.enable", "true");

            props.put("mail.smtp.host", "smtp.gmail.com");

            props.put("mail.smtp.port", "587");


            Session session = Session.getInstance(props, new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, PASSWORD); // Replace with your email and password
                }
            });

            try {
                Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress(from));


                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

                message.setSubject(subject);

                message.setText(messageBody);


                Transport.send(message);

                new Alert(Alert.AlertType.INFORMATION, "Email sent successfully!").show();
            } catch (MessagingException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Failed to send email.").show();
            }
        }

    public void sendUsingGmailOnAction(ActionEvent actionEvent) {
        if (customerEmail == null) {
            return;
        }

        final String FROM = "shasidumalshan9579@gmail.com";

        String subject = txtSubject.getText();
        String body = txtBody.getText();

        if (subject.isEmpty() || body.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Subject and body must not be empty!").show();
            return;
        }


        sendEmailWithGmail(FROM, customerEmail, subject, body);

    }
}
