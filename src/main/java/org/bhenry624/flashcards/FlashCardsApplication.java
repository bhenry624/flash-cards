package org.bhenry624.flashcards;

import org.bhenry624.flashcards.ui.MainMenu;

import java.io.*;
import java.util.*;

public class FlashCardsApplication {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
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

    public static Map<String, String> HashMapFromTextFile(String fileName)
    {

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