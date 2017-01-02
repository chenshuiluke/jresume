package com.lukechenshui.jresume.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import com.lukechenshui.jresume.Config;
import com.lukechenshui.jresume.themes.BaseTheme;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by luke on 1/1/17.
 */
public class ThemeNameValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        BaseTheme theme = Config.getThemeHashMap().get(value);
        if (theme == null) {
            Set<String> themeNameSet = Config.getThemeHashMap().keySet();
            String[] validThemes = themeNameSet.toArray(new String[themeNameSet.size()]);
            throw new ParameterException("You have chosen an invalid theme. Valid themes are: " + Arrays.toString(validThemes));
        }
    }
}
