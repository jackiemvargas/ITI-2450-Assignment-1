package PsalmsReaderOnce;

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
        try {
            Scanner keyboard = new Scanner(System.in);
            Scanner file = new Scanner(new File("src/bible-psalms.txt"));

            System.out.print("What Book of Psalms chapter? ");
            int chapter = keyboard.nextInt();

            System.out.print("What Book of Psalms verse within the chapter? ");
            int verse = keyboard.nextInt();

            String wanted = "Psalms " + chapter + ":" + verse;
            boolean found = false;

            while (file.hasNextLine()) {
                String line = file.nextLine();

                if (getReference(line).equals(wanted)) {
                    System.out.println(getVerse(line));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("ERROR: The chapter and verse does not exist.");
            }

            file.close();
            keyboard.close();

        } catch (Exception e) {
            System.out.println("File Error: " + e);
        }
    }
}
