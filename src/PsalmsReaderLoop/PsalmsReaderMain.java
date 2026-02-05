package PsalmsReaderLoop;

import java.io.File;
import java.util.Scanner;

public class PsalmsReaderMain {

    static String getReference(String line) {
        return line.split("\t")[0].replaceAll("\\s+", " ").trim();
    }

    static String getVerse(String line) {
        return line.split("\t")[1].trim();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.print("\nWhat Book of Psalms chapter? ");

            if (!keyboard.hasNextInt()) {
                System.out.println("ERROR: Chapter must be a positive integer, start again.");
                keyboard.next();
                continue;
            }

            int chapter = keyboard.nextInt();

            if (chapter == 0) {
                System.out.println("Thank you for reading the Book of Psalms!");
                break;
            }

            if (chapter < 0) {
                System.out.println("ERROR: Chapter must be a positive integer, start again.");
                continue;
            }

            System.out.print("What Book of Psalms verse within the chapter? ");

            if (!keyboard.hasNextInt()) {
                System.out.println("ERROR: Verse must be a positive integer, start again.");
                keyboard.next();
                continue;
            }

            int verse = keyboard.nextInt();

            if (verse <= 0) {
                System.out.println("ERROR: Verse must be a positive integer, start again.");
                continue;
            }

            String wanted = "Psalms " + chapter + ":" + verse;
            boolean found = false;

            try {
                Scanner file = new Scanner(new File("src/bible-psalms.txt"));

                while (file.hasNextLine()) {
                    String line = file.nextLine();

                    if (getReference(line).equals(wanted)) {
                        System.out.println(getVerse(line));
                        found = true;
                        break;
                    }
                }

                file.close();

                if (!found) {
                    System.out.println("ERROR: The chapter and verse does not exist, start again.");
                }

            } catch (Exception e) {
                System.out.println("File Error: " + e);
            }
        }

        keyboard.close();
    }
}
