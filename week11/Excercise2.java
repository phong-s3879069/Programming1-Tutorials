package week11;

import java.util.Scanner;

public class Excercise2 {
    public static void main(String args[]) {
        boolean status = false;
        System.out.println("Enter a number: ");
        while (!status) {
            try {
                getIntFromUser(0);
                status = true;
            }
            catch (Exception e) {
                System.out.println("It is not an integer");
            }
        }


    }

    public static int getIntFromUser(int defaultValue) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e){
            result = defaultValue;
            return result;
        }
        return result;
    }


}
