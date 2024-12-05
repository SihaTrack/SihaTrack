package com.eniad.sihatrack_v_1.models;

public class User {
    int userId;
    private String firstname;
    private String lastname;
    private String date_birth;
    private String gender;
    private String email;
    private String password;

    public User(String firstname, String lastname, String date_birth, String gender, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_birth = date_birth;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public User(int userId, String firstname, String lastname, String date_birth, String gender, String email, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_birth = date_birth;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
