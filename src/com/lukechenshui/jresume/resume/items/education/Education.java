package com.lukechenshui.jresume.resume.items.education;

import java.util.ArrayList;

/**
 * Created by luke on 1/4/17.
 */
public class Education extends BaseEducationItem {
    ArrayList<School> schools;
    ArrayList<School> examinations;

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public ArrayList<School> getExaminations() {
        return examinations;
    }

    public void setExaminations(ArrayList<School> examinations) {
        this.examinations = examinations;
    }
}
