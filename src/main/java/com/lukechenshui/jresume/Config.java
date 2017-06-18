package com.lukechenshui.jresume;

import com.beust.jcommander.Parameter;
import com.lukechenshui.jresume.validators.FileLocationValidator;
import com.lukechenshui.jresume.validators.ThemeNameValidator;

import java.io.File;

/**
 * Created by luke on 1/1/17.
 */
public class Config {
    @Parameter(names = {"--output", "-o"}, description = "The output directory for the generated resume.")
    String outputDirectory = "output";
    @Parameter(names = {"--theme", "-t"}, description = "The theme to use.", validateWith = ThemeNameValidator.class)
    //String themeName = "cv_template1";
    String themeName = "alternating_themes";
    @Parameter(names = {"--server-mode", "-s"}, description = "Launches JResume in server mode.")
    boolean serverMode = false;
    @Parameter(names = {"--server-port", "-sp"}, description = "The port that JResume will listen to when in server mode.")
    int serverPort = 8080;
    @Parameter(names = {"--ssl-mode", "-sm"}, description = "Makes JResume use ssl while in server mode. " +
            "Uses the jresume_keystore_location and jresume_keystore_password for configuring which keystore and password to use." +
            "See https://maximilian-boehm.com/hp2121/Create-a-Java-Keystore-JKS-from-Let-s-Encrypt-Certificates.htm for information on how to generate a keystore" +
            "from a letsencrypt certificate.")
    boolean sslMode = false;
    @Parameter(names = {"--max-threads", "-mt"}, description = "The maximum number of spark threads allowed.")
    int maxThreads = Integer.MAX_VALUE;
    /*If the serverMode parameter is present then --input can be set to anything as it's only important if
      JResume is not running as a server
    */
    @Parameter(names = {"--input", "-i"}, description = "The location of the input file.", required = true)
    String inputFileName;
    @Parameter(names = {"--log-file", "-l"}, description = "The location of the log file", validateWith = FileLocationValidator.class)
    String logFile;
    @Parameter(names = {"--resource-directory", "-rd"}, description = "The subdirectory where the CSS/JS etc resources will be within the zip file.")
    String resourceDirectory = "resources";
    @Parameter(names = {"--show-trackable-information", "-st"}, description = "Shows trackable information such as your address, phone number, etc.")
    boolean showTrackable = false;
    /*
    This zipfile will be created at startup when the jresume is running in server mode. Then, it will
    be copied to each request's output directory and the generated web resume will be added to the copy and
    served to the user.
     */
    File serverInitialResourceZip = new File("data/webresume-resources.zip");

    public Config() {
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public boolean isServerMode() {
        return serverMode;
    }

    public void setServerMode(boolean serverMode) {
        this.serverMode = serverMode;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getMaxThreads() {
        return maxThreads;
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public String getResourceDirectory() {
        return resourceDirectory;
    }

    public void setResourceDirectory(String resourceDirectory) {
        this.resourceDirectory = resourceDirectory;
    }

    public boolean isShowTrackable() {
        return showTrackable;
    }

    public void setShowTrackable(boolean showTrackable) {
        this.showTrackable = showTrackable;
    }

    public boolean isSslMode() {
        return sslMode;
    }

    public void setSslMode(boolean sslMode) {
        this.sslMode = sslMode;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public File getServerInitialResourceZip() {
        return serverInitialResourceZip;
    }

    public void setServerInitialResourceZip(File serverInitialResourceZip) {
        this.serverInitialResourceZip = serverInitialResourceZip;
    }
}
