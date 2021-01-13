package ru.vsu.cs;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    private List<Enrollee> listEnrollee;

    public Sort() {
        listEnrollee = new ArrayList<>();
    }

    public void addEnrollee(Enrollee enrollee) {
        listEnrollee.add(enrollee);
    }

    public List<Enrollee> getListEnrollee() {
        return listEnrollee;
    }

    public List<Enrollee> getListEnrolleeByBudget(int quantityBudget) {
        listEnrollee.sort((o1, o2) -> {
            int compareTo = Integer.compare(o2.getSum(), o1.getSum());
            if (compareTo == 0) {
                int compareToMaths = Integer.compare(o2.getMaths(), o1.getMaths());
                if (compareToMaths == 0) {
                    int compareToPhysics = Integer.compare(o2.getPhysics(), o1.getPhysics());
                    if (compareToPhysics == 0) {
                        return Integer.compare(o2.getRussianLanguage(), o1.getRussianLanguage());
                    } else {
                        return compareToPhysics;
                    }
                } else {
                    return compareToMaths;
                }
            } else {
                return compareTo;
            }
        });
        if (listEnrollee.size() <= quantityBudget) {
            return listEnrollee;
        } else {
            List<Enrollee> list = new ArrayList<>();
            for (int i = 0; i < quantityBudget; i++) {
                list.add(listEnrollee.get(i));
            }
            return list;
        }
    }
}