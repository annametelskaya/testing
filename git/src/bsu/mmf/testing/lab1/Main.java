package bsu.mmf.testing.lab1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1=new Student("Анна", "Метельская", 3, new int[]{7, 8, 9, 5});
        Student student2=new Student("Вероника", "Богданович", 3, new int[]{8, 9, 6});
        Student student3=new Student("Тимофей", "Серединский", 3, new int[]{7, 7});
        Student student4=new Student("Андрей", "Миругин", 3, new int[]{9,8,7});
        Student student5=new Student("Анна","Коростелева",3,new int[]{6,5,7});
	Student student6=new Student("Ира", "Васькова", 3, new int[]{7, 8, 5});
        System.out.println(student1+"Средний балл: "+student1.getAverageRating()+"\n");
        System.out.println(student2+"Средний балл: "+student2.getAverageRating()+"\n");
        System.out.println(student3+"Средний балл: "+student3.getAverageRating()+"\n");
        System.out.println(student4+"Средний балл: "+student4.getAverageRating()+"\n");
        System.out.println(student5+"Средний балл: "+student5.getAverageRating()+"\n");
        System.out.println(student6+"Средний балл: "+student5.getAverageRating()+"\n");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        Group group = new Group(1, students);
        System.out.println(group+"Средний балл группы: "+group.getAverageRatingOfGroup());

	ArrayList<Student> students1 = new ArrayList<>();
        students1.add(student2);
        students1.add(student5);
        students1.add(student6);
	students1.add(atudent1);
        Group group1 = new Group(2, students1);
        System.out.println(group1+"Средний балл группы: "+group1.getAverageRatingOfGroup());

    }
}
