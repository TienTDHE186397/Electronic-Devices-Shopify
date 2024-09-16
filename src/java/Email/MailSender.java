/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email;

/**
 *
 * @author admin
 */
import Entity.Person;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {

    public static void sendVerificationEmail(String recipientEmail, String verificationCode) {
        if (recipientEmail == null || recipientEmail.isEmpty()) {
            throw new IllegalArgumentException("Email không thể là null hoặc rỗng");
        }
        if (verificationCode == null || verificationCode.isEmpty()) {
            throw new IllegalArgumentException("Mã xác thực không thể là null hoặc rỗng");
        }
        String subject = "Code to be verification";
        String message = "Your code is: " + verificationCode;

        // Thiết lập cấu hình SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo session email
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vuahaitac1543@gmail.com", "asdc pyrk falq hcoa"); // Thay bằng email và mật khẩu của bạn
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("vuahaitac1543@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Giả sử token là một chuỗi ngẫu nhiên
        // Bạn nên tạo một token ngẫu nhiên và lưu trữ nó
        SecureRandom random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        // Gửi email xác thực với token
        sendVerificationEmail("Sonnvhhe182275@fpt.edu.vn", token);

    }
}
