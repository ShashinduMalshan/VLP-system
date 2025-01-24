package com.assignment.service.Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.concurrent.Task;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationController {

    public TextField txtSubject;
    public TextArea txtBody;
    public String customerEmail = "shasidumalshan9579@gmail.com";

    // Sends email with the given subject and body to the provided email
    public void findEmail(String email, String timeDuration, String id, int totalPoint, String name) {
        if (email == null) {
            return;
        }

        String subject = "License Suspension Due to Violation Points";
        String body = "Dear "+name+",\n\n"
                + "We are writing to inform you that your driving license has been suspended due to exceeding the maximum allowable violation points.\n\n"
                + "Details of the suspension:\n\n"
                + "License Number: "+id+"\n"
                + "Total Violation Points: "+totalPoint+"\n"
                + "Suspension Time  Duration: "+timeDuration+"\n\n"
                + "Please ensure that you comply with all traffic laws moving forward to avoid further violations. If you have any questions or would like to appeal the suspension, please contact us at 0716589745.\n\n"
                + "Thank you for your attention to this matter.\n\n"
                + "Best regards,\n"
                + "arjun fernando\n"
                + "Department Head\n";
        // Get body from the text field

        sendEmailWithGmail("shasidumalshan9579@gmail.com", email, subject, body);
    }

    // Send email with the given parameters using Gmail SMTP
    private void sendEmailWithGmail(String from, String to, String subject, String messageBody) {

        String PASSWORD = "wqcb tmky fmwv mrgi";  // Be sure to handle this securely

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, PASSWORD); // Replace with your email and password
            }
        });

        // Run the email sending task in a background thread
        Task<Void> emailTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    message.setSubject(subject);
                    message.setText(messageBody);

                    Transport.send(message);

                    // Update the UI on the JavaFX Application Thread after the email is sent
                    Platform.runLater(() -> new Alert(Alert.AlertType.INFORMATION, "Email sent successfully!").show());

                } catch (MessagingException e) {
                    e.printStackTrace();

                    // Update the UI on the JavaFX Application Thread if sending fails
                    Platform.runLater(() -> new Alert(Alert.AlertType.ERROR, "Failed to send email.").show());
                }
                return null;
            }
        };

        // Run the email sending task in a background thread
        new Thread(emailTask).start();
    }

    public void sendUsingGmailOnAction(ActionEvent actionEvent) {
        // Optional: You can add any additional logic here if you need to trigger the email on button press
    }
}
