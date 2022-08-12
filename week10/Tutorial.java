package week10;

import java.util.ArrayList;

public class Tutorial {
    public static void main(String[] args) {
        Item i1 = new Item("Soup", 2.1);
        Item i2 = new Item("Noodle", 2.3);
        Item i3 = new Item("Pizza", 5.6);

        // test code
        int n = 5;
        Booking[] bookings = new Booking[n];

        // create booking randomly
        for (int i = 0; i < n; i++) {
            double d = Math.random();
            if (d < 0.33) {
                bookings[i] = new WesternBooking();
            } else if (d < 0.66) {
                bookings[i] = new OtherBooking();
            } else {
                bookings[i] = new SocialBooking();
            }
            bookings[i].addItem(i1);
            bookings[i].addItem(i2);
            bookings[i].addItem(i3);
            // Total item sum is 10 for each booking
        }

        double totalTax = 0.0;

        for (Booking b : bookings) {
            // only get tax from taxable bookings
            if (b instanceof Taxable) {
                System.out.println(b.getClass().getName());
                System.out.println("This booking is taxable");
                totalTax += ((Taxable) b).calculateTax();
            } else {
                System.out.println(b.getClass().getName());
                System.out.println("This booking is not taxable");
            }
        }

        System.out.printf("Total tax to collect: $%.2f\n", totalTax);
    }
}

class Item {
    public String name;
    public double price;

    public Item(String n, double p) {
        name = n;
        price = p;
    }
}

abstract class Booking implements Taxable {
    private ArrayList<Item> items;
    protected Discount discount;

    public Booking() {
        items = new ArrayList<Item>();
    }

    public double calculateTax() {
        return 0;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public double bookingSum() {
        double sum = 0;
        for (Item i : items) {
            sum += i.price;
        }
        return sum;
    }

    public void addDiscount(Discount d) {
        discount = d;
    }
}

class WesternBooking extends Booking implements Taxable {
    static final double FIXED_TIP = 0.15;
    static final double WESTERN_TAX = 0.1;

    public double bookingSum() {
        double itemsSum = super.bookingSum();
        double d = (discount == null) ? 0 : discount.calculateDiscountedAmount(itemsSum);
        return itemsSum * (1 + FIXED_TIP) - d;
    }

    public double calculateTax() {
        double itemSum = super.bookingSum();
        return itemSum * WESTERN_TAX;
    }
}

class OtherBooking extends Booking implements Taxable {
    static final double MAX_TIP = 0.1;
    static final double OTHER_TAX = 0.15;

    public double bookingSum() {
        double itemsSum = super.bookingSum();
        double d = (discount == null) ? 0 : discount.calculateDiscountedAmount(itemsSum);
        return itemsSum * (1 + MAX_TIP * Math.random()) - d;
    }

    public double calculateTax() {
        double itemSum = super.bookingSum();
        return itemSum * OTHER_TAX;
    }
}

// this class does not implement the Taxable interface
class SocialBooking extends Booking {
    // I will use a different tip for this
    static final double SOCIAL_TIP = 0.17;

    public double bookingSum() {
        double itemsSum = super.bookingSum();
        double d = (discount == null) ? 0 : discount.calculateDiscountedAmount(itemsSum);
        return itemsSum * (1 + SOCIAL_TIP) - d;
    }
}

class Discount {
    String code;

    public Discount(String c) {
        code = c;
    }
    public double calculateDiscountedAmount(double sum) {
        // do not know how to calculate discount on generic discount obj
        return 0;
    }
}

class VoucherDiscount extends Discount {
    public double amount;

    public VoucherDiscount(String c, double a) {
        super(c);
        amount = a;
    }

    public double calculateDiscountedAmount(double sum) {
        if (amount > sum) {
            return sum;
        }
        return amount;
    }
}

class PercentOffDiscount extends Discount {
    public int percent;

    public PercentOffDiscount(String c, int p) {
        super(c);
        percent = p;
    }

    public double calculateDiscountedAmount(double sum) {
        return sum * percent / 100;
    }
}

class SpecialEventDiscount extends Discount {
    public int value;

    public SpecialEventDiscount(String c, int v) {
        super(c);
        value = v;
    }

    public double calculateDiscountedAmount(double sum) {
        // percent off amount
        double percentOffAmount = sum * value / 100;

        // which one is greater?
        double max = Math.max(value, percentOffAmount);

        // final check: discount > sum
        if (max > sum) {
            return sum;
        }
        return max;
    }
}

interface Taxable {
    public double calculateTax();
}