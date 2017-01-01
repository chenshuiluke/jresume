package com.lukechenshui.jresume.resume.items;

/**
 * Created by luke on 12/31/16.
 */
public class Project {
    String name = "";
    String summary = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Project(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }
}
