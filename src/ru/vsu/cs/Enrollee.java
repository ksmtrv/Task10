package ru.vsu.cs;

public class Enrollee {

    private String lastName;
    private String firstName;
    private String patronymic;
    private int maths;
    private int physics;
    private int russianLanguage;

    public Enrollee(String lastName, String firstName, String patronymic, int maths, int physics, int russianLanguage) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.maths = maths;
        this.physics = physics;
        this.russianLanguage = russianLanguage;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    public int getRussianLanguage() {
        return russianLanguage;
    }

    public Integer getSum() {
        return maths + physics + russianLanguage;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " (" + maths + ", " + physics + ", " + russianLanguage + ')';
    }
}