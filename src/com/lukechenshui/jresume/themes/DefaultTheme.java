package com.lukechenshui.jresume.themes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.resume.Resume;
import com.lukechenshui.jresume.resume.items.*;
import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;
import pl.allegro.finance.tradukisto.ValueConverters;

import java.util.ArrayList;
import java.util.Map;

import static j2html.TagCreator.*;

/**
 * Created by luke on 12/31/16.
 */
public class DefaultTheme extends BaseTheme {


    public DefaultTheme(String themeName) {
        super(themeName);
    }

    public static void registerTheme() {
        Config.addTheme(new DefaultTheme("default"));
    }

    protected void generateHead() {
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();
        ContainerTag head = head();

        EmptyTag firstSemanticUI = link().withRel("stylesheet").withHref(getResource("semantic/dist/semantic.min.css"));
        ContainerTag secondSemanticUI = script().withSrc(getResource("semantic/dist/semantic.min.js"));
        EmptyTag ratingSemanticCSSComponent = link().withRel("stylesheet").withHref(getResource("semantic/dist/components/rating.min.css"));
        ContainerTag jquery = script().withSrc(getResource("jquery-3.1.1.min.js"));
        ContainerTag ratingSemanticJSComponent = script().withSrc(getResource("semantic/dist/components/rating.min.js"));
        ContainerTag initializeRating = script().withType("text/javascript").withText("$(document).ready(function(){$('.rating').rating('disable');});");
        ContainerTag regularSizeTextCSS = style().withText(".regularText{font-size:14px;}");
        children.add(jquery);
        children.add(firstSemanticUI);
        children.add(secondSemanticUI);
        children.add(ratingSemanticJSComponent);
        children.add(ratingSemanticCSSComponent);
        children.add(initializeRating);
        children.add(regularSizeTextCSS);


        if (person != null && person.getName() != null) {
            children.add(title(person.getName()));
        }
        head.with(children);
        head.with(meta().withCharset("UTF-8"));
        html = html.with(head);
    }

