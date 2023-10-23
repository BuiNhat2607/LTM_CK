/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 *
 * @author MINHNHAT
 */
public class PasswordHashing {

    private static final int SALT_LENGTH = 16;

    public static String hashPassword(String password) {
        try {
            // Tạo salt ngẫu nhiên
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Đặt salt vào MessageDigest
            md.update(salt);

            // Mã hóa mật khẩu thành mảng byte
            byte[] hashedPassword = md.digest(password.getBytes());

            // Kết hợp salt và mật khẩu đã mã hóa thành một mảng byte
            byte[] saltedHash = new byte[hashedPassword.length + SALT_LENGTH];
            System.arraycopy(salt, 0, saltedHash, 0, SALT_LENGTH);
            System.arraycopy(hashedPassword, 0, saltedHash, SALT_LENGTH, hashedPassword.length);

            // Chuyển mảng byte thành chuỗi ký tự Base64
            String encodedPassword = Base64.getEncoder().encodeToString(saltedHash);

            return encodedPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean checkPassword(String password, String storedHashedPassword) {
        try {
            // Giải mã chuỗi ký tự Base64 để lấy salt và mật khẩu đã mã hóa từ chuỗi đã lưu trữ
            byte[] saltedHash = Base64.getDecoder().decode(storedHashedPassword);

            // Lấy salt từ mảng saltedHash
            byte[] salt = Arrays.copyOfRange(saltedHash, 0, SALT_LENGTH);

            // Tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Đặt salt vào MessageDigest
            md.update(salt);

            // Mã hóa mật khẩu đầu vào thành mảng byte
            byte[] hashedPassword = md.digest(password.getBytes());

            // So sánh mật khẩu đã mã hoá từ đầu vào với mật khẩu đã lưu trữ
            return Arrays.equals(saltedHash, hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}
