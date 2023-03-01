package com.vsantos1.users.dtos;


import com.vsantos1.users.annotations.UniqueCpf;
import com.vsantos1.users.annotations.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class UserDTO {

    private Long id;

    private String name;

    @Email
    @UniqueEmail
    private String email;

    @CPF
    @UniqueCpf
    private String cpf;

    // Pattern examples (12) 3456-7890 or (12) 34567-8901
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$", message = "Invalid phone number")
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
        return new Date();
    }

    public Date getUpdatedAt() {
        return new Date();
    }

}

