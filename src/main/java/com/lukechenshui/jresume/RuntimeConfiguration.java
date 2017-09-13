package com.lukechenshui.jresume;


import java.io.File;
import java.nio.file.Paths;

/**
 * A per-resume generation request configuration object
 */
public class RuntimeConfiguration {


    private File tempDirectory;
    private File outputDirectory;
    private int id;
    private Config config;
    private ResumeGenerator.WEBREQUEST_TYPE webrequest_type = ResumeGenerator.WEBREQUEST_TYPE.HTML;

    public RuntimeConfiguration(File outputDirectory, int id, Config config) {
        this.outputDirectory = outputDirectory;
        this.id = id;
        this.config = config;
    }

    public RuntimeConfiguration(File outputDirectory, int id, Config config, ResumeGenerator.WEBREQUEST_TYPE type) {
        this(outputDirectory, id, config);
        this.webrequest_type = type;
    }

    public RuntimeConfiguration(String outputDirectoryStr, int id, Config config) {
        this.outputDirectory = new File(outputDirectoryStr);
        this.id = id;
        this.config = config;
    }

    public ResumeGenerator.WEBREQUEST_TYPE getWebRequestType() {
        return webrequest_type;
    }

    public void setWebRequestType(ResumeGenerator.WEBREQUEST_TYPE webrequest_type) {
        this.webrequest_type = webrequest_type;
    }

    public File getResourceDirectory() {
        return Paths.get(outputDirectory.getAbsolutePath(), "/resources").toFile();
    }

    public File getOutputHtmlFile() {
        return Paths.get(outputDirectory.getAbsolutePath(), "resume.html").toFile();
    }

    public File getOutputHtmlFile(String file) {
        return Paths.get(outputDirectory.getAbsolutePath(), file).toFile();
    }

    public File getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
