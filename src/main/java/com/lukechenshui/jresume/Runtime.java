package com.lukechenshui.jresume;

import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by luke on 1/1/17.
 */
public class Runtime {
    private  File tempDirectory;
    private File outputDirectory;
    private int id;
    private Config config;
    private Main.WEBREQUEST_TYPE webrequest_type = Main.WEBREQUEST_TYPE.HTML;
    public Runtime(File outputDirectory, int id, Config config) {
        this.outputDirectory = outputDirectory;
        this.id = id;
        this.config = config;
    }

    public Main.WEBREQUEST_TYPE getWebRequestType() {
        return webrequest_type;
    }

    public void setWebRequestType(Main.WEBREQUEST_TYPE webrequest_type) {
        this.webrequest_type = webrequest_type;
    }

    public Runtime(File outputDirectory, int id, Config config, Main.WEBREQUEST_TYPE type) {
        this(outputDirectory, id, config);
        this.webrequest_type = type;
    }

    public Runtime(String outputDirectoryStr, int id, Config config) {
        this.outputDirectory = new File(outputDirectoryStr);
        this.id = id;
        this.config = config;
    }

    public  void unzipResourceZip(String file) {
        try {
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }
            File resourceDirectory = Paths.get(outputDirectory.getAbsolutePath(), config.getResourceDirectory()).toFile();
            if (!resourceDirectory.exists()) {
                resourceDirectory.mkdirs();
            }

            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(resourceDirectory.getAbsolutePath());

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public  File getResourceDirectory() {
        return Paths.get(outputDirectory.getAbsolutePath(), "/resources").toFile();
    }

    public  File getOutputHtmlFile() {
        return Paths.get(outputDirectory.getAbsolutePath(), "resume.html").toFile();
    }

    public  File getOutputHtmlFile(String file) {
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
