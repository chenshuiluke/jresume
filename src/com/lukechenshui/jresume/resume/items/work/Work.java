package com.lukechenshui.jresume.resume.items.work;

import com.lukechenshui.jresume.resume.items.BaseResumeItem;

import java.util.ArrayList;

/**
 * Created by luke on 12/31/16.
 */
public class Work extends BaseResumeItem {
    protected String company;
    protected String position;
    protected String summary;
    protected String startDate;
    protected String endDate;
    protected ArrayList<String> highlights;
    protected ArrayList<String> keywords;

    public Work(String company, String position, String summary) {
        this.company = company;
        this.position = position;
        this.summary = summary;
    }

    public Work(String company, String position, String summary, ArrayList<String> highlights) {
        this.company = company;
        this.position = position;
        this.summary = summary;
        this.highlights = highlights;
    }

    public Work(String company, String position, String summary, ArrayList<String> highlights, ArrayList<String> keywords) {
        this.company = company;
        this.position = position;
        this.summary = summary;
        this.highlights = highlights;
        this.keywords = keywords;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(ArrayList<String> highlights) {
        this.highlights = highlights;
    }

    public void addHighlight(String highlight){
        highlights.add(highlight);
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void addKeyWord(String keyword){
        keywords.add(keyword);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
