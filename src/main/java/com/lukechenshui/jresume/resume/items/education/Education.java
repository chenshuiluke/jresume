package com.lukechenshui.jresume.resume.items.education;

import java.util.ArrayList;

/**
 * Created by luke on 1/4/17.
 */
public class Education extends BaseEducationItem {
    ArrayList<School> schools;
    ArrayList<Examination> examinations;

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public ArrayList<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(ArrayList<Examination> examinations) {
        this.examinations = examinations;
    }

    public void getRidOfArraysWithEmptyElements() {
        examinations = setArraysWithEmptyElementsToNull(examinations);
        schools = setArraysWithEmptyElementsToNull(schools);
    }

    private <T extends Object> ArrayList<T> setArraysWithEmptyElementsToNull(ArrayList<T> list) {
        if (list != null) {
            for (Object element : list) {
                if (element != null) {
                    return list;
                }
            }
            return null;
        }
        return null;
    }
}
