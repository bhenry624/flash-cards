package org.bhenry624.flashcards.config;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DisplayStrings {
    public static final String MAIN_MENU_STRING = """
           =======================================
           Welcome! Please select an option below:
           
           [G] to generate a new data set.
           [T] to begin the memory test.
           [E] to exit.
                  
           =======================================
            """;

    public static final String GENERATE_CARDS_STRING = """
           =======================================
           This is where you can generate a new set of key-pair cards to test against.
           Please select an option below:
           
           [M] to go to main menu.
           [T] to begin the memory test.
           [E] to exit.
                  
           =======================================
            """;

    public static final String MEMORY_TEST_STRING = """
           =======================================
           Welcome to the memory test!
           Please select an option below:
           
           [M] to go to main menu.
           [E] to exit.
                  
           =======================================
            """;
}
