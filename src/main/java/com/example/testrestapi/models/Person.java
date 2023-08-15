package com.example.testrestapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Should be not empty")
    @Size(min = 3, max = 30, message = "Should be between 3 - 30")
    private String name;


    @Column(name = "imageURL", nullable = false)
    @NotNull(message = "Should be not empty")
    @Size(min = 3, max = 30, message = "Should be between 3 - 30")
    private String imageURL;

    @Column(name = "email", nullable = false,unique = true)
    @NotNull(message = "Should be not empty")
    @Email(message = "This email is exist")
    private String email;

    @Column(name = "status")
    private String status;


    public Person(String name, String imageURL, String email) {
        this.name = name;
        this.imageURL = imageURL;
        this.email = email;
    }

    public Person() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
