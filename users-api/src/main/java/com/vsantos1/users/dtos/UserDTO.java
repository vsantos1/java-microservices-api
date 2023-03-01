package com.vsantos1.users.dtos;


import java.util.Date;

public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String phoneNumber;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
