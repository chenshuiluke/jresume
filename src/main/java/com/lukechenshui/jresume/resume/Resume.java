package com.lukechenshui.jresume.resume;

import com.google.gson.JsonObject;
import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.Project;
import com.lukechenshui.jresume.resume.items.Skill;
import com.lukechenshui.jresume.resume.items.education.Education;
import com.lukechenshui.jresume.resume.items.work.JobWork;
import com.lukechenshui.jresume.resume.items.work.VolunteerWork;

import java.util.ArrayList;

/**
 * Created by luke on 12/31/16.
 */
public class Resume {
    Person person;
    Education education;
    String educationHeading;
    ArrayList<JobWork> jobWork;
    String jobWorkHeading;
    ArrayList<VolunteerWork> volunteerWork;
    String volunteerWorkHeading;
    ArrayList<Project> projects;
    String projectsHeading;
    ArrayList<Skill> skills;
    String skillsHeading;
    int numPersonalDetailsColumns = 3;
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

    public String getJobWorkHeading() {
        return jobWorkHeading;
    }

    public void setJobWorkHeading(String jobWorkHeading) {
        this.jobWorkHeading = jobWorkHeading;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public String getProjectsHeading() {
        return projectsHeading;
    }

    public void setProjectsHeading(String projectsHeading) {
        this.projectsHeading = projectsHeading;
    }

    public ArrayList<VolunteerWork> getVolunteerWork() {
        return volunteerWork;
    }

    public void setVolunteerWork(ArrayList<VolunteerWork> volunteerWork) {
        this.volunteerWork = volunteerWork;
    }

    public String getVolunteerWorkHeading() {
        return volunteerWorkHeading;
    }

    public void setVolunteerWorkHeading(String volunteerWorkHeading) {
        this.volunteerWorkHeading = volunteerWorkHeading;
    }

    public void addJobWork(JobWork jobWork){
        if (this.jobWork == null) {
            this.jobWork = new ArrayList<JobWork>();
        }
        this.jobWork.add(jobWork);
    }
    public void addVolunteerWork(VolunteerWork volunteerWork){
        if (this.volunteerWork == null) {
            this.volunteerWork = new ArrayList<>();
        }
        this.volunteerWork.add(volunteerWork);
    }
    public void addProject(Project project){
        if (this.projects == null) {
            this.projects = new ArrayList<>();
        }
        this.projects.add(project);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public String getSkillsHeading() {
        return skillsHeading;
    }

    public void setSkillsHeading(String skillsHeading) {
        skillsHeading = skillsHeading;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public int getNumPersonalDetailsColumns() {
        return numPersonalDetailsColumns;
    }

    public void setNumPersonalDetailsColumns(int numPersonalDetailsColumns) {
        this.numPersonalDetailsColumns = numPersonalDetailsColumns;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getEducationHeading() {
        return educationHeading;
    }

    public void setEducationHeading(String educationHeading) {
        this.educationHeading = educationHeading;
    }

}
