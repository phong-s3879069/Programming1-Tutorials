package week9;

import java.util.ArrayList;

public class Tutorial {
    public static void main(String[] args) {
        Item i1 = new Item("Soup", 5.1);
        Item i2 = new Item("Noodle", 2.3);
        Item i3 = new Item("Pizza", 13.6);

        Booking b = new WesternBooking();
//    Booking b = new OtherBooking();
        b.addItem(i1);
        b.addItem(i2);
        b.addItem(i3);
        // Total without tip is 21

        // tip = 3.15

        // Add a discount
        b.addDiscount(new VoucherDiscount("Test", 2.5));
//    b.addDiscount(new PercentOffDiscount("Test", 50));
//    b.addDiscount(new SpecialEventDiscount("Test", 21));

        System.out.println("Total amount to pay: " + b.bookingSum());
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

class Booking {
    private ArrayList<Item> items;
    protected Discount discount;

    public Booking() {
        items = new ArrayList<Item>();
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

class WesternBooking extends Booking {
    static final double FIXED_TIP = 0.15;

    public double bookingSum() {
        double itemsSum = super.bookingSum();
        double d = (discount == null) ? 0 : discount.calculateDiscountedAmount(itemsSum);
        return itemsSum * (1 + FIXED_TIP) - d;
    }
}

class OtherBooking extends Booking {
    static double MAX_TIP = 0.1;

    public double bookingSum() {
        double itemsSum = super.bookingSum();
        double d = (discount == null) ? 0 : discount.calculateDiscountedAmount(itemsSum);
        return itemsSum * (1 + MAX_TIP * Math.random()) - d;
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