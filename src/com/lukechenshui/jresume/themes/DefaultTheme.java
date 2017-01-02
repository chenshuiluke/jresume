package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.resume.Resume;
import com.lukechenshui.jresume.resume.items.JobWork;
import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.Skill;
import com.lukechenshui.jresume.resume.items.VolunteerWork;
import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;

import java.util.ArrayList;

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
        children.add(jquery);
        children.add(firstSemanticUI);
        children.add(secondSemanticUI);
        children.add(ratingSemanticJSComponent);
        children.add(ratingSemanticCSSComponent);
        children.add(initializeRating);


        if (person != null && person.getName() != null) {
            children.add(title(person.getName()));
        }
        head.with(children);
        head.with(meta().withCharset("UTF-8"));
        html = html.with(head);
    }

    protected void generateBody() {
        ContainerTag body = body().withClass("ui container");
        body.with(generatePerson());
        body.with(generateJobWork());
        body.with(generateVolunteerWork());
        body.with(generateSkills());
        body.with(br());
        body.with(br());
        body.with(br());
        html = html.with(body);
    }

    protected ContainerTag generatePerson() {
        ContainerTag personHtml = div().withId("person").withClass("ui very padded text container");
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();
        if (person != null) {
            if (person.getName() != null) {
                children.add(h1(person.getName()).withClass("ui header centered"));
            }
            if (person.getJobTitle() != null) {
                children.add(h2(person.getJobTitle()).withClass("ui header centered"));
            }

            if (person.getWebsite() != null) {
                ContainerTag heading = h3().withClass("ui header centered");
                ContainerTag address = a(person.getWebsite())
                        .withHref(person.getWebsite()).withTarget("_blank").withClass("ui centered link");
                heading = heading.with(address);
                children.add(heading);
            }

            ContainerTag detailsTable = table().withClass("ui very basic table");
            ContainerTag columnHeaderElements = thead();
            ContainerTag columnElements = tbody();

            if (person.getEmail() != null) {
                ContainerTag header = th("Email").withClass("ui center aligned header");
                ContainerTag email = td(person.getEmail()).withClass("ui center aligned text");

                columnHeaderElements.with(header);
                columnElements.with(email);
            }

            if (person.getAddress() != null) {
                ContainerTag header = th("Address").withClass("ui center aligned header");
                ContainerTag address = td(person.getAddress()).withClass("ui center aligned text");

                columnHeaderElements.with(header);
                columnElements.with(address);
            }

            if (person.getPhoneNumber() != null) {
                ContainerTag header = th("Phone Number").withClass("ui center aligned header");
                ContainerTag address = td(person.getPhoneNumber()).withClass("ui center aligned text");

                columnHeaderElements.with(header);
                columnElements.with(address);
            }



            detailsTable.with(columnHeaderElements);
            detailsTable.with(columnElements);
            children.add(detailsTable);
        }

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


                ContainerTag content = div().withClass("ui content");

                if (work.getCompany() != null) {
                    ContainerTag companyName = div().withClass("ui header").withText(work.getCompany());
                    content.with(companyName);
                }

                if (work.getPosition() != null) {
                    ContainerTag position = div().withClass("ui gray large label").withText(work.getPosition());
                    content.with(position);
                }

                if (work.getStartDate() != null || work.getEndDate() != null) {
                    ContainerTag timeLine = div().withClass("ui gray large label");
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
                    ContainerTag summary = div().withText(work.getSummary()).withClass("ui container");
                    content.with(summary);
                }

                if (work.getHighlights() != null && work.getHighlights().size() > 0) {
                    ContainerTag highlightHeading = h4("Highlights").withClass("ui header");
                    content.with(highlightHeading);

                    ContainerTag highlights = div().withClass("ui bulleted list");
                    for (String highlight : work.getHighlights()) {
                        ContainerTag item = div().withText(highlight).withClass("ui item");
                        highlights.with(item);
                    }
                    content.with(highlights);
                }

                if (work.getKeywords() != null && work.getKeywords().size() > 0) {
                    ContainerTag keywords = div().withClass("ui  centered container");

                    for (String keyword : work.getKeywords()) {
                        ContainerTag item = a(keyword).withClass("ui blue label");
                        keywords.with(item);
                    }
                    content.with(keywords);
                }


                workChildren.add(content);
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


                ContainerTag content = div().withClass("ui content");

                if (work.getCompany() != null) {
                    ContainerTag companyName = div().withClass("ui header").withText(work.getCompany());
                    content.with(companyName);
                }

                if (work.getPosition() != null) {
                    ContainerTag position = div().withClass("ui gray large label").withText(work.getPosition());
                    content.with(position);
                }

                if (work.getStartDate() != null || work.getEndDate() != null) {
                    ContainerTag timeLine = div().withClass("ui gray large label");
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
                    ContainerTag summary = div().withText(work.getSummary()).withClass("ui container");
                    content.with(summary);
                }

                if (work.getHighlights() != null && work.getHighlights().size() > 0) {
                    ContainerTag highlightHeading = h4("Highlights").withClass("ui header");
                    content.with(highlightHeading);

                    ContainerTag highlights = div().withClass("ui bulleted list");
                    for (String highlight : work.getHighlights()) {
                        ContainerTag item = div().withText(highlight).withClass("ui item");
                        highlights.with(item);
                    }
                    content.with(highlights);
                }

                if (work.getKeywords() != null && work.getKeywords().size() > 0) {
                    ContainerTag keywords = div().withClass("ui  centered container");

                    for (String keyword : work.getKeywords()) {
                        ContainerTag item = a(keyword).withClass("ui blue label");
                        keywords.with(item);
                    }
                    content.with(keywords);
                }


                workChildren.add(content);
            }
        }

        workHtml.with(workChildren);

        return workHtml;
    }

    public ContainerTag generateSkills() {
        ContainerTag skills = div().withId("skills").withClass("ui very padded text container");
        ArrayList<Tag> children = new ArrayList<>();
        ContainerTag list = div().withClass("ui content relaxed divided list");

        if (resumeBeingOperatedOn.getSkills().size() > 0) {
            children.add(h2("Skills").withClass("ui header centered"));
        }

        for (Skill skill : resumeBeingOperatedOn.getSkills()) {
            ContainerTag skillItem = div().withClass("ui horizontal item");

            if (skill.getName() != null) {
                String text = skill.getName();
                if (skill.getCompetence() != null) {
                    text += " - " + skill.getCompetence();
                }
                ContainerTag skillContent = div().withText(text).withClass("content");
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
            }
            list.with(skillItem);
        }
        children.add(list);
        skills.with(children);
        return skills;
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
