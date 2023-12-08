package com.karibu.web_app.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Author implements Serializable {

    
    @Id 
    String uuid = UUID.randomUUID().toString();
    private int idCardNumber;
    private int phoneNumber;
    private Date birthDate;
    private Date dateOfBeginContract;
    private Date dateOfEndContract;
    private String FirstName;
    private String lastName;
    private String artistName;
    private String mail;
    private String placeOfBirth;
    private String country;
    private String story;
    
}
