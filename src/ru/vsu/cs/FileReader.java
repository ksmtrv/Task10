package ru.vsu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void readFile(String faculty, Sort sort) {
        File input = new File("src\\ru\\vsu\\cs\\file\\" + faculty + ".txt");
        try {
            Scanner scannerFile = new Scanner(input);
            readLine(scannerFile, sort);
            scannerFile.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found");
            System.exit(1);
        }
    }

    private static void readLine(Scanner scannerFile, Sort sort) {
        String line;
        while (scannerFile.hasNextLine()) {
            line = scannerFile.nextLine();
            divideLine(line, sort);
        }
    }

    private static void divideLine(String line, Sort sort) {
        String[] enrolleeAtribute = line.split("[ \\-#:;$]");
        Enrollee enrollee = new Enrollee(enrolleeAtribute[0], enrolleeAtribute[1], enrolleeAtribute[2],
                Integer.parseInt(enrolleeAtribute[3]), Integer.parseInt(enrolleeAtribute[4]), Integer.parseInt(enrolleeAtribute[5]));
        sort.addEnrollee(enrollee);
    }
}