#JResume - The best JSON->resume generator.

##Example usage

###Example JSON resume (example.json):

    {
      "person": {
        "name": "John Doe",
        "email": "johndoe@gmail.com",
        "address": "7 Java Drive, OOP City",
        "phoneNumber": "+1(334)567-2346",
        "jobTitle": "Software Engineer",
        "website": "https://www.google.com"
      },
      "skills": [
        {
          "name": "Java",
          "competence": "Intermediate"
        },
        {
          "name": "C++",
          "competence": "Beginner"
        },
        {
          "name": "Android",
          "competence": "Intermediate"
        },
        {
          "name": "Wordpress",
          "competence": "Beginner"
        },
        {
          "name": "Laravel",
          "competence": "Beginner"
        },
        {
          "name": "PHP",
          "competence": "Beginner"
        },
        {
          "name": "Python",
          "competence": "Beginner"
        },
        {
          "name": "Javascript",
          "competence": "Beginner"
        }
      ],
      "jobWork": [
        {
          "company": "Example Ltd.",
          "position": "Software Engineer",
          "summary": "At Example Ltd., I did such and such and such and such and such and such and such and such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 1990",
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
          "highlights": [],
          "keywords": []
        }
      ],
      "numSkillColumns": 3
    }

###Usage:

    java -jar jresume.jar --input example.json --output output --theme default

###Output:

![output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/default_theme_at_commit_d17fd0b877099052f09977b4764948eb655a4695.png)