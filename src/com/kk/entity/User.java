package com.kk.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String name; // ���� nickname

    public User() {}

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    // Getter/Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
