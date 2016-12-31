package com.lukechenshui.jresume.resume;

import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.Project;
import com.lukechenshui.jresume.resume.items.VolunteerWork;
import com.lukechenshui.jresume.resume.items.Work;

import java.util.ArrayList;

/**
 * Created by luke on 12/31/16.
 */
public class Resume {
    Person person;
    ArrayList<Work> work = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();
    ArrayList<VolunteerWork> volunteerWork = new ArrayList<>();

    public Resume() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Work> getWork() {
        return work;
    }

    public void setWork(ArrayList<Work> work) {
        this.work = work;
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
}
