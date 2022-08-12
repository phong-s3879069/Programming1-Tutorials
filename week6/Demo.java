package week6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        // Writing
        Student1 student1 = new Student1("S001", "Tom");
        PrintWriter print = new PrintWriter("student.txt");
        print.printf("%s\t%s\n", student1.id, student1.name);
        Student1 student2 = new Student1("S002", "Alice");
        print.printf("%s\t%s\n", student2.id, student2.name);
        print.close();
        // Reading
        Scanner sc = new Scanner(new File("student.txt"));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split("\t");
            Student1 s = new Student1(tokens[0], tokens[1]);
            s.display();
        }
    }
}

class Student1 {
    String id;
    String name;

    public Student1(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.printf("\nStudent %s %s", id, name);
    }
}