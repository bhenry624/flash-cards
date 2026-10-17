package org.bhenry624.flashcards.ui;

import static org.bhenry624.flashcards.brains.Brain.waitForKeyEvent;
import static org.bhenry624.flashcards.config.DisplayStrings.MEMORY_TEST_STRING;
import static org.bhenry624.flashcards.config.NavigationPaths.MEMORY_TEST_PATHS;

public class MemoryTest {
    public void show(){
        waitForKeyEvent(MEMORY_TEST_STRING, MEMORY_TEST_PATHS, "Try again!");
    }
}
