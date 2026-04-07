package LAB03;
public class shapes {
    double value1;
    double value2;
    double value3;
    shapes() 
    {
        value1 = 0;
        value2 = 0;
        value3 = 0;
    }

    shapes(int side) 
    {
        value1 = side;
    }

    shapes(double length, double breadth) 
    {
        value1 = length;
        value2 = breadth;
    }

    shapes(float radius) 
    {
        value3 = radius;
    }

    double area(int side) 
    {
        return side * side;
    }

    double area(double length, double breadth) 
    {
        return length * breadth;
    }

    double area(float radius) 
    {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        shapes square = new shapes(5);
        shapes rectangle = new shapes(4.5, 6.0);
        shapes circle = new shapes(3.0f);

        System.out.println("Area of Square = " + square.area(5));
        System.out.println("Area of Rectangle = " + rectangle.area(4.5, 6.0));
        System.out.println("Area of Circle = " + circle.area(3.0f));
    }
}
