package com.example.sep4_project.model;

import java.time.LocalDateTime;

public class ContactInfo {


    private LocalDateTime timeAdd;
    private String name;
    private String phoneNo;
    private String email;

    public ContactInfo(LocalDateTime timeAdd, String name, String phoneNo, String email) {
        this.timeAdd = timeAdd;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public LocalDateTime getTimeAdd() {
        return timeAdd;
    }


    public String getName() {
        return name;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}

