package week6;

import java.io.*;
import java.util.*;

public class Ex3 {
    public static void studentWriteToObj() throws IOException {
        Scanner sc = new Scanner(System.in);

        FileOutputStream file = new FileOutputStream("students.obj", true);
        ObjectOutputStream obj = new ObjectOutputStream(file);

        System.out.printf("\nPlease enter student's name: ");
        String name = sc.nextLine();
        System.out.printf("Please enter student's major: ");
        String major = sc.nextLine();
        System.out.printf("Please enter student's GPA: ");
        double GPA = sc.nextFloat();
        sc.nextLine(); // Workaround to prevent future input issues;

        obj.writeObject(new Student(name, major, GPA));
    }

    public static void main(String[] args) throws IOException {
        studentWriteToObj();
    }
}

class Student implements Serializable {
    String name;
    String major;
    Double gpa;

    public Student(String name, String major, Double gpa) {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
}


