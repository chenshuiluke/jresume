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
      "jobWork": [
        {
          "company": "Example Ltd.",
          "position": "Software Engineer",
          "summary": "At Example Ltd., I did such and such and such and such and such and such and such and such and such.",
          "startDate": "August 19, 1997",
          "endDate": "August 19, 1990t",
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
      ]
    }

###Usage:

    java -jar jresume.jar --input example.json --output output --theme default

###Output:

![output](https://raw.githubusercontent.com/chenshuiluke/jresume/master/screenshots/default_theme_at_commit_07d8c69c6d41f728fb72fe35917c60b66861cee5.png)