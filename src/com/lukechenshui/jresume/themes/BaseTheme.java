package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.resume.Resume;
import j2html.tags.ContainerTag;

import java.io.File;
import java.nio.file.Paths;
/**
 * Created by luke on 12/31/16.
 */
public  class BaseTheme {
    protected String htmlString;
    protected ContainerTag html;
    protected Resume resumeBeingOperatedOn;
    protected String themeName;

    public BaseTheme(String themeName) {
        this.themeName = themeName;
    }

    protected  void generateHead(){

    }

    protected  void generateBody(){

    }

    protected  ContainerTag generatePerson(){
        return null;
    }

    public  String generate(Resume resume){
        return null;
    }

    protected  ContainerTag generateJobWork(){
        return null;
    }

    protected  ContainerTag generateVolunteerWork(){
        return null;
    }

    protected  ContainerTag generateSkills(){
        return null;
    }

    protected  ContainerTag generateProjects(){
        return null;
    }

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
