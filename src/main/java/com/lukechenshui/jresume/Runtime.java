package com.lukechenshui.jresume;

import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by luke on 1/1/17.
 */
public class Runtime {
    private  File tempDirectory;

    public  void unzipResourceZip(String file) {
        try {
            tempDirectory = Files.createTempDirectory("jresume").toFile();
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(tempDirectory.getPath());

            String[] files = tempDirectory.list();
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }
            File resourceDirectory = Paths.get(Config.getOutputDirectory(), "/resources").toFile();
            if (!resourceDirectory.exists()) {
                resourceDirectory.mkdirs();
            }
            FileUtils.copyDirectory(tempDirectory, resourceDirectory);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public  File getResourceDirectory() {
        return Paths.get(Config.getOutputDirectory(), "/resources").toFile();
    }

    public  File getOutputHtmlFile() {
        return Paths.get(Config.getOutputDirectory(), "resume.html").toFile();
    }

}
