package com.lukechenshui.jresume;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukechenshui.jresume.resume.Resume;
import com.lukechenshui.jresume.resume.items.JobWork;
import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.VolunteerWork;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        createExample();
    }

    public static void createExample(){
        Person person = new Person("John Doe", "Junior Software Engineer",
                "800 Java Road, OOP City", "+1(345)-335-8964", "johndoe@gmail.com",
                "http://johndoe.com");
        JobWork jobWork = new JobWork("Example Ltd.", "Software Engineer",
                "At Example Ltd., I did such and such.");

        jobWork.addHighlight("Worked on such and such");
        jobWork.addHighlight("Also worked on this");
        jobWork.addKeyWord("java");
        jobWork.addKeyWord("c++");

        VolunteerWork volunteerWork = new VolunteerWork("Example Institution", "Volunteer",
                "At Example Institution, I did such and such.");
        Resume resume = new Resume();
        resume.setPerson(person);
        resume.addJobWork(jobWork);
        resume.addVolunteerWork(volunteerWork);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(resume);
        System.out.println(json);
        try(FileWriter writer = new FileWriter("example.json")){
            writer.write(json);
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
