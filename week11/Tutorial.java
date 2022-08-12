package week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tutorial {
    public static void main(String[] args) {
        boolean fileExist = false;
        String fileName = null;
        while (!fileExist) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a file name: ");
                fileName = scanner.nextLine();
                readFile("C:\\Users\\Admin\\IdeaProjects\\week1\\src\\week11\\" + fileName + ".txt");
                fileExist = true;
            } catch (Exception e) {
                System.out.printf("File %s not found in this package\n", fileName);
            }
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
        input.close();
    }


//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            String name, line;
//            boolean check = false;
//            while (!check) {
//                try {
//                    System.out.print("Please type in a valid filename: ");
//                    name = sc.nextLine();
//                    BufferedReader br = new BufferedReader(new FileReader(name));
//                    while ((line = sc.nextLine()) != null) {
//                        System.out.println(line);
//                        br.close();
//                    }
//                    check = true;
//                } catch (IOException e) {
//                    System.out.println("INVALID FILE!");
//                }
//            }
//        }
//    }
}

