package org.bhenry624.flashcards.ui;

import static org.bhenry624.flashcards.brains.Brain.waitForKeyEvent;
import static org.bhenry624.flashcards.config.DisplayStrings.GENERATE_CARDS_STRING;
import static org.bhenry624.flashcards.config.NavigationPaths.GENERATE_CARDS_PATHS;

public class GenerateCards {
    public void show(){
        waitForKeyEvent(GENERATE_CARDS_STRING, GENERATE_CARDS_PATHS, "Try again!");
    }
}
