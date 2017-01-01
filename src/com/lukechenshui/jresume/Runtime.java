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
    private static File tempDirectory;

    public static void unzipResourceZip(String file) {
        try {
            tempDirectory = Files.createTempDirectory("jresume").toFile();
            ZipFile zipFile = new ZipFile(file);
            zipFile.extractAll(tempDirectory.getPath());

            String[] files = tempDirectory.list();
            if (!Files.exists(Paths.get("output"))) {
                Files.createDirectory(Paths.get("output"));
            }
            if (!Files.exists(Paths.get("output/resources"))) {
                Files.createDirectory(Paths.get("output/resources"));
            }
            FileUtils.copyDirectory(tempDirectory, new File("output/resources"));
        } catch (Exception exc) {

            exc.printStackTrace();
        }
    }

    public static File getResourceDirectory() {
        return new File("output/resources");
    }

}
