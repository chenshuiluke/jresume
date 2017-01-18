package com.lukechenshui.jresume;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lukechenshui.jresume.resume.Resume;
import com.lukechenshui.jresume.resume.items.Person;
import com.lukechenshui.jresume.resume.items.work.JobWork;
import com.lukechenshui.jresume.resume.items.work.VolunteerWork;
import com.lukechenshui.jresume.themes.BaseTheme;
import com.lukechenshui.jresume.themes.BasicExampleTheme;
import com.lukechenshui.jresume.themes.DefaultTheme;
import org.w3c.tidy.Tidy;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        registerThemes();
        Config config = new Config();
        new JCommander(config, args);
        //createExample();
        String jsonResumePath = Config.getInputFileName();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";
        copyResourcesZip();
        try {
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }

            Scanner reader = new Scanner(new File(jsonResumePath));
            FileWriter writer = new FileWriter(Runtime.getOutputHtmlFile(), false);
            while (reader.hasNextLine()) {
                json += reader.nextLine();
                json += "\n";
            }
            reader.close();
            System.out.println(json);
            Resume resume = gson.fromJson(json, Resume.class);

            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(json).getAsJsonObject();
            resume.setJsonObject(obj);

            BaseTheme theme = Config.getThemeHashMap().get(Config.getThemeName());
            String html = theme.generate(resume);

            Tidy tidy = new Tidy();
            tidy.setIndentContent(true);
            tidy.setShowWarnings(false);
            tidy.setQuiet(true);

            StringReader htmlStringReader = new StringReader(html);
            StringWriter htmlStringWriter = new StringWriter();
            tidy.parseDOM(htmlStringReader, htmlStringWriter);
            html = htmlStringWriter.toString();
            writer.write(html);

            System.out.println(html);
            writer.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        //createExample();
    }

    public static void registerThemes() {
        BaseTheme.registerTheme("default", DefaultTheme.class);
        BaseTheme.registerTheme("blankexampletheme", BasicExampleTheme.class);
    }

    public static void createExample(){
        Person person = new Person("John Doe", "Junior Software Engineer",
                "800 Java Road, OOP City", "+1(345)-335-8964", "johndoe@gmail.com",
                "http://johndoe.com");
        JobWork jobWork = new JobWork("Example Ltd.", "Software Engineer",
                "At Example Ltd., I did such and such.");

        jobWork.addHighlight("Worked on such and such");
        jobWork.addHighlight("Also worked on this");
        jobWork.addKeyWord("java");
        jobWork.addKeyWord("c++");

        VolunteerWork volunteerWork = new VolunteerWork("Example Institution", "Volunteer",
                "At Example Institution, I did such and such.");
        Resume resume = new Resume();
        resume.setPerson(person);
        resume.addJobWork(jobWork);
        resume.addVolunteerWork(volunteerWork);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(resume);
        System.out.println(json);
        try(FileWriter writer = new FileWriter("example.json")){
            writer.write(json);
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }

    private static void copyResourcesZip() {
        try {
            String classUrl = Main.class.getResource("Main.class").toString();
            File tempFile = File.createTempFile("jresume", "resource");
            tempFile.delete();
            URL url = Main.class.getResource("/resources.zip");
            System.out.println("JAR Resource Zip URL: " + url.toString());
            InputStream inputStream = url.openStream();
            Files.copy(inputStream, tempFile.toPath());
            Runtime.unzipResourceZip(tempFile.getAbsolutePath());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
