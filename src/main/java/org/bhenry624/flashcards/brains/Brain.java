package org.bhenry624.flashcards.brains;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Scanner;

@NoArgsConstructor
public class Brain {
    static final Scanner scanner = new Scanner(System.in);

    public void waitForKeyEvent(String displayMessage, HashMap<String, String> behaviors, String errMessage) {
        System.out.println(displayMessage);

        String keyInput = scanner.next().toUpperCase();

        while (!behaviors.containsKey(keyInput)){
            System.out.println(errMessage);

            keyInput = scanner.next();
        }
    }
}
