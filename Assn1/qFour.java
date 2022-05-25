
/*Write a program that accepts radius of a circle and displays area of the circle.
Declare a constant pi equals to 3.14.*/
import java.util.Scanner;
import java.lang.Math;

class qFour {
  public static void main(String[] args) {
    double area, radius;
    final double pi = 3.14;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the radius of the circle: ");
    radius = sc.nextDouble();
    area = pi * Math.pow(radius, 2);
    System.out.println("Area of the circle:" + area);
    sc.close();
  }
}
