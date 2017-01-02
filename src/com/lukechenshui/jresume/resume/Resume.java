package com.lukechenshui.jresume.resume;

import com.google.gson.JsonObject;
import com.lukechenshui.jresume.resume.items.*;

import java.util.ArrayList;

/**
 * Created by luke on 12/31/16.
 */
public class Resume {
    Person person = new Person();
    ArrayList<JobWork> jobWork;
    ArrayList<VolunteerWork> volunteerWork;
    ArrayList<Project> projects;
    ArrayList<Skill> skills;
    transient JsonObject jsonObject;
    public Resume() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<JobWork> getJobWork() {
        return jobWork;
    }

    public void setJobWork(ArrayList<JobWork> jobWork) {
        this.jobWork = jobWork;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<VolunteerWork> getVolunteerWork() {
        return volunteerWork;
    }

    public void setVolunteerWork(ArrayList<VolunteerWork> volunteerWork) {
        this.volunteerWork = volunteerWork;
    }

    public void addJobWork(JobWork jobWork){
        this.jobWork.add(jobWork);
    }
    public void addVolunteerWork(VolunteerWork volunteerWork){
        this.volunteerWork.add(volunteerWork);
    }
    public void addProject(Project project){
        this.projects.add(project);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
