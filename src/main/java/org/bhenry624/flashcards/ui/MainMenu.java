package org.bhenry624.flashcards.ui;

import lombok.NoArgsConstructor;
import org.bhenry624.flashcards.brains.Brain;

import java.util.HashMap;
import java.util.Map;

import static org.bhenry624.flashcards.displays.DisplayStrings.MAIN_MENU_STRING;

@NoArgsConstructor
public class MainMenu {
    Brain brain = new Brain();


    public void mainMenu(){
        HashMap<String, String> initBehaviors = new HashMap<>(Map.of("N", "TestTest", "L", "Load Test", "E", "Exit"));

        brain.waitForKeyEvent(MAIN_MENU_STRING, initBehaviors, "Try again!");
    }


}
