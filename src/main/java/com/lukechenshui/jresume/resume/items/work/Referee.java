package com.lukechenshui.jresume.resume.items.work;

import com.lukechenshui.jresume.resume.items.Person;

/**
 * Created by Alex Leslie on 18/6/2017.
 */
public class Referee extends Person {
    public String company;

    public Referee(String name, String jobTitle, String phoneNumber, String email, String company){
        super.setName(name);
        super.setJobTitle(jobTitle);
        super.setPhoneNumber(phoneNumber);
        super.setEmail(email);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
