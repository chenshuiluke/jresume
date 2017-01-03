package com.lukechenshui.jresume.resume.items;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;

import static j2html.TagCreator.br;
import static j2html.TagCreator.div;

/**
 * Created by luke on 1/2/17.
 */
public class BaseResumeItem {
    int numPrecedingLineBreaks = 0;
    int numFollowingLineBreaks = 0;

    public int getNumPrecedingLineBreaks() {
        return numPrecedingLineBreaks;
    }

    public void setNumPrecedingLineBreaks(int numPrecedingLineBreaks) {
        this.numPrecedingLineBreaks = numPrecedingLineBreaks;
    }

    public int getNumFollowingLineBreaks() {
        return numFollowingLineBreaks;
    }

    public void setNumFollowingLineBreaks(int numFollowingLineBreaks) {
        this.numFollowingLineBreaks = numFollowingLineBreaks;
    }

    public ContainerTag generatePrecedingLineBreaks() {
        ContainerTag lineBreakDiv = div();
        for (int counter = 0; counter < numPrecedingLineBreaks; counter++) {
            lineBreakDiv.with(br());
        }
        return lineBreakDiv;
    }

    public Tag checkForAndGeneratePrecedingLineBreaks() {
        if (numPrecedingLineBreaks > 0) {
            return generatePrecedingLineBreaks();
        } else {
            return div();
        }
    }

    public ContainerTag generateFollowingLineBreaks() {
        ContainerTag lineBreakDiv = div();
        for (int counter = 0; counter < numFollowingLineBreaks; counter++) {
            lineBreakDiv.with(br());
        }
        System.out.println("Num following linebreaks: " + numFollowingLineBreaks);
        return lineBreakDiv;
    }

    public Tag checkForAndGenerateFollowingLineBreaks() {
        if (numFollowingLineBreaks > 0) {
            return generateFollowingLineBreaks();
        } else {
            return div();
        }
    }
}
