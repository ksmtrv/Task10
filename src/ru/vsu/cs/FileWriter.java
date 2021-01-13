package ru.vsu.cs;

import java.util.List;

public class FileWriter {

    public static void writeFile(List<Enrollee> list, String faculty) throws Exception {
        java.io.FileWriter output = new java.io.FileWriter("src\\ru\\vsu\\cs\\file\\" + faculty + "-budget.txt");
        for (int i = 0; i < list.size(); i++) {
            output.write(list.get(i) + "\n");
        }
        output.close();
    }
}