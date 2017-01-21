package com.lukechenshui.jresume.resume.items.education;

/**
 * Created by luke on 1/4/17.
 */
public class ExaminationSubject extends BaseEducationItem {
    //Uses 'name' field from BaseEducationItem

    String result;

    public ExaminationSubject(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
