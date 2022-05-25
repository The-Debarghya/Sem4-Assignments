/*Write a program where class contains void show(int) to display the argument passed.
Call the function once with short as actual parameter and again double as actual parameter.
Add another function as void show(double) .
Repeat the calls. Observe the outcomes in each case.*/

public class qSix {
  static void show(int a) {
    System.out.println("the argument passed(was called from show(int)):" + a);
  }

  static void show(double d) {
    System.out.println("the argument passed(was called from show(double)):" + d);
  }

  public static void main(String[] args) {
    short a = 123;
    show(a);
    double d = 34.67;
    show(d); // error in 1st case since double can't be implicitly converted to int
  }
}
