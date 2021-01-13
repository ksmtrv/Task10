package ru.vsu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String faculty = readString("the name of the faculty: ");
        int quantityBudget = readInt("number of budget places: ");

        Admission admission = new Admission();
        readFile(faculty, admission);

        List<Enrollee> listEnrollee = admission.getListEnrollee();

        System.out.println("List of applicants: ");
        printListEnrollee(listEnrollee);
        System.out.println();

        List<Enrollee> enrolleeByBudget = admission.getEnrolleeByBudget(quantityBudget);

        writeFile(enrolleeByBudget, faculty);
        System.out.println("List of applicants received on the budget: ");
        printListEnrollee(enrolleeByBudget);
    }

    private static int readInt(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s ", name);
        return scanner.nextInt();
    }

    private static String readString(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s ", name);
        return scanner.nextLine();
    }

    private static void readFile(String faculty, Admission admission) {
        File input = new File("src\\ru\\vsu\\cs\\file\\" + faculty + ".txt");
        try {
            Scanner scannerFile = new Scanner(input);
            String line;

            while (scannerFile.hasNextLine()) {
                line = scannerFile.nextLine();
                String[] words = line.split("[ \\-#:;$]");

                Enrollee enrollee = new Enrollee(words[0], words[1], words[2],
                        Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]));
                admission.addEnrollee(enrollee);
            }
            scannerFile.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found");
            System.exit(1);
        }
    }

    private static void writeFile(List<Enrollee> list, String faculty) throws Exception {
        FileWriter output = new FileWriter("src\\ru\\vsu\\cs\\file\\" + faculty + "-budget.txt");
        output.write(String.valueOf(list));
        output.close();
    }

    private static void printListEnrollee(List<Enrollee> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}