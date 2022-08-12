package week11;

public class Excercise3 {
    public static void main(String[] args) {
        Dog d = treatMeAsDog(new Cat());
    }

    public static Dog treatMeAsDog(Animal a) {
        try {
            return (Dog) a;
        } catch (ClassCastException o) {
            System.out.println("IMPOSSIBLE");
            return null;
        }
    }
}

abstract class Animal {
    abstract public void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("moew");
    }
}
