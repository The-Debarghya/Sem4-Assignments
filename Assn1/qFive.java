
/*Write a program that accepts a String and assigns it to another.
Check the outcome of comparison with == and equals() method.
Take two Strings and put same input for them. Repeat the equality checking. Observe the outcome.*/
import java.util.Scanner;

class qFive {
  public static void main(String[] args) {
    String s1;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a new string:");
    s1 = sc.next();
    String s2 = s1;
    String s3 = new String(s1);
    System.out.println(s1 == s2); // true as after assignment, s2 and s1 are the same reference
    System.out.println(s1 == s3); // false because s3 is a new reference of string firstly referred by s1
    System.out.println(s1.equals(s2)); // true
    System.out.println(s1.equals(s3)); // true .equals() compares the contents of strings
    sc.close();
  }
}
