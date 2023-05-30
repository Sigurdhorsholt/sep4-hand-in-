package com.example.sep4_project.model;

import java.util.List;

public class Manufacturer {


    private String name;
    private String phoneNo;
    private String email;

    //List<ContactInfo > contactInfoList;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setPhoneNo(String phone_no) {
        this.phoneNo = phone_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
