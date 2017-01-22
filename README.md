#JResume - The best JSON to HTML resume generator.

![output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/1_default_theme_latest.png)

##Example usage

###Example JSON resume (example.json):

    {
      "skillsHeading": "Custom Skills Heading",
      "jobWorkHeading": "Custom Work Heading",
      "person": {
        "name": "Bob",
        "email": "johndoe@gmail.com",
        "address": "7 Java Drive, OOP City",
        "phoneNumber": "+1(334)567-2346",
        "jobTitle": "Software Engineer",
        "website": "https://www.google.com",
        "objective": "Bleh bleh bleh bleh bleh bleh bleh bleh"
      },
      "skills": [
        {
          "name": "Java",
          "competence": "Advanced"
        },
        {

          "name": "C++",
          "competence": "Beginner"
        },
        {
          "name": "Android",
          "competence": "Intermediate"
        }
      ],
      "accomplishments": [
        "Team made it to the ACM-ICPC Programming Caribbean National Finals 2015.",
        "Was the only student to complete all three phases of the Calico 2016 project."
      ],
      "jobWork": [
        {
          "company": "Example Ltd.",
          "position": "Software Engineer",
          "summary": "At Example Ltd., I did such and such and such and such and such and such and such and such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 2001",
          "highlights": [
            "Worked on such and such",
            "I did such and such and such and such and such and such and such and such and such. I did such and such and such and such and such and such and such and such and such.",
            "Also worked on this"
          ],
          "keywords": [
            "java",
            "c++"
          ]
        },
        {
          "company": "Example Ltd.2",
          "position": "Software Engineer",
          "summary": "At Example Ltd.2, I did such and such and such and such and such and such and such and such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 2001",
          "highlights": [
            "Worked on such and such",
            "Also worked on this"
          ],
          "keywords": [
            "java",
            "c++"
          ]
        }
      ],
      "volunteerWork": [
        {
          "company": "Example Institution",
          "position": "Volunteer",
          "summary": "At Example Institution, I did such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 2001",
          "highlights": [
            "Worked on such and such",
            "Also worked on this"
          ],
          "keywords": [
            "java",
            "c++"
          ]
        },
        {
          "company": "Example Institution2",
          "position": "Volunteer",
          "summary": "At Example Institution2, I did such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 2001",
          "highlights": [
            "Worked on such and such",
            "Also worked on this"
          ],
          "keywords": [
            "java",
            "c++"
          ]
        }
      ],
      "projects": [
        {
          "name": "AwesomeProject",
          "description": "This awesome project is awesome!",
          "highlights": [
            "Does such and such.",
            "And it does such and such."
          ],
          "keywords": [
            "java",
            "c++"
          ],
          "url": "https://www.github.com"
        },
        {
          "name": "AwesomeProject2",
          "description": "This awesome project2 is awesome!",
          "highlights": [
            "Does such and such.",
            "And it does such and such."
          ],
          "keywords": [
            "java",
            "c++"
          ],
          "url": "https://www.github.com"
        }
      ],
      "projects": [
        {
          "name": "AwesomeProject",
          "description": "This awesome project is awesome!",
          "highlights": [
            "Does such and such.",
            "And it does such and such."
          ],
          "keywords": [
            "java",
            "c++"
          ],
          "url": "https://www.github.com"
        },
        {
          "name": "AwesomeProject2",
          "description": "This awesome project2 is awesome!",
          "highlights": [
            "Does such and such.",
            "And it does such and such."
          ],
          "keywords": [
            "java",
            "c++"
          ],
          "url": "https://www.github.com"
        }
      ],
      "education": {
        "schools": [
          {
            "name": "Ardenne High School",
            "startDate": "2009",
            "endDate": "2014",
            "summary": "Some summary!",
            "gpa": "5.0",
            "examinations": [
              {
                "name": "CSEC",
                "startDate": "2014",
                "subjects": [
                  {
                    "name": "Math",
                    "result": "100"
                  },
                  {
                    "name": "English",
                    "result": "100"
                  }
                ]
              }
            ]
          }
        ],
        "examinations": [
          {
            "name": "CSEC",
            "startDate": "2014",
            "subjects": [
              {
                "name": "Math",
                "result": "100"
              },
              {
                "name": "English",
                "result": "100"
              }
            ]
          }
        ]

      },
      "hobbies": [
        "Programming",
        "Video editing",
        "Gaming"
      ]
    }
