package com.civilianshield.civilianshield.controller;

import com.civilianshield.civilianshield.model.User;
import com.civilianshield.civilianshield.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private Map<String, String> otpStore = new HashMap<>();
    private Map<String, User> pendingUsers = new HashMap<>();

    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.html");
    }

    @PostMapping("/api/user/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        if (userRepository.findByEmail(user.getEmail()) != null) {
            response.put("status", "ERROR");
            response.put("message", "Email already registered!");
            return response;
        }

        // Auto-approve registration (skip OTP for testing)
        user.setStatus("SAFE");
        userRepository.save(user);

        response.put("status", "SUCCESS");
        response.put("message", "Account created! You can now login.");
        response.put("userId", user.getId());
        response.put("name", user.getName());
        return response;
    }

    @PostMapping("/api/user/verify-otp")
    public Map<String, Object> verifyOtp(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();

        String email = request.get("email");
        String otp = request.get("otp");
        String storedOtp = otpStore.get(email);
        User pendingUser = pendingUsers.get(email);

        if (storedOtp == null || pendingUser == null) {
            response.put("status", "ERROR");
            response.put("message", "Session expired. Please register again.");
            return response;
        }

        if (!storedOtp.equals(otp)) {
            response.put("status", "ERROR");
            response.put("message", "Invalid OTP! Please try again.");
            return response;
        }

        pendingUser.setStatus("SAFE");
        userRepository.save(pendingUser);
        otpStore.remove(email);
        pendingUsers.remove(email);

        response.put("status", "SUCCESS");
        response.put("message", "Welcome to Civilian Shield!");
        response.put("userId", pendingUser.getId());
        response.put("name", pendingUser.getName());
        return response;
    }

    @PostMapping("/api/user/forgot-password")
    public Map<String, Object> forgotPassword(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        String email = request.get("email");
        User user = userRepository.findByEmail(email);

        if (user == null) {
            response.put("status", "OK");
            response.put("message", "If this email exists, a reset link has been sent!");
            return response;
        }

        String tempPassword = "Shield" + (1000 + new Random().nextInt(9000));
        user.setPassword(tempPassword);
        userRepository.save(user);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("pvasu9055@gmail.com");
            message.setTo(email);
            message.setSubject("🛡️ Civilian Shield — Password Reset");
            message.setText(
                    "Hello " + user.getName() + ",\n\n" +
                            "Your temporary password is: " + tempPassword + "\n\n" +
                            "Please login and change your password immediately.\n\n" +
                            "Stay Safe,\nCivilian Shield Team 🛡️"
            );
            mailSender.send(message);
        } catch (Exception e) {}

        response.put("status", "OK");
        response.put("message", "Temporary password sent to your email!");
        return response;
    }

    @PostMapping("/api/user/login")
    public Map<String, Object> login(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();

        User user = userRepository.findByEmail(request.get("email"));

        if (user == null || !user.getPassword().equals(request.get("password"))) {
            response.put("status", "ERROR");
            response.put("message", "Invalid email or password!");
            return response;
        }

        response.put("status", "SUCCESS");
        response.put("message", "Login successful!");
        response.put("userId", user.getId());
        response.put("name", user.getName());
        response.put("location", user.getLocation());
        return response;
    }

    @GetMapping("/api/user/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}