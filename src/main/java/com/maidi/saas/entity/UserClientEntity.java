package com.maidi.saas.entity;

public class UserClientEntity {
    private int id;

    private String username;

    private String name;

    private String nickName;

    private String enabled;

    private String email;

    private String phone;

    private String isAdmin;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserClientEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickName='" + nickName + '\'' +
                ", enabled='" + enabled + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
