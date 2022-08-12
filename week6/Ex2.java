package week6;
import java.io.*;
import java.util.*;
public class Ex2 {
    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("students.obj");
        BufferedReader reader1 = new BufferedReader(reader);

        String line;
        line = reader1.readLine();

        while (line != null) {
            String[] array = line.split("@");
            System.out.println("Name is " + array[0] + ", Major is " + array[1] + ", GPA is " + array[2]);
            line = reader1.readLine();
        }

    }
}
