package week6;

import java.io.*;

public class IOTest {
}

class Cake implements Serializable {
    public String name;
    private double price;

    public Cake(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + ": " + price;
    }
}

class OutputTest {
    public static void main(String[] args) throws IOException {
        // create 2 cakes and save to a file
        FileOutputStream of = new FileOutputStream("cakes.obj");
        ObjectOutputStream cakeOut = new ObjectOutputStream(of);
        Cake c1 = new Cake("Pie", 20.51);
        Cake c2 = new Cake("Apple", 9.99);
        cakeOut.writeObject(c1);
        cakeOut.writeObject(c2);
    }
}

class InputTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // get 2 cakes back from a file
        FileInputStream of = new FileInputStream("cakes.obj");
        ObjectInputStream cakeIn = new ObjectInputStream(of);
        Cake c1 = (Cake)cakeIn.readObject();
        Cake c2 = (Cake)cakeIn.readObject();
        System.out.println(c1);
        System.out.println(c2);
    }
}

class FileTest {
    public static void main(String[] args) {
        File current = new File("src");
        display(current, 0);
    }

    static void display(File current, int level) {
        File[] files = current.listFiles();
        for (File f : files) {
            int temp = level;
            String space = "";
            while (temp > 0) {
                space += " ";
                temp--;
            }
            System.out.println(space + f.getName());
            if (f.isDirectory()) {
                display(f, level + 1);
            }
        }
    }
}