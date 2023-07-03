package com;

import com.domains.User;
import com.domains.enums.Role;
import com.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories
public class ShopApplication implements CommandLineRunner {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public ShopApplication(UserRepository repo, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User(0, Role.ADMIN, "nikalik24@gmail.com", "badComedian",
                "Totrov", "Nikita", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user = new User(0, Role.USER, "test@gmail.com", "231",
                "Voronkova", "Olga", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.setPassword(encoder.encode(user.getPassword()));
        admin.setPassword(encoder.encode(admin.getPassword()));
        repo.save(admin);
        repo.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
