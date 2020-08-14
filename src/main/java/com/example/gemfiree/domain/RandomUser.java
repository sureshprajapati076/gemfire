package com.example.gemfiree.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;



@Region("users")
public class RandomUser {
    @Id
    private String email;
    private String gender;

    private String phone;
    private Name name;

    private Location location;

    public RandomUser() {
    }

    @PersistenceConstructor
    public RandomUser(String email, String gender, String phone, Name name, Location location) {
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
