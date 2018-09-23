package bsu.mmf.testing.lab1;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private int courseId;
    private int[] rating;

    @Override
    public String toString() {
        return "Имя: " + name +
                " Фамилия: " + surname + " Номер курса: " + courseId +
                " Оценки: " + Arrays.toString(rating) + "\n";
    }

    public Student(String name, String surname, int courseId, int[] rating) {
        this.name = name;
        this.surname = surname;
        this.courseId = courseId;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourseNumber() {
        return courseId;
    }

    public void setCourseNumber(int courseId) {
        this.courseId = courseId;
    }

    public int[] getRating() {
        return rating;
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getAverageRating() {
        double avg = 0;
        for (int i = 0; i < this.rating.length; i++) {
            avg += this.rating[i];
        }
        avg /= this.rating.length;
        return avg;
    }
}
