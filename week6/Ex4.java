package week6;
import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    }

    public static void displayFileNames(String directory, int space) {
        File path = new File(directory);
        //indentation(space);
        if (path.isDirectory()) {
            System.out.println("<" + path.getName() + ">");

            File[] listDirs = path.listFiles();
            if (listDirs != null) {
                space += 4;
                for (File dir : listDirs) {
                    displayFileNames(dir.getPath(), space);
                }
            }
        } else {
            System.out.println(path.getName());
        }
    }
}
