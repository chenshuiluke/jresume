package com.lukechenshui.jresume;

import com.lukechenshui.jresume.ResumeGenerator.WEBREQUEST_TYPE;
import com.lukechenshui.jresume.exceptions.InvalidEnvironmentVariableException;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import static spark.Spark.*;

public class Router {
    Config config;

    Router(Config config) {
        this.config = config;
    }

    private void prepareEnvironment() throws IOException {
        if (Files.exists(Paths.get("data"))) {
            FileDeleteStrategy.FORCE.delete(new File("data"));
        }

        Files.createDirectory(Paths.get("data"));
    }

    public void initializeRoutes() throws Exception {
        if (config.sslMode) {
            String keystoreLocation = Optional.ofNullable(System.getenv("jresume_keystore_location")).orElseThrow(
                    () -> new InvalidEnvironmentVariableException("jresume_keystore_location is not set in the environment"));

            String keystorePassword = Optional.ofNullable(System.getenv("jresume_keystore_password")).orElseThrow(
                    () -> new InvalidEnvironmentVariableException("jresume_keystore_password is not set in the environment"));
            File keystore = new File(keystoreLocation);
            System.out.println("Keystore location:" + keystore.getAbsolutePath());
            System.out.println("Keystore exists: " + keystore.exists());
            System.out.println("Keystore can be read: " + keystore.canRead());
            System.out.println("Keystore can write: " + keystore.canWrite());
            System.out.println("Keystore can execute: " + keystore.canExecute());
            secure(keystoreLocation, keystorePassword, null, null);
        }
        startListeningAsServer();
        post("/webresume/html", "application/json", (request, response) -> {
            ResumeGenerator generator = new ResumeGenerator(config);
            return generator.generateResumeInRoute("default", request, response, WEBREQUEST_TYPE.HTML);
        });

        post("/webresume/pdf", "application/json", (request, response) -> {
            ResumeGenerator generator = new ResumeGenerator(config);
            return generator.generateResumeInRoute("default", request, response, WEBREQUEST_TYPE.PDF);
        });

        post("/webresume/html/:theme", (request, response) -> {
            String desiredTheme = request.params(":theme");
            ArrayList<String> themes = getListOfThemes();
            if (themes.contains(desiredTheme)) {
                ResumeGenerator generator = new ResumeGenerator(config);
                return generator.generateResumeInRoute(desiredTheme, request, response, WEBREQUEST_TYPE.HTML);
            } else {
                response.type("application/json");
                response.status(400);

                JSONObject responseObj = new JSONObject();
                responseObj.put("error", "The theme you have selected does not exist");

                return responseObj.toString();
            }
        });

        post("/webresume/pdf/:theme", (request, response) -> {
            String desiredTheme = request.params(":theme");
            ArrayList<String> themes = getListOfThemes();
            if (themes.contains(desiredTheme)) {
                ResumeGenerator generator = new ResumeGenerator(config);
                return generator.generateResumeInRoute(desiredTheme, request, response, WEBREQUEST_TYPE.PDF);
            } else {
                response.type("application/json");
                response.status(400);

                JSONObject responseObj = new JSONObject();
                responseObj.put("error", "The theme you have selected does not exist");

                return responseObj.toString();
            }
        });


        get("/", (request, response) -> {
            return "Welcome to JResume!";
        });

        get("/themes", (request, response) -> {

            response.type("application/json");
            JSONObject responseObj = new JSONObject();
            JSONArray themeArr = new JSONArray();
            File themeFolder = new File("themes");
            for (String themeName : themeFolder.list()) {
                themeArr.put(FilenameUtils.getBaseName(themeName));
            }
            responseObj.put("themes", themeArr);
            return responseObj.toString();
        });
        exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }

    private void startListeningAsServer() throws Exception {
        threadPool(config.getMaxThreads());
        port(config.getServerPort());
        enableCORS("*", "POST, GET, OPTIONS, DELETE, PUT", "*");
    }

    private void enableCORS(final String origin, final String methods, final String headers) {

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
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
