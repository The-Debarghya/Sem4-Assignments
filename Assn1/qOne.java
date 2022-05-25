
/*Write a program to accept two short integers from user and display the sum.*/

import java.util.*; //scanner object for taking input

class qOne {
  public static void main(String[] args) {
    short a, b;
    int c;
    Scanner sc = new Scanner(System.in);
    try{
        System.out.print("Enter 1st number: ");
        a = sc.nextShort();
        System.out.print("Enter 2nd number: ");
        b = sc.nextShort();
        c = a + b;
        System.out.println("Sum of numbers:" + c);
    }catch(Exception e){
        System.out.println("Invalid Input");
    }
    sc.close();
  }
}
