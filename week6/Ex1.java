package week6;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.Object;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        FileWriter output = new FileWriter("users.txt", true);

        output.write(name + "@" +  address + "@" + age + "\n");

        output.close();
    }
}
