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
    public Work() {
    }
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
        if (highlights == null) {
            highlights = new ArrayList<>();
        }
        highlights.add(highlight);
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void addKeyWord(String keyword){
        if (this.keywords == null) {
            this.keywords = new ArrayList<>();
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (getCompany() != null ? !getCompany().equals(work.getCompany()) : work.getCompany() != null) return false;
        if (getPosition() != null ? !getPosition().equals(work.getPosition()) : work.getPosition() != null)
            return false;
        if (getSummary() != null ? !getSummary().equals(work.getSummary()) : work.getSummary() != null) return false;
        if (getStartDate() != null ? !getStartDate().equals(work.getStartDate()) : work.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(work.getEndDate()) : work.getEndDate() != null) return false;
        if (getHighlights() != null ? !getHighlights().equals(work.getHighlights()) : work.getHighlights() != null)
            return false;
        return getKeywords() != null ? getKeywords().equals(work.getKeywords()) : work.getKeywords() == null;
    }

    @Override
    public int hashCode() {
        int result = getCompany() != null ? getCompany().hashCode() : 0;
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getSummary() != null ? getSummary().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getHighlights() != null ? getHighlights().hashCode() : 0);
        result = 31 * result + (getKeywords() != null ? getKeywords().hashCode() : 0);
        return result;
    }
}
