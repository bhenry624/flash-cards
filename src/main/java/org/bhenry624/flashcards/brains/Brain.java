package org.bhenry624.flashcards.brains;

import lombok.NoArgsConstructor;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.bhenry624.flashcards.config.DisplayStrings.*;
import static org.bhenry624.flashcards.config.NavigationPaths.*;

@NoArgsConstructor
public class Brain {
    static final Scanner scanner = new Scanner(System.in);

    public void startUp() {
        waitForKeyEvent(MAIN_MENU_STRING, MAIN_MENU_PATHS);
    }

    public static void waitForKeyEvent(String displayMessage, List<Character> paths) {
        System.out.println(displayMessage);

        char keyInput = scanner.next().toUpperCase().charAt(0);

        while (!paths.contains(keyInput)){
            System.out.println("Try Again!");

            keyInput = scanner.next().toUpperCase().charAt(0);
        }

        switch(keyInput){
            case 'M':
                waitForKeyEvent(MAIN_MENU_STRING, MAIN_MENU_PATHS);
            case 'G':
                waitForKeyEvent(GENERATE_CARDS_STRING, GENERATE_CARDS_PATHS);
            case 'T':
                waitForKeyEvent(MEMORY_TEST_STRING, MEMORY_TEST_PATHS);
            case 'E':
                System.exit(0);
            default:
                waitForKeyEvent(MAIN_MENU_STRING, MAIN_MENU_PATHS);
        }
    }

    public static Map<String, String> HashMapFromTextFile(String fileName) {

        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = null;

        try {

            File file = new File("src/main/resources/dictionaries/" + fileName + ".txt");

            br = new BufferedReader(new FileReader(file));

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(":");

                String name = parts[0].trim();
                String number = parts[1].trim();

                if (!name.isEmpty() && !number.isEmpty())
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        return map;
    }

    public static String createDataSet(Scanner scanner) {
        System.out.println("Give the file a name, then press enter.");

        String fileName = scanner.nextLine();


        HashMap<String, String> studyPairs = new HashMap<>();

        System.out.println("Please input the number of cards you are making. Whole numbers only.");

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Please input the key, followed by the value, separated by ||");

            String response = scanner.nextLine();

            String key = response.substring(0, response.indexOf("||"));
            String val = response.substring(response.indexOf("||") + 2);

            studyPairs.put(key, val);
        }

        File file = new File("src/main/resources/dictionaries" + fileName + ".txt");

        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, String> entry :
                    studyPairs.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }

            bf.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert bf != null;
                bf.close();
            } catch (Exception ignored) {

            }
        }

        return fileName;
    }
}
