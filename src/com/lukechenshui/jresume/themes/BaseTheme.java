package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.resume.Resume;
import j2html.tags.ContainerTag;

import java.io.File;
import java.nio.file.Paths;
/**
 * Created by luke on 12/31/16.
 */
public abstract class BaseTheme {
    protected String htmlString;
    protected ContainerTag html;
    protected Resume resumeBeingOperatedOn;
    protected String themeName;

    public BaseTheme(String themeName) {
        this.themeName = themeName;
    }

    protected abstract void generateHead();

    protected abstract void generateBody();

    protected abstract ContainerTag generatePerson();

    public abstract String generate(Resume resume);

    protected abstract ContainerTag generateJobWork();

    protected abstract ContainerTag generateVolunteerWork();

    protected abstract ContainerTag generateSkills();

    protected abstract ContainerTag generateProjects();

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
