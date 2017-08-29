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
    public Runtime(File outputDirectory, int id, Config config) {
        this.outputDirectory = outputDirectory;
        this.id = id;
        this.config = config;
    }

    public Runtime(String outputDirectoryStr, int id, Config config) {
        this.outputDirectory = new File(outputDirectoryStr);
        this.id = id;
        this.config = config;
    }

    public  void unzipResourceZip(String file) {
        try {
            tempDirectory = new File("data/jresume-tempresource-zip-dir-" + id);
            tempDirectory.mkdir();

            if (!config.isServerMode()) {
                ZipFile zipFile = new ZipFile(file);
                zipFile.extractAll(tempDirectory.getPath());
            }
            String[] files = tempDirectory.list();
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }
            File resourceDirectory = Paths.get(outputDirectory.getAbsolutePath(), config.getResourceDirectory()).toFile();
            if (!resourceDirectory.exists()) {
                resourceDirectory.mkdirs();
            }

            if (!config.isServerMode()) {
                FileUtils.copyDirectory(tempDirectory, resourceDirectory);
                FileDeleteStrategy.FORCE.delete(tempDirectory);
            }
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
