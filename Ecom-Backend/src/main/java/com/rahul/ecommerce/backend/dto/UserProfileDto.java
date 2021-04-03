package com.rahul.ecommerce.backend.dto;

import lombok.Data;

import javax.persistence.Column;
@Data

public class UserProfileDto {
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    public UserProfileDto(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserProfileDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
