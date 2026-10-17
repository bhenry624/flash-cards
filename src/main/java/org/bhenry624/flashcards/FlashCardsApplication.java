package org.bhenry624.flashcards;

import org.bhenry624.flashcards.brains.Brain;

public class FlashCardsApplication {
    public static void main(String[] args) {
        Brain brain = new Brain();
        brain.startUp();
//        Scanner input = new Scanner(System.in);
//
//        String name = createDataSet(input);
//
//        System.out.println("Data Set created, loading....");
//
//        Map<String, String> cards = HashMapFromTextFile(name);
//
//        List<Map.Entry<String, String>> shuffledCards =
//                new ArrayList<>(cards.entrySet());
//
//        Collections.shuffle(shuffledCards);
//
//        input.close();
    }
}