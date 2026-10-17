package org.bhenry624.flashcards.ui;

import lombok.NoArgsConstructor;

import static org.bhenry624.flashcards.brains.Brain.waitForKeyEvent;
import static org.bhenry624.flashcards.config.DisplayStrings.MAIN_MENU_STRING;
import static org.bhenry624.flashcards.config.NavigationPaths.MAIN_MENU_PATHS;

@NoArgsConstructor
public class MainMenu {
    public void show(){
        waitForKeyEvent(MAIN_MENU_STRING, MAIN_MENU_PATHS, "Try again!");
    }
}