###Usage:

    java -jar jresume.jar --input example.json --output output --theme default

###Output:

![default_theme_output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/1_default_theme_latest.png)

###Customizing the Output:

####Customizing space between sections

You may use `numPrecedingLineBreaks` or `numFollowingLineBreaks` to add space before or after each section respectively.

#####Spacing examples:

Without Spacing:

      "person": {
        "name": "Bob",
        "email": "johndoe@gmail.com",
        "address": "7 Java Drive, OOP City",
        "phoneNumber": "+1(334)567-2346",
        "jobTitle": "Software Engineer",
        "website": "https://www.google.com"
      },
      ...

![spacing_before_output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/spacing_example_before.png)

With Spacing:

      "person": {
        "name": "Bob",
        "email": "johndoe@gmail.com",
        "address": "7 Java Drive, OOP City",
        "phoneNumber": "+1(334)567-2346",
        "jobTitle": "Software Engineer",
        "website": "https://www.google.com",
        "numFollowingLineBreaks": 10
      },
      ...

![spacing_after_output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/spacing_example_after.png)


####Customizing Section Headings
You can customize the various headings by adding the following to your resume JSON file:

1. skillsHeading
2. jobWorkHeading
3. volunteerWorkHeading
4. projectHeading
5. educationHeading

Example:

    {
      "skillsHeading": "Custom Skills Heading",
      "jobWorkHeading": "Custom Work Heading",
      "person": {
        "name": "Bob",
        "email": "johndoe@gmail.com",
        "address": "7 Java Drive, OOP City",
        "phoneNumber": "+1(334)567-2346",
        "jobTitle": "Software Engineer",
        "website": "https://www.google.com"
      },


Output:

![custom_headings](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/custom_theme_heading_example.png)

###Converting to PDF

If you don't want to use your browser to save the web resume as a pdf, you can install phantomjs and do the following:

    phantomjs pdf.js <webresume_file>.html <pdf_resume_file>.pdf

pdf.js is in the root directory of the jresume directory.

##Creating a new Theme.

1. Add a new class to the `com.lukechenshui.jresume.themes` package that extends `BaseTheme`
2. Implemented the various functions such as `generateJobWork`. The functions such as `generateJobWork`, `generateSkills`, etc are each responsible for generating the HTML for their respective section of the web resume.
3. Register your theme in the application by
    * Adding `BaseTheme.registerTheme("<commandline_theme_name>", <ThemeClassName>.class);` to the `registerThemes` function in `Main.java`.
4. Use your new theme by running: `java -jar jresume.jar --input <input_json_file> --output <output_folder> --theme <commandline_theme_name>`

**See the following code for `BasicExampleTheme` below: (it can also be found in `com.lukechenshui.jresume.themes.BasicExampleTheme`**

        /**
         * Created by luke on 1/9/17.
         */
        public class BasicExampleTheme extends BaseTheme {
            public BasicExampleTheme(String themeName) {
                super(themeName);
            }

            @Override
            protected ContainerTag generatePerson() {

                //Creates a div with an id of person.
                ContainerTag personDiv = div().withId("person");
                personDiv.with(h1("Personal Details"));
                ArrayList<Tag> children = new ArrayList<>();
                Person person = resumeBeingOperatedOn.getPerson();

                //The following pattern can be used for all of a Person's attributes, e.g. person.getJobTitle()
                if (person.getName() != null) {
                    ContainerTag nameDiv = div().withText(person.getName());
                    personDiv.with(nameDiv);
                }
                children.add(personDiv);

                return personDiv;
            }

            @Override
            protected ContainerTag generateJobWork() {
                ArrayList<Tag> children = new ArrayList<>();
                ContainerTag jobWork = div().withId("jobWork");
                jobWork.with(h1("Work History"));
                if (resumeBeingOperatedOn.getJobWork() != null) {
                    for (JobWork work : resumeBeingOperatedOn.getJobWork()) {
                        //The following pattern can be used for all of a JobWork's attributes, e.g. work.getPosition()
                        if (work.getCompany() != null) {
                            children.add(div().withText(work.getCompany()));
                        }

                    }
                }
                jobWork.with(children);
                return jobWork;
            }

            @Override
            protected ContainerTag generateVolunteerWork() {
                //Can use the same thing as getJobWork();
                ArrayList<Tag> children = new ArrayList<>();
                ContainerTag volunteerWork = div().withId("volunteerWork");
                volunteerWork.with(h1("Volunteer Work History"));
                if (resumeBeingOperatedOn.getVolunteerWork() != null) {
                    for (VolunteerWork work : resumeBeingOperatedOn.getVolunteerWork()) {
                        //The following pattern can be used for all of a JobWork's attributes, e.g. work.getPosition()
                        if (work.getCompany() != null) {
                            children.add(div().withText(work.getCompany()));
                        }

                    }
                }
                volunteerWork.with(children);
                return volunteerWork;
            }

            @Override
            protected ContainerTag generateSkills() {
                ArrayList<Tag> children = new ArrayList<>();
                ContainerTag skills = div().withId("skills");
                skills.with(h1("Skills"));
                if (resumeBeingOperatedOn.getJobWork() != null) {
                    for (Skill skill : resumeBeingOperatedOn.getSkills()) {
                        //The following pattern can be used for all of a Skill's attributes, e.g. skill.getCompetence()
                        if (skill.getName() != null) {
                            children.add(div().withText(skill.getName()));
                        }

                    }
                }
                skills.with(children);
                return skills;
            }

            @Override
            protected ContainerTag generateProjects() {
                ArrayList<Tag> children = new ArrayList<>();
                ContainerTag projects = div().withId("projects");
                projects.with(h1("Projects"));
                if (resumeBeingOperatedOn.getProjects() != null) {
                    for (Project project : resumeBeingOperatedOn.getProjects()) {
                        //The following pattern can be used for all of a Skill's attributes, e.g. project.getUrl()
                        if (project.getName() != null) {
                            children.add(div().withText(project.getName()));
                        }

                    }
                }
                projects.with(children);
                return projects;
            }

            @Override
            protected ContainerTag generateEducation() {
                ArrayList<Tag> children = new ArrayList<>();
                ContainerTag education = div().withId("education");
                education.with(h1("Education"));
                if (resumeBeingOperatedOn.getEducation() != null) {
                    Education educationObj = resumeBeingOperatedOn.getEducation();

                    if (educationObj.getSchools() != null) {
                        children.add(h2("Schools"));
                        for (School school : educationObj.getSchools()) {
                            //The following pattern can be used for all of a Skill's attributes, e.g. school.getGpa()
                            if (school.getName() != null) {
                                children.add(div().withText(school.getName()));
                            }

                        }
                    }

                    if (educationObj.getExaminations() != null) {
                        children.add(h2("Examinations"));
                        for (Examination examination : educationObj.getExaminations()) {
                            //The following pattern can be used for all of a Skill's attributes, e.g. examination.getGpa()
                            if (examination.getName() != null) {
                                children.add(h3(examination.getName()));

                                if (examination.getSubjects() != null) {
                                    for (ExaminationSubject subject : examination.getSubjects()) {
                                        if (subject.getName() != null) {
                                            children.add(div().withText(subject.getName()));
                                        }

                                        if (subject.getResult() != null) {
                                            children.add(div().withText(subject.getResult()));
                                        }
                                    }
                                }
                            }

                        }
                    }

                }
                education.with(children);
                return education;
            }
        }

Registering `BasicExampleTheme` in `Main.java`'s `registerThemes` function:

    BaseTheme.registerTheme("basicexampletheme", BasicExampleTheme.class);

Which outputs the following when provided with `example.json`:

![output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/2_basic_example_theme_latest.png)

####Adding CSS and JavaScript to your new Theme

To load custom scripts and stylesheets from CSS frameworks like Semantic UI, you need add the stylesheets to `resources/resources.zip` and modify `generateHead`. See the following code snippet from the `generateHead` in `com.lukechenshui.jresume.themes.DefaultTheme`:

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

The above loads Semantic UI and some other stuff to the `head` of the generated html resume. Semantic UI and Bootstrap are already in `resources.zip`.

You can then apply said styles by calling the `withClass` function on any of your `ContainerTag`s and passing any of the required css class names:

    ContainerTag foo = div().withClass("ui");
