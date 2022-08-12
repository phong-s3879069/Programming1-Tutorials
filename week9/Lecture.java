package week9;

public class Lecture {
    public static void main(String[] args) {
        Shape s = new Rectangle("Rectangle", new double[]{10, 5});
        System.out.println(s);
        if (s instanceof Object){
            System.out.println("s is a Object");
        } else {
            System.out.println("s is not a Object");
        }
    }

}

class Shape {
    String type;
    double[] dimension;

    public Shape(String type, double[] dimension) {
        // object creation
        this.type = type;
        this.dimension = dimension;
    }
    public double getArea() {
        return 0;
    }
    public String toString() {
        return String.format("The area is %.2f", getArea());
    }
}

class Circle extends Shape{
    double radius;
    public Circle(String type, double[] dimension){
        super(type, dimension);
        radius = dimension[0];
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Square extends Shape{
    double size;
    public Square(String type, double[] dimension){
        super(type, dimension);
        size = dimension[0];
    }

    public double getArea() {
        return size * size;
    }
}

class Rectangle extends Shape{
    double length, width;
    public Rectangle(String type, double[] dimension){
        super(type, dimension);
        length = dimension[0];
        width = dimension[1];
    }

    public double getArea() {
        return length * width;
    }
}