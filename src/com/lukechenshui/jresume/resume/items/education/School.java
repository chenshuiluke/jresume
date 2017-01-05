package com.lukechenshui.jresume.resume.items.education;

import java.util.ArrayList;

/**
 * Created by luke on 1/4/17.
 */
public class School extends BaseEducationItem {
    /*
    Uses 'name' field from parent
    as well as startDate and endDate
     */

    String gpa;
    String summary;
    ArrayList<Examination> examinations;

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(ArrayList<Examination> examinations) {
        this.examinations = examinations;
    }
}
