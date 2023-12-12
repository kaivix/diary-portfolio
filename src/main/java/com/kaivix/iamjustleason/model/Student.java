package com.kaivix.iamjustleason.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "The field NAME must not be null")
    @Size(min = 2,max = 30, message = "Name should be between 2 and 30 chars")
    private String name;

    @NotNull(message = "The field LastName must not be null")
    @Size(min = 2,max = 40, message = "Name should be between 2 and 40 chars")
    private String lastname;

    @NotNull(message = "The field EMAIL must not be null")
    private String email;
    @NotNull
    @Size(min = 6, message = "Password is too short")
    private String secretkey;

    public Student() {
    }

    public Student(int id, String name,String lastname , String email, String secretkey) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.secretkey = secretkey;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
}
