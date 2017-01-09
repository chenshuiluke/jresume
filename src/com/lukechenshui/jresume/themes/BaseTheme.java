package com.lukechenshui.jresume.themes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.resume.Resume;
import j2html.tags.ContainerTag;

import java.io.File;
import java.lang.reflect.Constructor;
import java.nio.file.Paths;
import java.util.Map;

import static j2html.TagCreator.*;

/**
 * Created by luke on 12/31/16.
 */
public abstract class BaseTheme {
    protected String htmlString;
    protected ContainerTag html;
    protected Resume resumeBeingOperatedOn;
    protected String themeName;

    public BaseTheme() {
        try {
            if (themeName == null) {
                System.err.println("You must either set the name of the theme manually as an attribute of the class or use " +
                        "the constructor that takes the name of the theme as an argument.");
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public BaseTheme(String themeName) {
        this.themeName = themeName;
    }

    public static void registerTheme(String name, Class classObj) {
        try {
            Constructor constructor = classObj.getConstructor(String.class);
            Config.addTheme(constructor.newInstance(name));
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    protected  void generateHead(){

    }

    protected  void generateBody(){
        ContainerTag body = body();
        JsonObject jsonObject = resumeBeingOperatedOn.getJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            switch (key.toLowerCase()) {
                case "person":
                    body.with(generatePerson());
                    //body.with(div().withClass("ui divider"));
                    break;
                case "jobwork":
                    body.with(generateJobWork());
                    //body.with(div().withClass("ui divider"));
                    break;
                case "volunteerwork":
                    body.with(generateVolunteerWork());
                    //body.with(div().withClass("ui divider"));
                    break;
                case "skills":
                    body.with(generateSkills());
                    //body.with(div().withClass("ui divider"));
                    break;
                case "projects":
                    body.with(generateProjects());
                    //body.with(div().withClass("ui divider"));
                    break;
                case "education":
                    body.with(generateEducation());
                    //body.with(div().withClass("ui divider"));
                    break;
            }
        }
        body.with(br());
        body.with(br());
        body.with(br());
        html = html.with(body);
    }

    protected abstract ContainerTag generatePerson();

    public  String generate(Resume resume){
        html = html();
        html.with(document());
        resumeBeingOperatedOn = resume;
        generateHead();
        generateBody();
        htmlString = html.render();
        System.out.println(htmlString);
        return htmlString;
    }

    protected abstract ContainerTag generateJobWork();

    protected abstract ContainerTag generateVolunteerWork();

    protected abstract ContainerTag generateSkills();

    protected abstract ContainerTag generateProjects();

    protected abstract ContainerTag generateEducation();

    protected String getResource(String fileName) {
        String dirToRemove = Config.getOutputDirectory();
        System.out.println(dirToRemove);
        String resourceDirectory = Paths.get(Config.getOutputDirectory(), "resources", fileName).toString();
        resourceDirectory = resourceDirectory.replace(dirToRemove + File.separator, "");
        return resourceDirectory;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
