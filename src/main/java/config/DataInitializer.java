package com.civilianshield.civilianshield.config;

import com.civilianshield.civilianshield.model.User;
import com.civilianshield.civilianshield.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("test@example.com") == null) {
            User testUser = new User();
            testUser.setName("Test User");
            testUser.setEmail("test@example.com");
            testUser.setPassword("password123");
            testUser.setPhone("9999999999");
            testUser.setLocation("Vadodara, Gujarat");
            testUser.setStatus("SAFE");
            userRepository.save(testUser);
            System.out.println("✅ Test user created!");
        }
    }
}