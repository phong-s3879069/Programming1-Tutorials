package week10;

public class Lecture {
    public static void main(String[] args) {
//        Vaccine v = new Vaccine();

        Vaccine[] vaccines = new Vaccine[5];
        for (int i =0; i < vaccines.length; i ++){
            double r = Math.random();
            if (r < 0.3){
                vaccines[i] = new Moderna();
            } else if (r < 0.6){
                vaccines[i] = new Pfizer();
            } else {
                vaccines[i] = new AstraZeneca();
            }
        }
        for (Vaccine v : vaccines) {
            System.out.println(v);
            v.inject1();
            System.out.printf("You have to wait for %d days\n", v.waitingTime2ndDose());
            v.inject2();
            if (v instanceof Aprrovable) {
                System.out.println("This one is approved");
            }
            if (v instanceof Buyable) {
                System.out.println("This one can be bought");
            }
            System.out.println("----------------------");
        }
    }
}

abstract class Vaccine {
    double amount;

    public void inject1() {
        System.out.println("This is the first dose");
    }

    public abstract int waitingTime2ndDose();

    public void inject2() {
        System.out.println("This is the second dose");
    }
}

class Pfizer extends Vaccine implements Aprrovable, Buyable{
    public int waitingTime2ndDose() {
        return 21;
    }

    public String toString() {
        return "Pfizer";
    }

    public void satisfyX() {
    }
    public void satisfyY() {
    }

    public double howmuch() {
        return 123;
    }
}
class Moderna extends Vaccine{
    public int waitingTime2ndDose() {
        return 28;
    }

    public String toString() {
        return "Moderna";
    }
}

class AstraZeneca extends Vaccine{
    public int waitingTime2ndDose() {
        return 60;
    }
    public String toString() {
        return "AstraZeneca";
    }
}

interface Aprrovable {
    public void satisfyX();
    public void satisfyY();
}

interface Buyable {
    public double howmuch();
}

interface Sort {
    public void sort();
}
