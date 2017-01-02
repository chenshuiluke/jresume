package com.lukechenshui.jresume.resume.items;

import java.util.HashMap;

/**
 * Created by luke on 1/1/17.
 */
public class Skill {
    public static transient HashMap<String, Integer> competenceToStarHashMap = new HashMap<String, Integer>() {{
        put("beginner", 1);
        put("intermediate", 3);
        put("advanced", 5);
    }};
    String name;
    String competence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }
}
