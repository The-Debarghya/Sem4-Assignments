import java.util.*;

class BankAcct {
  protected int CustomerID;
  protected String name;
  protected long phno;
  protected double loan;
  static final int fixedAmtNormal = 10000000;
  static final int fixedAmtPrivileged = 20000000;
  protected boolean privileged;

  BankAcct(int i, String n, long p) {
    this.CustomerID = i;
    this.name = n;
    this.phno = p;
    this.loan = 0.0;
    this.privileged = false;
  }

  void isPrivileged() {
    this.privileged = true;
  }

  int retCustomerId() {
    return this.CustomerID;
  }

  public void takeLoan(double l) {
    if (this.privileged) {
      if (this.loan < fixedAmtPrivileged && (this.loan + l) <= fixedAmtPrivileged) {
        this.loan = this.loan + l;
        System.out.println("Requested amount can be granted");
      } else {
        System.out.println("You have exceeded Rs.20000000 so loan can't be granted");
      }
    } else {
      if (this.loan < fixedAmtNormal && (this.loan + l) <= fixedAmtNormal) {
        this.loan = this.loan + l;
        System.out.println("Requested amount can be granted");
      } else {
        System.out.println("You have exceeded Rs.10000000 so loan can't be granted");
      }
    }
  }

  void viewLoanDetails() {
    if (this.privileged) {
      System.out.println("CustomerID:" + this.CustomerID + ", Name:" + this.name);
      System.out.println("Maximum credit allowed:Rs." + fixedAmtPrivileged);
      System.out.println("Total loan taken by the customer:Rs." + this.loan);
      System.out.println("Total loan can be taken further:Rs." + (fixedAmtPrivileged - this.loan));
    } else {
      System.out.println("CustomerID:" + this.CustomerID + ", Name:" + this.name);
      System.out.println("Maximum credit allowed:Rs." + fixedAmtNormal);
      System.out.println("Total loan taken by the customer:Rs." + this.loan);
      System.out.println("Total loan can be taken further:Rs." + (fixedAmtNormal - this.loan));
    }
  }

  void showDetails() {
    System.out.print("CustomerID:" + this.CustomerID + ", Name:" + this.name + ", Phone:" + this.phno);
    if (this.privileged) {
      System.out.println(", Privileged Customer:Yes");
    } else {
      System.out.println(", Privileged Customer:No");
    }
    System.out.println("Loan taken by the customer:Rs" + this.loan);
  }
}

class Bank {
  protected ArrayList<BankAcct> list = new ArrayList<BankAcct>();

  public void addAccount() {
    int i;
    String n;
    long p;
    char c;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter name:");
    n = sc.nextLine();
    System.out.print("Enter phone no.:");
    p = sc.nextLong();
    Random random = new Random();
    i = random.nextInt(100000);
    BankAcct b = new BankAcct(i, n, p);
    System.out.print("Is the customer privileged?(y/n)");
    c = sc.next().charAt(0);
    if (c == 'y' || c == 'Y') {
      b.isPrivileged();
    }
    // sc.close();
    list.add(b);
    System.out.println("New account created with Customer ID:" + b.retCustomerId());
  }

  public void showAccount(int id) {
    boolean flag = false;

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).retCustomerId() == id) {
        list.get(i).showDetails();
        flag = true;
      }
    }
    if (!flag)
      System.out.println("Customer Not Found !");
  }

  public void showAccountLoanDetails(int id) {
    boolean flag = false;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).retCustomerId() == id) {
        list.get(i).viewLoanDetails();
        flag = true;
      }
    }
    if (!flag)
      System.out.println("Customer Not Found !");
  }

  public void getLoan(int id) {
    boolean flag = false;
    Scanner sc = new Scanner(System.in);
    double l;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).retCustomerId() == id) {
        System.out.print("How much loan do you want to take:Rs");
        l = sc.nextDouble();
        list.get(i).takeLoan(l);
        flag = true;
      }
    }
    // sc.close();
    if (!flag)
      System.out.println("Customer Not Found !");
  }
}

class q1 {
  public static void main(String[] args) {
    Bank bankobj = new Bank();
    while (true) {
      int i;
      Scanner sc = new Scanner(System.in);
      System.out.println("1.Add account\n2.Show Account details\n3.Show Loan Status\n4.Get loan\n5.Exit");
      System.out.print("Enter a choice:");
      int choice = sc.nextInt();
      switch (choice) {
      case 1:
        bankobj.addAccount();
        break;
      case 2:
        System.out.print("Enter id:");
        i = sc.nextInt();
        bankobj.showAccount(i);
        break;
      case 3:
        System.out.print("Enter id:");
        i = sc.nextInt();
        bankobj.showAccountLoanDetails(i);
        break;
      case 4:
        System.out.print("Enter id:");
        i = sc.nextInt();
        bankobj.getLoan(i);
        break;
      case 5:
        System.exit(0);
        break;
      default:
        System.out.println("1.Add account\n2.Show Account details\n3.Show Loan Status\n4.Get loan\n5.Exit");

      }
    }
  }
}
