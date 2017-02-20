package com.lukechenshui.jresume;

import com.beust.jcommander.Parameter;
import com.lukechenshui.jresume.themes.BaseTheme;
import com.lukechenshui.jresume.validators.FileLocationValidator;
import com.lukechenshui.jresume.validators.ThemeNameValidator;

import java.io.File;
import java.util.HashMap;

/**
 * Created by luke on 1/1/17.
 */
public class Config {
    @Parameter(names = {"--output", "-o"}, description = "The output directory for the generated resume.")
    static String outputDirectory = "output";
    @Parameter(names = {"--theme", "-t"}, description = "The theme to use.", validateWith = ThemeNameValidator.class)
    static String themeName = "default";
    @Parameter(names = {"--server-mode", "-s"}, description = "Launches JResume in server mode.")
    static boolean serverMode = false;
    @Parameter(names = {"--server-port", "-sp"}, description = "The port that JResume will listen to when in server mode.")
    static int serverPort = 8080;
    @Parameter(names = {"--ssl-mode", "-sm"}, description = "Makes JResume use ssl while in server mode. " +
            "Uses the jresume_keystore_location and jresume_keystore_password for configuring which keystore and password to use." +
            "See https://maximilian-boehm.com/hp2121/Create-a-Java-Keystore-JKS-from-Let-s-Encrypt-Certificates.htm for information on how to generate a keystore" +
            "from a letsencrypt certificate.")
    static boolean sslMode = false;
    @Parameter(names = {"--max-threads", "-mt"}, description = "The maximum number of spark threads allowed.")
    static int maxThreads = Integer.MAX_VALUE;
    /*If the serverMode parameter is present then --input can be set to anything as it's only important if
      JResume is not running as a server
    */
    @Parameter(names = {"--input", "-i"}, description = "The location of the input file.", required = true)
    static String inputFileName;

    @Parameter(names = {"--log-file", "-l"}, description = "The location of the log file", validateWith = FileLocationValidator.class)
    static String logFile;

    @Parameter(names = {"--resource-directory", "-rd"}, description = "The subdirectory where the CSS/JS etc resources will be within the zip file.")
    static String resourceDirectory = "resources";

    /*
    This zipfile will be created at startup when the jresume is running in server mode. Then, it will
    be copied to each request's output directory and the generated web resume will be added to the copy and
    served to the user.
     */
    static File serverInitialResourceZip = new File("data/webresume-resources.zip");

    private static HashMap<String, BaseTheme> themeHashMap = new HashMap<String, BaseTheme>();


    public static void addTheme(Object theme) {
        if (theme instanceof BaseTheme) {
            BaseTheme themeObj = (BaseTheme) theme;
            themeHashMap.put(themeObj.getThemeName(), themeObj);
        } else {
            throw new IllegalArgumentException("Object passed to addTheme is not instance or decendant of BaseTheme.");
        }

    }

    public static HashMap<String, BaseTheme> getThemeHashMap() {
        return themeHashMap;
    }

    public static void setThemeHashMap(HashMap<String, BaseTheme> themeHashMap) {
        Config.themeHashMap = themeHashMap;
    }

    public static String getOutputDirectory() {
        return outputDirectory;
    }

    public static void setOutputDirectory(String outputDirectory) {
        Config.outputDirectory = outputDirectory;
    }

    public static String getThemeName() {
        return themeName;
    }

    public static void setThemeName(String themeName) {
        Config.themeName = themeName;
    }

    public static String getInputFileName() {
        return inputFileName;
    }

    public static void setInputFileName(String inputFileName) {
        Config.inputFileName = inputFileName;
    }

    public static boolean isServerMode() {
        return serverMode;
    }

    public static void setServerMode(boolean serverMode) {
        Config.serverMode = serverMode;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static void setServerPort(int serverPort) {
        Config.serverPort = serverPort;
    }

    public static int getMaxThreads() {
        return maxThreads;
    }

    public static void setMaxThreads(int maxThreads) {
        Config.maxThreads = maxThreads;
    }

    public static String getResourceDirectory() {
        return resourceDirectory;
    }

    public static void setResourceDirectory(String resourceDirectory) {
        Config.resourceDirectory = resourceDirectory;
    }
}
