
/*Design a BankAcct class with account number, balance and interest rate as attribute.
Interest rate is same for all account. Support must be there to initialize, change and display the interest rate.
Also supports are to be there to return balance and calculate interest.*/
import java.util.Scanner;
import java.text.DecimalFormat;

class BankAcct {
  private int accNum;
  static float rate = 5;
  private double balance;

  BankAcct(int a, double b) { // default constructor
    this.accNum = a;
    this.balance = b;
  }

  static void setInterest(float f) {
    rate = f;
  }

  void addBalance(double d) { // adds new balance
    this.balance = this.balance + d;
  }

  public double returnBalance() { // returns the balance of invoking instance
    return this.balance;
  }

  double calculateInterest(int months) { // calculates total interest for monthly rate
    double in;
    in = this.balance * rate * months / 100.0;
    return in;
  }

  void display() {
    DecimalFormat ft = new DecimalFormat(".###");
    System.out.println("Account No.:" + accNum + " Total Balance:" + ft.format(balance));
  }
}

class qNine {
  public static void main(String[] args) {
    BankAcct b1 = new BankAcct(7890, 700.0);
    System.out.println("Opening Info:");
    b1.display();
    int m;
    float f;
    Scanner sc = new Scanner(System.in);
    System.out.print("Calculate interest for months:");
    m = sc.nextInt();
    DecimalFormat ft = new DecimalFormat(".###");
    System.out.println("Total interest for " + m + " months:" + ft.format(b1.calculateInterest(m)) + "(at "
        + BankAcct.rate + "% monthly interest)");
    b1.addBalance(b1.calculateInterest(m));
    System.out.println("After " + m + " months:");
    b1.display();
    System.out.print("Enter new interest rate:");
    f = sc.nextFloat();
    BankAcct.setInterest(f);
    System.out.print("Calculate interest for months:");
    m = sc.nextInt();
    System.out.println("Total interest for " + m + " months:" + ft.format(b1.calculateInterest(m)) + "(at "
        + BankAcct.rate + "% monthly interest)");
    b1.addBalance(b1.calculateInterest(m));
    System.out.println("After " + m + " months:");
    b1.display();
    sc.close();
  }
}
