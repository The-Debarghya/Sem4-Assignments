
/*Write a program that accepts height in cm as int and displays the height in feet and inches.
Assume, 1 inch equals to 2.54 cm and 1 foot equals to 30.5 cm.*/

import java.util.Scanner;

class qThree {
  public static void main(String[] args) {
    int ht;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your height (in cm): ");
    ht = sc.nextInt();
    double feet = ht / 30.5;
    double inch = ht / 2.54;
    System.out.printf("Height in inches: %.3f\n", inch);
    System.out.printf("Height in feet: %.3f\n", feet);
    sc.close();
  }
}
