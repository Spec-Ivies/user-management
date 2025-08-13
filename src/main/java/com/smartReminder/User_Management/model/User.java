package com.smartReminder.User_Management.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection =  "users")
public class User {
    @Id
    private String Id;
    @NotBlank(message = "Name is required")
    private String Name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String EmailAddress;
    private String PhoneNumber;

    public User() {
    }

    public User(String name, String emailAddress, String phoneNumber) {
        this.Name = name;
        this.EmailAddress = emailAddress;
        this.PhoneNumber = phoneNumber;
    }

    //getter/setter methods
    public String getId() {return Id;}
    public void setId(String id) {Id = id;}
    public String getName() {return Name;}
    public void setName(String name) {Name = name;}
    public String getEmailAddress() {return EmailAddress;}
    public void setEmailAddress(String emailAddress) {EmailAddress = emailAddress;}
}
