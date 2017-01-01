package com.lukechenshui.jresume.themes;

import com.lukechenshui.jresume.resume.Resume;
import com.lukechenshui.jresume.resume.items.Person;
import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;

import java.util.ArrayList;

import static j2html.TagCreator.*;

/**
 * Created by luke on 12/31/16.
 */
public class DefaultTheme extends BaseTheme {

    protected void generateHead() {
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();
        ContainerTag head = head();

        EmptyTag firstSemanticUI = link().withRel("stylesheet").withHref(getResource("semantic/dist/semantic.min.css"));
        ContainerTag secondSemanticUI = script().withSrc(getResource("semantic/dist/semantic.min.js"));
        ContainerTag jquery = script().withSrc(getResource("jquery-3.1.1.min.js"));
        children.add(jquery);
        children.add(firstSemanticUI);
        children.add(secondSemanticUI);


        if (person != null && person.getName() != null) {
            children.add(title(person.getName()));
        }
        head = head().with(children);
        html = html.with(head);
    }

    protected void generateBody() {
        ContainerTag body = body().withClass("ui container");
        body.with(generatePerson());
        html = html.with(body);
    }

    protected ContainerTag generatePerson() {
        ContainerTag personHtml = div();
        ArrayList<Tag> children = new ArrayList<>();
        Person person = resumeBeingOperatedOn.getPerson();
        if (person != null) {
            if (person.getName() != null) {
                children.add(h1(person.getName()).withClass("ui header centered"));
            }
            ContainerTag detailsTable = table().withClass("ui celled table");
            ContainerTag columnHeaderElements = thead();
            ContainerTag columnElements = tbody();

            if (person.getEmail() != null) {
                ContainerTag header = th();
                ContainerTag icon = i().withClass("mail outline icon");
                ContainerTag email = td(person.getEmail()).withClass("ui text");

                header.with(icon);

                columnHeaderElements.with(header);
                columnElements.with(email);
            }
            detailsTable.with(columnHeaderElements);
            detailsTable.with(columnElements);
            children.add(detailsTable);
        }

        personHtml.with(children);

        return personHtml;
    }

    public String generate(Resume resume) {
        html = html();
        resumeBeingOperatedOn = resume;
        generateHead();
        generateBody();
        htmlString = html.render();
        System.out.println(htmlString);
        return htmlString;
    }
}
