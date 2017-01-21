package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.Project;
import com.lukechenshui.jresume.resume.items.Skill;
import com.lukechenshui.jresume.resume.items.education.Education;
import com.lukechenshui.jresume.resume.items.education.Examination;
import com.lukechenshui.jresume.resume.items.education.ExaminationSubject;
import com.lukechenshui.jresume.resume.items.education.School;
import com.lukechenshui.jresume.resume.items.work.JobWork;
import com.lukechenshui.jresume.resume.items.work.VolunteerWork;
import j2html.tags.ContainerTag;
import j2html.tags.Tag;

import java.util.ArrayList;

import static j2html.TagCreator.*;

/**
 * Created by luke on 1/9/17.
 */
public class BasicExampleTheme extends BaseTheme {
    public BasicExampleTheme(String themeName) {
        super(themeName);
    }

    @Override
    protected ContainerTag generatePerson() {

        //Creates a div with an id of person.
        ContainerTag personDiv = div().withId("person");
        personDiv.with(h1("Personal Details"));
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();

        //The following pattern can be used for all of a Person's attributes, e.g. person.getJobTitle()
        if (person.getName() != null) {
            ContainerTag nameDiv = div().withText(person.getName());
            personDiv.with(nameDiv);
        }
        children.add(personDiv);

        return personDiv;
    }

    @Override
    protected ContainerTag generateJobWork() {
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag jobWork = div().withId("jobWork");
        jobWork.with(h1("Work History"));
        if (resumeBeingOperatedOn.getJobWork() != null) {
            for (JobWork work : resumeBeingOperatedOn.getJobWork()) {
                //The following pattern can be used for all of a JobWork's attributes, e.g. work.getPosition()
                if (work.getCompany() != null) {
                    children.add(div().withText(work.getCompany()));
                }

            }
        }
        jobWork.with(children);
        return jobWork;
    }

    @Override
    protected ContainerTag generateVolunteerWork() {
        //Can use the same thing as getJobWork();
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag volunteerWork = div().withId("volunteerWork");
        volunteerWork.with(h1("Volunteer Work History"));
        if (resumeBeingOperatedOn.getVolunteerWork() != null) {
            for (VolunteerWork work : resumeBeingOperatedOn.getVolunteerWork()) {
                //The following pattern can be used for all of a JobWork's attributes, e.g. work.getPosition()
                if (work.getCompany() != null) {
                    children.add(div().withText(work.getCompany()));
                }

            }
        }
        volunteerWork.with(children);
        return volunteerWork;
    }

    @Override
    protected ContainerTag generateSkills() {
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag skills = div().withId("skills");
        skills.with(h1("Skills"));
        if (resumeBeingOperatedOn.getJobWork() != null) {
            for (Skill skill : resumeBeingOperatedOn.getSkills()) {
                //The following pattern can be used for all of a Skill's attributes, e.g. skill.getCompetence()
                if (skill.getName() != null) {
                    children.add(div().withText(skill.getName()));
                }

            }
        }
        skills.with(children);
        return skills;
    }

    @Override
    protected ContainerTag generateProjects() {
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag projects = div().withId("projects");
        projects.with(h1("Projects"));
        if (resumeBeingOperatedOn.getProjects() != null) {
            for (Project project : resumeBeingOperatedOn.getProjects()) {
                //The following pattern can be used for all of a Skill's attributes, e.g. project.getUrl()
                if (project.getName() != null) {
                    children.add(div().withText(project.getName()));
                }

            }
        }
        projects.with(children);
        return projects;
    }

    @Override
    protected ContainerTag generateEducation() {
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag education = div().withId("education");
        education.with(h1("Education"));
        if (resumeBeingOperatedOn.getEducation() != null) {
            Education educationObj = resumeBeingOperatedOn.getEducation();

            if (educationObj.getSchools() != null) {
                children.add(h2("Schools"));
                for (School school : educationObj.getSchools()) {
                    //The following pattern can be used for all of a Skill's attributes, e.g. school.getGpa()
                    if (school.getName() != null) {
                        children.add(div().withText(school.getName()));
                    }

                }
            }

            if (educationObj.getExaminations() != null) {
                children.add(h2("Examinations"));
                for (Examination examination : educationObj.getExaminations()) {
                    //The following pattern can be used for all of a Skill's attributes, e.g. examination.getGpa()
                    if (examination.getName() != null) {
                        children.add(h3(examination.getName()));

                        if (examination.getSubjects() != null) {
                            for (ExaminationSubject subject : examination.getSubjects()) {
                                if (subject.getName() != null) {
                                    children.add(div().withText(subject.getName()));
                                }

                                if (subject.getResult() != null) {
                                    children.add(div().withText(subject.getResult()));
                                }
                            }
                        }
                    }

                }
            }

        }
        education.with(children);
        return education;
    }
}
