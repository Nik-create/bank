package com;

import com.dtos.post.UserPostDto;
import com.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopApplication implements CommandLineRunner {
    private final UserService service;

    public ShopApplication(UserService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        UserPostDto user = new UserPostDto("nikalik24@gmail.com", "badComedian",
                "Totrov", "Nikita");

        service.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
