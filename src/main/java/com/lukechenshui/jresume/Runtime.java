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

    public Runtime(File outputDirectory, int id) {
        this.outputDirectory = outputDirectory;
        this.id = id;
    }

    public Runtime(String outputDirectoryStr, int id) {
        this.outputDirectory = new File(outputDirectoryStr);
        this.id = id;
    }

    public  void unzipResourceZip(String file) {
        try {
            tempDirectory = new File("data/jresume-tempresource-zip-dir-" + id);
            tempDirectory.mkdir();
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(tempDirectory.getPath());

            String[] files = tempDirectory.list();
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }
            File resourceDirectory = Paths.get(outputDirectory.getAbsolutePath(), "/resources").toFile();
            if (!resourceDirectory.exists()) {
                resourceDirectory.mkdirs();
            }
            FileUtils.copyDirectory(tempDirectory, resourceDirectory);
            FileDeleteStrategy.FORCE.delete(tempDirectory);
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
