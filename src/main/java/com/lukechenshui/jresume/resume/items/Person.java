package com.lukechenshui.jresume.resume.items;

/**
 * Created by luke on 12/31/16.
 */
public class Person extends BaseResumeItem {
    String name = "";
    String jobTitle = "";
    String address = "";
    String phoneNumber = "";
    String email = "";
    String website = "";
    String objective = "";
    public Person() {
    }

    public Person(String name, String jobTitle, String address, String phoneNumber, String email, String website) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
