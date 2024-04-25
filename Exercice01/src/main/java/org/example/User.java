package org.example;

public class User {
    private long id;
    private String username;
    private String email;

    // Constructeur
    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

