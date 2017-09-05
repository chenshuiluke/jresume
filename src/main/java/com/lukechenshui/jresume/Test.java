package com.lukechenshui.jresume;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukechenshui.jresume.resume.Resume;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public boolean test(Config config){

        String json = "{ \"skillsHeading\": \"Custom Skills Heading\", \"jobWorkHeading\": \"Custom Work Heading\", \"referencesHeading\": \"References\", \"accomplishmentsHeading\": \"Custom Accomplishments Heading\", \"projectsHeading\": \"Custom Projects Heading\", \"hobbiesHeading\": \"Custom Hobbies Heading\", \"personInfoHeading\": \"Personal Info\", \"websiteHeading\": \"WWW\", \"phoneHeading\": \"Phone Number\", \"emailHeading\": \"Email\", \"keySkillsHeading\": \"Key Skills\", \"technicalSkillsHeading\": \"Technical Skills\", \"person\": { \"name\": \"Bob\", \"email\": \"johndoe@gmail.com\", \"address\": \"7 Java Drive, OOP City\", \"phoneNumber\": \"+1(334)567-2346\", \"jobTitle\": \"Software Engineer\", \"website\": \"https://www.google.com\", \"objective\": \"Paragraph 1 Paragraph 1 Paragraph 1 Paragraph 1 Paragraph 1 Paragraph 1 Paragraph 1<br><br>Paragraph 2 Paragraph 2 Paragraph 2 Paragraph 2 Paragraph 2 Paragraph 2 Paragraph 2\" }, \"skills\": [ \"Java\", \"C++\", \"Android\" ], \"accomplishments\": [ \"I did something remarkable.\", \"I did something else remarkable.\" ], \"jobWork\": [ { \"company\": \"Example Ltd.\", \"position\": \"Software Engineer\", \"summary\": \"At Example Ltd., I did such and such and such and such and such and such and such and such and such.\", \"startDate\": \"August 19, 1997\", \"endDate\": \"August 19, 2001\", \"highlights\": [ \"Worked on such and such\", \"I did such and such and such and such and such and such and such and such and such. I did such and such and such and such and such and such and such and such and such.\", \"Also worked on this\" ], \"keywords\": [ \"java\", \"c++\" ] }, { \"company\": \"Example Ltd.2\", \"position\": \"Software Engineer\", \"summary\": \"At Example Ltd.2, I did such and such and such and such and such and such and such and such and such.\", \"startDate\": \"August 19, 1997\", \"endDate\": \"August 19, 2001\", \"highlights\": [ \"Worked on such and such\", \"Also worked on this\" ], \"keywords\": [ \"java\", \"c++\" ] } ], \"volunteerWork\": [ { \"company\": \"Example Institution\", \"position\": \"Volunteer\", \"summary\": \"At Example Institution, I did such and such.\", \"startDate\": \"August 19, 1997\", \"endDate\": \"August 19, 2001\", \"highlights\": [ \"Worked on such and such\", \"Also worked on this\" ], \"keywords\": [ \"java\", \"c++\" ] }, { \"company\": \"Example Institution2\", \"position\": \"Volunteer\", \"summary\": \"At Example Institution2, I did such and such.\", \"startDate\": \"August 19, 1997\", \"endDate\": \"August 19, 2001\", \"highlights\": [ \"Worked on such and such\", \"Also worked on this\" ], \"keywords\": [ \"java\", \"c++\" ] } ], \"projects\": [ { \"name\": \"AwesomeProject\", \"description\": \"This awesome project is awesome!\", \"highlights\": [ \"Does such and such.\", \"And it does such and such.\" ], \"keywords\": [ \"java\", \"c++\" ], \"url\": \"https://www.github.com\" }, { \"name\": \"AwesomeProject2\", \"description\": \"This awesome project2 is awesome!\", \"highlights\": [ \"Does such and such.\", \"And it does such and such.\" ], \"keywords\": [ \"java\", \"c++\" ], \"url\": \"https://www.github.com\" } ], \"education\": { \"schools\": [ { \"name\": \"Ardenne High School\", \"startDate\": \"100AD\", \"endDate\": \"104AD\", \"summary\": \"Some summary!\", \"gpa\": \"5.0\", \"address\": \"School Address\" } ], \"examinations\": [ { \"name\": \"CSEC\", \"startDate\": \"104AD\", \"subjects\": [ { \"name\": \"Math\", \"result\": \"100\" }, { \"name\": \"English\", \"result\": \"100\" } ] } ] }, \"hobbies\": [ \"Programming\", \"Video editing\", \"Gaming\" ], \"references\": [ { \"name\": \"Someone\", \"email\": \"Someone@email.com\", \"phoneNumber\": \"111-1111\", \"jobTitle\": \"Manager\", \"company\": \"Some Company 1\" }, { \"name\": \"Someone Else\", \"email\": \"SomeoneElse@email.com\", \"phoneNumber\": \"111-1221\", \"jobTitle\": \"CEO\", \"company\": \"Some Company 2\" } ] }";

        for(int counter = 0; counter < 1000; counter++){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String tempJson = randomlySetToNull(json);

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
            Template temp = null;
            try{
                cfg.setDirectoryForTemplateLoading(new File("themes"));
                temp = cfg.getTemplate(config.themeName + ".html");
            }
            catch (IOException exc){
                exc.printStackTrace();
                return false;
            }
            cfg.setDefaultEncoding("UTF-8");
            //System.out.println(json);
            Resume resume = gson.fromJson(tempJson, Resume.class);
            resume.getRidOfArraysWithEmptyElements();
            resume.setConfig(config);
            StringWriter htmlStringWriter = new StringWriter();
            try {
                temp.process(resume, htmlStringWriter);
            }
            catch (TemplateException|IOException exc){
                exc.printStackTrace();
                return false;
            }

            String html = htmlStringWriter.toString();
        }
        return true;
    }

    public String randomlySetToNull(String json){
        JSONObject jsonObj = new JSONObject(json);
        jsonObj = recurseOverJsonObj(jsonObj);
        return jsonObj.toString();

    }

    public JSONObject recurseOverJsonObj( JSONObject json){
        for(String key : json.keySet()){
            Object obj = json.get(key);
            if(obj instanceof JSONObject){
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.put(key, JSONObject.NULL);
                }
                else{
                    json.put(key, recurseOverJsonObj((JSONObject)obj));
                }
            }
            else if(obj instanceof JSONArray){
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.put(key, JSONObject.NULL);
                }
                else{
                    json.put(key, recurseOverJsonArr((JSONArray)obj));
                }
            }
            else{
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.put(key, JSONObject.NULL);
                }
            }
        }
        return json;
    }

    public JSONArray recurseOverJsonArr( JSONArray json){
        for(int counter = 0; counter < json.length(); counter++){
            Object obj = json.get(counter);
            if(obj instanceof JSONObject){
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.remove(counter);
                }
                else{
                    json.put(counter, recurseOverJsonObj((JSONObject)obj));
                }
            }
            else if(obj instanceof JSONArray){
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.put(counter, JSONObject.NULL);
                }
                else{
                    json.put(counter, recurseOverJsonArr((JSONArray)obj));
                }
            }
            else{
                int min = 0;
                int max = 1;
                int result = ThreadLocalRandom.current().nextInt(min, max + 1);

                if(result == max){
                    json.remove(counter);
                }
            }
        }
        return json;
    }

}
