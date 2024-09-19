/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email;

/**
 *
 * @author admin
 */
// PasswordUtils.java
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class PasswordUtils {
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] encodeHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//            StringBuilder hString = new StringBuilder();
//            for (byte b : encodedHash) {
//                
//            }
//            return hString.toString();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String shiftPassword(String password) {
        if (password == null) {
            return "Loi pass"; // hoặc ném ra ngoại lệ tùy theo cách bạn muốn xử lý
        }

        StringBuilder str = new StringBuilder();
        for (char ch : password.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                str.append((char) ((ch - 'a' + 1) % 26 + 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                str.append((char) ((ch - 'A' + 2) % 26 + 'A'));
            } else if (ch >= '0' && ch <= '9') {
                str.append((char) ((ch - '0' + 3) % 10 + '0'));
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
     public String ReverPassword(String password) {
        if (password == null) {
            return "Loi pass"; // hoặc ném ra ngoại lệ tùy theo cách bạn muốn xử lý
        }

        StringBuilder str = new StringBuilder();
        for (char ch : password.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                str.append((char) ((ch - 'a' - 1) % 26 + 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                str.append((char) ((ch - 'A' - 2) % 26 + 'A'));
            } else if (ch >= '0' && ch <= '9') {
                str.append((char) ((ch - '0' - 3) % 10 + '0'));
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
