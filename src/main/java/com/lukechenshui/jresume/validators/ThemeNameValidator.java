package com.lukechenshui.jresume.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import com.lukechenshui.jresume.Router;

import java.util.ArrayList;

/**
 * Created by luke on 1/27/17.
 */
public class ThemeNameValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        ArrayList<String> themes = Router.getListOfThemes();

        if (!themes.contains(value)) {
            throw new ParameterException("The theme " + value + " does not exist.");
        }
    }
}
