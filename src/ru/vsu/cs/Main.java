package ru.vsu.cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String faculty = readString("the name of the faculty: ");
        int quantityBudget = readInt("number of budget places: ");

        Sort sort = new Sort();
        FileReader.readFile(faculty, sort);

        List<Enrollee> listEnrollee = sort.getListEnrollee();

        System.out.println("List of applicants: ");
        printListEnrollee(listEnrollee);
        System.out.println();

        List<Enrollee> listEnrolleeByBudget = sort.getListEnrolleeByBudget(quantityBudget);

        FileWriter.writeFile(listEnrolleeByBudget, faculty);
        System.out.println("List of applicants received on the budget: ");
        printListEnrollee(listEnrolleeByBudget);
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

    private static void printListEnrollee(List<Enrollee> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}