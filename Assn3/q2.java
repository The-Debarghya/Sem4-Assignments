import java.util.*;

class Account {
  protected int ID;
  protected double balance;
  protected String name;

  public Account(int id, String n, Double b) {
    this.ID = id;
    this.name = n;
    this.balance = b;
  }

  public int retID() {
    return ID;
  }

  public String retName() {
    return name;
  }

  public double retBal() {
    return balance;
  }

  public void addBalance(double d) {
    this.balance = this.balance + d;
  }

  @Override
  public String toString() {
    return ("Account ID:" + ID + ", Account holder name:" + name + ", Balance:Rs" + balance);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Account)) {
      return false;
    }
    Account a = (Account) o;
    return (name.equals(a.name) && Integer.compareUnsigned(ID, a.ID) == 0 && Double.compare(balance, a.balance) == 0);
  }
}

class AccountList {
  protected HashMap<Integer, Account> hm = new HashMap<Integer, Account>();

  public void addAccount() {
    int id;
    double b;
    String n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Name:");
    n = sc.nextLine();
    System.out.print("Enter opening balance:Rs.");
    b = sc.nextDouble();
    Random random = new Random();
    id = random.nextInt(100000);
    Account a = new Account(id, n, b);
    hm.put(a.retID(), a);
    System.out.println("New account created with ID:" + a.ID);
  }

  public void displayAll() {
    System.out.println("The following accounts have been registered:");
    for (Integer name : hm.keySet()) {
      // String key = name.toString();
      String value = hm.get(name).toString();
      System.out.println(value);
    }
  }

  public void search(int ID) {
    Integer id = Integer.valueOf(ID);
    // String key = id.toString();
    String value = hm.get(id).toString();
    System.out.println(value);
  }

  public void viewBalance(int ID) {
    Integer id = Integer.valueOf(ID);
    // String key = id.toString();
    Object value = hm.get(id);
    Account a = (Account) value;
    System.out.println("Current balance of Account ID:" + ID + " is:" + a.retBal());
  }

  public void addBalance(int ID, double d) {
    Integer id = Integer.valueOf(ID);
    // String key = id.toString();
    Object value = hm.get(id);
    Account a = (Account) value;
    a.addBalance(d);
    hm.replace(id, a);
    System.out.println("Account balance successfully updated! New balance for ID:" + ID + " is:" + a.retBal());
  }
}

class q2 {
  public static void main(String[] args) {
    int choice, i;
    double d;
    Scanner sc = new Scanner(System.in);
    AccountList al = new AccountList();
    while (true) {
      System.out.print(
          "1.Add account\n2.Search for an account\n3.Add balance\n4.Display all accounts\n5.View Balance of an account\n6.Exit\nEnter a choice:");
      choice = sc.nextInt();
      switch (choice) {
      case 1:
        al.addAccount();
        break;
      case 2:
        System.out.print("Enter the ID to search:");
        i = sc.nextInt();
        try {
          al.search(i);
        } catch (NullPointerException e) {
          System.out.println("The ID wasn't found.");
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case 3:
        System.out.print("Enter ID:");
        i = sc.nextInt();
        System.out.print("Enter value to add:Rs.");
        d = sc.nextDouble();
        try {
          al.addBalance(i, d);
        } catch (NullPointerException e) {
          System.out.println("The ID wasn't found.");
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case 4:
        al.displayAll();
        break;
      case 5:
        System.out.print("Enter the ID to search:");
        i = sc.nextInt();
        try {
          al.viewBalance(i);
        } catch (NullPointerException e) {
          System.out.println("The ID wasn't found.");
        } catch (Exception e) {
          e.printStackTrace();
        }
        break;
      case 6:
        System.exit(0);
      }
    }
  }
}
