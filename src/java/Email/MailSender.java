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
import Entity.Product;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import java.text.*;
import java.util.Currency;

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
    
     public static String formatCurrency(double amount) {
        DecimalFormat currencyFormat = new DecimalFormat("##,###,###.00");  // Hoặc sử dụng "¤###,###.00" cho tiền tệ
        return currencyFormat.format(amount);
    }

    public static void sendAccountBank(String recipientEmail, Banks banks, OrderInformation Order, double total) {
        if (recipientEmail == null || recipientEmail.isEmpty()) {
            throw new IllegalArgumentException("Email không thể là null hoặc rỗng");
        }
//        if (verificationCode == null || verificationCode.isEmpty()) {
//            throw new IllegalArgumentException("Mã xác thực không thể là null hoặc rỗng");
//        }

        String format = formatCurrency(total);
        String subject = "Payment from WebDienTu";
        String message = "<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\" %>\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Arial, sans-serif;\n"
                + "        }\n"
                + "        .order-summary {\n"
                + "            margin: 20px;\n"
                + "            padding: 20px;\n"
                + "            border: 1px solid #ddd;\n"
                + "            border-radius: 5px;\n"
                + "        }\n"
                + "        .order-summary h2 {\n"
                + "            color: #333;\n"
                + "        }\n"
                + "        .order-summary p {\n"
                + "            margin: 5px 0;\n"
                + "        }\n"
                + "        .highlight {\n"
                + "            font-weight: bold;\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"order-summary\">\n"
                + "        <h2>Thank you for shopping!</h2>\n"
                + "        <p>Here is your information:</p>\n"
                + "        <p><span class=\"highlight\">Order ID:</span> " + Order.getOrderID() + "</p>\n"
                + "        <p><span class=\"highlight\">Họ và tên:</span> " + Order.getName() + "</p>\n"
                + "        <p><span class=\"highlight\">Email:</span> " + recipientEmail + "</p>\n"
                + "        <p><span class=\"highlight\">Số điện thoại:</span> " + Order.getPhone() + "</p>\n"
                + "        <p><span class=\"highlight\">Địa chỉ nhận hàng:</span>  " + Order.getAddress() + "</p>\n"
                + "        <p><span class=\"highlight\">Phương thức thanh toán:</span> " + Order.getPayment() + "</p>\n"
                + "        <p><span class=\"highlight\">Total Cost:</span> "+format+"</p>\n"
                + "        <h3>Thông tin chuyển khoản:</h3>\n"
                + "        <p><span class=\"highlight\">Ngân hàng:</span> " + banks.getBankName() + "</p>\n"
                + "        <p><span class=\"highlight\">Số tài khoản:</span> " + banks.getAccountNumber() + "</p>\n"
                + "        <p><span class=\"highlight\">Tên tài khoản:</span> " + banks.getAccountName() + "</p>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
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
            msg.setContent(message, "text/html; charset=utf-8");

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
        sendAccountBank("nghiemducls123@gmail.com", bank, op, 0);
//        sendVerificationEmail("Sonnvhhe182275@fpt.edu.vn", token);

    }
}
