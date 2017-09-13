package com.lukechenshui.jresume;

import com.beust.jcommander.JCommander;



import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.tidy.Tidy;


import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.File;

public class Main {
    static Config config;




    public static void main(String[] args) {
        try {
            config = new Config();
            new JCommander(config, args);

            //createExample();
            if(config.testMode){
                Test test = new Test();
                if(!test.test(config)){
                    System.err.println("Test failed");
                    System.exit(1);
                }
            }

            if (config.serverMode) {
              Router router = new Router(config);
              router.initializeRoutes();
            } else {
               ResumeGenerator generator = new ResumeGenerator(config,
                new RuntimeConfiguration(config.getOutputDirectory(), ResumeGenerator.getMultithreadedOutputPrefixNumber(), config));
               generator.writeResume(null, config.themeName);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }


    public static ArrayList<String> getListOfThemes() {
        ArrayList<String> themes = new ArrayList<>();
        File themeFolder = new File("themes");
        for (String themeName : themeFolder.list()) {
            themes.add(FilenameUtils.getBaseName(themeName));
        }
        return themes;
    }
}
