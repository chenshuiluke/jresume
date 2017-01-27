package com.lukechenshui.jresume.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.apache.commons.io.FileDeleteStrategy;

import java.io.File;
import java.io.IOException;

/**
 * Created by luke on 1/27/17.
 */
public class FileLocationValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        File file = new File(value);
        ParameterException exception = new ParameterException("File " + file.getAbsolutePath() + " does not exist and cannot be created.");
        try {

            if (!file.exists()) {
                boolean canCreate = file.createNewFile();
                if (canCreate) {
                    FileDeleteStrategy.FORCE.delete(file);
                } else {
                    throw exception;
                }

            }
        } catch (IOException exc) {
            throw exception;
        }

    }
}