    protected void generateBody() {
        ContainerTag body = body();
        JsonObject jsonObject = resumeBeingOperatedOn.getJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            switch (key.toLowerCase()) {
                case "person":
                    body.with(generatePerson());
                    body.with(div().withClass("ui divider"));
                    break;
                case "jobwork":
                    body.with(generateJobWork());
                    body.with(div().withClass("ui divider"));
                    break;
                case "volunteerwork":
                    body.with(generateVolunteerWork());
                    body.with(div().withClass("ui divider"));
                    break;
                case "skills":
                    body.with(generateSkills());
                    body.with(div().withClass("ui divider"));
                    break;
                case "projects":
                    body.with(generateProjects());
                    body.with(div().withClass("ui divider"));
                    break;
            }
        }
        body.with(br());
        body.with(br());
        body.with(br());
        html = html.with(body);
    }

    protected ContainerTag generatePerson() {
        ContainerTag personHtml = div().withId("person").withClass("ui very padded text container");
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();
        children.add(person.checkForAndGeneratePrecedingLineBreaks());
        if (person != null) {
            if (person.getName() != null) {
                children.add(h1(person.getName()).withClass("ui header centered"));
            }
            if (person.getJobTitle() != null) {
                children.add(h3(person.getJobTitle()).withClass("ui header centered"));
                children.add(br());
            }

            ValueConverters converter = ValueConverters.ENGLISH_INTEGER;
            String numberOfPersonalDetailsColumns = converter.asWords(resumeBeingOperatedOn.getNumPersonalDetailsColumns());

            ContainerTag centeredGrid = div().withClass("ui grid " + numberOfPersonalDetailsColumns + " column centered");


            if (person.getAddress() != null) {
                ContainerTag address = div().withText(person.getAddress()).withClass("ui center aligned column regularText");
                centeredGrid.with(address);
            }

            if (person.getEmail() != null) {
                ContainerTag email = div().withText(person.getEmail()).withClass("ui center aligned column regularText");
                centeredGrid.with(email);
            }

            if (person.getPhoneNumber() != null) {
                ContainerTag phoneNumber = div().withText(person.getPhoneNumber()).withClass("ui center aligned column regularText");
                centeredGrid.with(phoneNumber);
            }

            if (person.getWebsite() != null) {
                ContainerTag address = a(person.getWebsite())
                        .withHref(person.getWebsite()).withTarget("_blank").withClass("ui center aligned column regularText");
                centeredGrid.with(address);
            }
            children.add(centeredGrid);
        }
        children.add(person.checkForAndGenerateFollowingLineBreaks());

        personHtml.with(children);

        return personHtml;
    }

    protected ContainerTag generateJobWork() {
        ContainerTag workHtml = div().withId("work").withClass("ui very padded text container");

        ArrayList<Tag> workChildren = new ArrayList<>();
        ArrayList<Tag> workItemsChildren = new ArrayList<>();
        ArrayList<JobWork> jobWork = resumeBeingOperatedOn.getJobWork();

        if (resumeBeingOperatedOn != null && jobWork != null) {
            if (jobWork.size() > 0) {
                workChildren.add(h2("Work Experience").withClass("ui header centered"));
            }


            for (JobWork work : jobWork) {

                workChildren.add(work.checkForAndGeneratePrecedingLineBreaks());
                ContainerTag content = div().withClass("ui content");

                if (work.getCompany() != null) {
                    ContainerTag companyName = div().withClass("ui header").withText(work.getCompany());
                    content.with(companyName);
                }

                if (work.getPosition() != null) {
                    ContainerTag position = div().withClass("ui gray small label").withText(work.getPosition());
                    content.with(position);
                }

                if (work.getStartDate() != null || work.getEndDate() != null) {
                    ContainerTag timeLine = div().withClass("ui gray small label");
                    String text = "";

                    if (work.getStartDate() != null) {
                        text += work.getStartDate();
                    }

                    if (work.getEndDate() != null) {
                        if (work.getStartDate() != null) {
                            text += " - ";
                        }

                        text += work.getEndDate();
                    }
                    timeLine = timeLine.withText(text);
                    content.with(timeLine);
                }

                if (work.getSummary() != null) {
                    ContainerTag summary = div().withText(work.getSummary()).withClass("regularText");
                    content.with(summary);
                }

                if (work.getHighlights() != null && work.getHighlights().size() > 0) {
                    ContainerTag highlightHeading = h4("Highlights").withClass("ui header");
                    content.with(highlightHeading);

                    ContainerTag highlights = div().withClass("ui bulleted list");
                    for (String highlight : work.getHighlights()) {
                        ContainerTag item = div().withText(highlight).withClass("ui item regularText");
                        highlights.with(item);
                    }
                    content.with(highlights);
                }

                if (work.getKeywords() != null && work.getKeywords().size() > 0) {
                    ContainerTag keywords = div().withClass("ui  centered container");

                    for (String keyword : work.getKeywords()) {
                        ContainerTag item = a(keyword).withClass("ui blue small label");
                        keywords.with(item);
                    }
                    content.with(keywords);
                }


                workChildren.add(content);
                workChildren.add(work.checkForAndGenerateFollowingLineBreaks());
            }
        }

        workHtml.with(workChildren);

        return workHtml;
    }

    protected ContainerTag generateVolunteerWork() {
        ContainerTag workHtml = div().withId("volunteerWork").withClass("ui very padded text container");

        ArrayList<Tag> workChildren = new ArrayList<>();
        ArrayList<Tag> workItemsChildren = new ArrayList<>();
        ArrayList<VolunteerWork> volunteerWork = resumeBeingOperatedOn.getVolunteerWork();

        if (resumeBeingOperatedOn != null && volunteerWork != null) {
            if (volunteerWork.size() > 0) {
                workChildren.add(h2("Volunteer Work Experience").withClass("ui header centered"));
            }


            for (VolunteerWork work : volunteerWork) {
                workChildren.add(work.checkForAndGeneratePrecedingLineBreaks());

                ContainerTag content = div().withClass("ui content");

                if (work.getCompany() != null) {
                    ContainerTag companyName = div().withClass("ui header").withText(work.getCompany());
                    content.with(companyName);
                }

                if (work.getPosition() != null) {
                    ContainerTag position = div().withClass("ui gray small label").withText(work.getPosition());
                    content.with(position);
                }

                if (work.getStartDate() != null || work.getEndDate() != null) {
                    ContainerTag timeLine = div().withClass("ui gray small label");
                    String text = "";

                    if (work.getStartDate() != null) {
                        text += work.getStartDate();
                    }

                    if (work.getEndDate() != null) {
                        if (work.getStartDate() != null) {
                            text += " - ";
                        }

                        text += work.getEndDate();
                    }
                    timeLine = timeLine.withText(text);
                    content.with(timeLine);
                }

                if (work.getSummary() != null) {
                    ContainerTag summary = div().withText(work.getSummary()).withClass("regularText");
                    content.with(summary);
                }

                if (work.getHighlights() != null && work.getHighlights().size() > 0) {
                    ContainerTag highlightHeading = h4("Highlights").withClass("ui header");
                    content.with(highlightHeading);

                    ContainerTag highlights = div().withClass("ui bulleted list");
                    for (String highlight : work.getHighlights()) {
                        ContainerTag item = div().withText(highlight).withClass("ui item regularText");
                        highlights.with(item);
                    }
                    content.with(highlights);
                }

                if (work.getKeywords() != null && work.getKeywords().size() > 0) {
                    ContainerTag keywords = div().withClass("ui  centered container");

                    for (String keyword : work.getKeywords()) {
                        ContainerTag item = a(keyword).withClass("ui blue small label");
                        keywords.with(item);
                    }
                    content.with(keywords);
                }
                content.with(br());
                workChildren.add(work.checkForAndGenerateFollowingLineBreaks());
                workChildren.add(content);
            }
        }

        workHtml.with(workChildren);

        return workHtml;
    }

    public ContainerTag generateSkills() {
        ContainerTag skills = div().withId("skills").withClass("ui very padded text container");
        ArrayList<Tag> children = new ArrayList<>();
        ValueConverters converter = ValueConverters.ENGLISH_INTEGER;
        String numberOfSkillColumns = converter.asWords(resumeBeingOperatedOn.getNumSkillColumns());
        ContainerTag list = div().withClass("ui " + numberOfSkillColumns + " column grid container relaxed centered");

        if (resumeBeingOperatedOn.getSkills().size() > 0) {
            children.add(h2("Skills").withClass("ui header centered"));
        }

        for (Skill skill : resumeBeingOperatedOn.getSkills()) {
            ContainerTag skillItem = div().withClass("ui center aligned column");
            children.add(skill.checkForAndGeneratePrecedingLineBreaks());
            if (skill.getName() != null) {
                String text = skill.getName();
                if (skill.getCompetence() != null) {
                    text += " - " + skill.getCompetence();
                }
                ContainerTag skillContent = div().withText(text).withClass("content centered");
                skillItem.with(skillContent);
            }

            if (skill.getCompetence() != null) {
                ContainerTag skillRating = div().withClass("ui rating").attr("data-max-rating", "5");

                String competence = skill.getCompetence();

                switch (competence.toLowerCase()) {
                    case "beginner":
                        skillRating.attr("data-rating", String.valueOf(Skill.competenceToStarHashMap.get("beginner")));
                        break;
                    case "intermediate":
                        skillRating.attr("data-rating", String.valueOf(Skill.competenceToStarHashMap.get("intermediate")));
                        break;
                    case "advanced":
                        skillRating.attr("data-rating", String.valueOf(Skill.competenceToStarHashMap.get("advanced")));
                        break;
                    default:
                        System.out.println("Skill " + skill.getName() + " has invalid competence - " +
                                skill.getCompetence() + ". Valid competence levels" +
                                " are beginner, intermediate and advanced.");
                        break;
                }
                skillItem.with(skillRating);
                children.add(skill.checkForAndGeneratePrecedingLineBreaks());
            }
            list.with(skillItem);
        }
        children.add(list);
        skills.with(children);
        return skills;
    }

    public ContainerTag generateProjects() {
        ContainerTag projects = div().withId("projects").withClass("ui very padded text container");
        ArrayList<Tag> children = new ArrayList<>();

        if (resumeBeingOperatedOn.getProjects().size() > 0) {
            children.add(h2("Projects").withClass("ui header centered"));
        }

        for (Project project : resumeBeingOperatedOn.getProjects()) {
            children.add(project.checkForAndGeneratePrecedingLineBreaks());
            ContainerTag content = div().withClass("ui content");

            ContainerTag headingAndLinkGrid = div().withClass("ui grid relaxed one column");

            if (project.getName() != null) {
                ContainerTag projectName = div().withClass("ui header row").withText(project.getName());
                headingAndLinkGrid.with(projectName);
            }

            if (project.getUrl() != null) {
                ContainerTag projectURL = a(project.getUrl()).withClass("ui row").withHref(project.getUrl());
                headingAndLinkGrid.with(projectURL);
            }

            content.with(headingAndLinkGrid);

            if (project.getDescription() != null) {
                ContainerTag description = div().withText(project.getDescription()).withClass("regularText");
                content.with(description);
            }

            if (project.getHighlights() != null && project.getHighlights().size() > 0) {
                ContainerTag highlightHeading = h4("Highlights").withClass("ui header");
                content.with(highlightHeading);

                ContainerTag highlights = div().withClass("ui bulleted list");
                for (String highlight : project.getHighlights()) {
                    ContainerTag item = div().withText(highlight).withClass("ui item regularText");
                    highlights.with(item);
                }
                content.with(highlights);
            }

            if (project.getKeywords() != null && project.getKeywords().size() > 0) {
                ContainerTag keywords = div().withClass("ui  centered container");

                for (String keyword : project.getKeywords()) {
                    ContainerTag item = a(keyword).withClass("ui blue small label");
                    keywords.with(item);
                }
                content.with(keywords);
            }
            content.with(br());

            children.add(content);
            children.add(project.checkForAndGenerateFollowingLineBreaks());
        }
        projects.with(children);
        return projects;
    }

    public String generate(Resume resume) {
        html = html();
        html.with(document());
        resumeBeingOperatedOn = resume;
        generateHead();
        generateBody();
        htmlString = html.render();
        System.out.println(htmlString);
        return htmlString;
    }


}
