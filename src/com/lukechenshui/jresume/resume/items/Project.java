package com.lukechenshui.jresume.resume.items;

import java.util.ArrayList;

/**
 * Created by luke on 12/31/16.
 */
public class Project extends BaseResumeItem {
    String name;
    String description;
    String url;
    ArrayList<String> highlights;
    ArrayList<String> keywords;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(ArrayList<String> highlights) {
        this.highlights = highlights;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
}
