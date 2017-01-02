package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.Runtime;
import com.lukechenshui.jresume.resume.Resume;
import j2html.tags.ContainerTag;

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

    protected String getResource(String fileName) {
        String currentDir = System.getProperty("user.dir") + "/output";
        String resourceDirectory = Paths.get(Runtime.getResourceDirectory().getAbsolutePath(), fileName).toString();
        resourceDirectory = resourceDirectory.replace(currentDir + "/", "");
        return resourceDirectory;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}
