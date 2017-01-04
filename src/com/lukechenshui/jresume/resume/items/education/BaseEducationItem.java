package com.lukechenshui.jresume.resume.items.education;

import com.lukechenshui.jresume.resume.items.BaseResumeItem;

/**
 * Created by luke on 1/4/17.
 */
public class BaseEducationItem extends BaseResumeItem {
    String name;

    String startDate;
    String endDate;

    String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
