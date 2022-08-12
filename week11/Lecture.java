package week11;

public class Lecture {
    public static void main(String[] args) {
        int[] a = new int[3];
        try {
            //a[2] = 1 / 0;
            Lecture lec = new Lecture();
            lec.test();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Continue as normal");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Can't believe I have math error");
        }
        catch (BasicMathException e) {
            System.out.println(e.getMessage());
            System.out.println("Can't believe I have a basic math exception");
        }
        System.out.println("Just works");
    }
    void test() throws BasicMathException{
        throw new BasicMathException("wrong");
    }

}

class BasicMathException extends Exception {
    public BasicMathException(String str) {
        super("Very basic exception: " + str);
    }

}

class BasicMath1Exception extends BasicMathException {
    public BasicMath1Exception(String str) {
        super(str);
    }
}



