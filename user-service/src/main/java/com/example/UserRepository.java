package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository {
    public List<User> getAllUsers() {
        return List.of(
                new User(1, "kutoi228", "nekrut2006@example.com"),
                new User(2, "MegaNiceGigaChadPatrickBateman", "sigmamoment@example.com")
        );
    }
}
