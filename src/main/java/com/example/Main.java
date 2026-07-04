package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner seedData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User user = new User(
                        "Leanne Graham",
                        "Bret",
                        "Sincere@april.biz",
                        "1-770-736-8031 x56442",
                        "hildegard.org"
                );
                userRepository.save(user);
                System.out.println("Seeded test user: " + user.getName());
            }
        };
    }
}