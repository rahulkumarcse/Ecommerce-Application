package com.rahul.ecommerce.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
@Data

public class UserLoginDto {
    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private  String password;

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

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDto() {
    }
}
