/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email;

/**
 *
 * @author admin
 */
import Entity.Banks;
import Entity.OrderInformation;
import Entity.OrderProduct;
import Entity.Person;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
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
        properties.put("mail.smtp.host", "smtp.gmail.com");//SMTP HOST
        properties.put("mail.smtp.port", "587");//TLS587 SSL465
        properties.put("mail.smtp.auth", "true");//Phai dang nhap = gmail khi ma dang nhap bang host thi phai dang nhap la true
        properties.put("mail.smtp.starttls.enable", "true"); // giao thuc can dung la smpt.starttls  true

        // Tạo session email
        // lay ra 1 cai authenticator de dang nhap vao email
        Session session = Session.getInstance(properties, new Authenticator() {
            // tao mot cai phien dang nhap
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

    public static void sendAccountBank(String recipientEmail, Banks banks, OrderInformation Order) {
        if (recipientEmail == null || recipientEmail.isEmpty()) {
            throw new IllegalArgumentException("Email không thể là null hoặc rỗng");
        }
//        if (verificationCode == null || verificationCode.isEmpty()) {
//            throw new IllegalArgumentException("Mã xác thực không thể là null hoặc rỗng");
//        }
        String subject = "Payment from WebDienTu";
        String message = "Thank you for shopping!!!\n"
                + "Here is your information:\n"
                + "OrderID: " + Order.getOrderID() +"\n"
                + "Họ và tên: "+Order.getName()+"\n"
                + "\n"
                + "Email: "+recipientEmail+"\n"
                + "\n"
                + "Số điện thoại: "+Order.getPhone()+"\n"
                + "\n"
                + "Địa chỉ nhận hàng: "+Order.getAddress()+"\n"
                + "\n"
                + "Phương thức thanh toán: "+Order.getPayment()+"\n"
                + "\n"
                + "Total Cost: 41700.0đ\n"
                + "Thông tin chuyển khoản:\n"
                + "Ngân hàng: " + banks.getBankName() + "\n"
                + "Số tài khoản: " + banks.getAccountNumber()+ "\n"
                + "Tên tài khoản: " + banks.getAccountName();

        // Thiết lập cấu hình SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");//SMTP HOST
        properties.put("mail.smtp.port", "587");//TLS587 SSL465
        properties.put("mail.smtp.auth", "true");//Phai dang nhap = gmail khi ma dang nhap bang host thi phai dang nhap la true
        properties.put("mail.smtp.starttls.enable", "true"); // giao thuc can dung la smpt.starttls  true

        // Tạo session email
        // lay ra 1 cai authenticator de dang nhap vao email
        Session session = Session.getInstance(properties, new Authenticator() {
            // tao mot cai phien dang nhap
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
        OrderInformation op = new OrderInformation();
        Banks bank = new Banks();
        // Gửi email xác thực với token
        sendAccountBank("nghiemducls123@gmail.com", bank, op);
//        sendVerificationEmail("Sonnvhhe182275@fpt.edu.vn", token);

    }
}
