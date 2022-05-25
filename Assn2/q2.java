import java.util.*;

class Address {
  String street, city, state;
  int pin, premises;

  void getData() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter premises:");
    this.premises = sc.nextInt();
    System.out.print("Enter street:");
    this.street = sc.nextLine();
    System.out.print("Enter city:");
    this.city = sc.nextLine();
    System.out.print("Enter pin:");
    this.pin = sc.nextInt();
    System.out.print("Enter state:");
    this.state = sc.nextLine();
  }

  void changeStreet(Object s) {
    this.street = (String) s;
  }

  void changeCity(Object s) {
    this.city = (String) s;
  }

  void changeState(Object s) {
    this.state = (String) s;
  }

  void changePin(Object s) {
    this.pin = (Integer) s;
  }

  void changePremises(Object s) {
    this.premises = (Integer) s;
  }

  @Override
  public String toString() {
    return (premises + " " + street + ", " + city + ", " + state + ", PIN:" + pin);
  }
}

abstract class Person {
  protected String name;
  protected String email;
  protected long phno;
  protected Address addr;

  Person(String n, String e, long p, Address a) {
    this.name = n;
    this.phno = p;
    this.email = e;
    this.addr = a;
  }

  void display() {
    System.out.println("Name:" + this.name);
    System.out.println("Contact info: email:" + this.email + ", Phone:" + this.phno + ", Address:" + this.addr);
  }

  void changeAddress(int i) {
    Scanner sc = new Scanner(System.in);
    Integer j;
    String k;
    switch (i) {
    case 1:
      System.out.print("Enter new street:");
      k = sc.nextLine();
      this.addr.changeStreet(k);
      break;
    case 2:
      System.out.print("Enter new city:");
      k = sc.nextLine();
      this.addr.changeCity(k);
      break;
    case 3:
      System.out.print("Enter new state:");
      k = sc.nextLine();
      this.addr.changeState(k);
      break;
    case 4:
      System.out.print("Enter new pin code:");
      j = sc.nextInt();
      this.addr.changePin(j);
      break;
    case 5:
      System.out.print("Enter new street:");
      j = sc.nextInt();
      this.addr.changePremises(j);
      break;
    }
  }
}

class Student extends Person {
  protected int roll;
  protected String course;

  Student(String n, String e, long p, Address a, int r, String c) {
    super(n, e, p, a);
    this.roll = r;
    this.course = c;
  }

  public int getRoll() {
    return roll;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("Designation:Student, Roll:" + this.roll + ", Course:" + this.course);
  }
}

class Faculty extends Person {
  protected int employeeID;
  protected String dept, specialization;

  Faculty(String n, String e, long p, Address a, int id, String d, String sp) {
    super(n, e, p, a);
    this.employeeID = id;
    this.dept = d;
    this.specialization = sp;
  }

  public int getEmployeeID() {
    return employeeID;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("Designation:Faculty, employeeID:" + this.employeeID + ", Dept.:" + this.dept
        + ", Specialization:" + this.specialization);
  }
}

class Institute {
  protected ArrayList<Student> slist = new ArrayList<Student>();
  protected ArrayList<Faculty> flist = new ArrayList<Faculty>();

  public void addFaculty() { // method to add faculty
    Scanner sc = new Scanner(System.in);
    int id;
    long p;
    String n, e, d, sp;
    Address ad = new Address();
    System.out.print("Enter name:");
    n = sc.nextLine();
    System.out.print("Enter Dept.:");
    d = sc.nextLine();
    System.out.print("Enter phone:");
    p = sc.nextLong();
    System.out.print("Enter email Id:");
    e = sc.nextLine();
    System.out.print("Enter Specialization:");
    sp = sc.nextLine();
    System.out.println("Give Address Details:");
    ad.getData();
    Random random = new Random();
    id = random.nextInt(100000);
    Faculty f = new Faculty(n, e, p, ad, id, d, sp);
    flist.add(f);
  }

  public void addStudent() { // method to add faculty
    Scanner sc = new Scanner(System.in);
    int roll;
    long p;
    String n, e, c;
    Address ad = new Address();
    System.out.print("Enter name:");
    n = sc.nextLine();    
    System.out.print("Enter email Id:");
    e = sc.nextLine();
    System.out.print("Enter course of study:");
    c = sc.nextLine();
    System.out.print("Enter Roll:");
    roll = sc.nextInt();
    System.out.print("Enter phone:");
    p = sc.nextLong();
    System.out.println("Give Address Details:");
    ad.getData();
    Student st = new Student(n, e, p, ad, roll, c);
    slist.add(st);
  }

  public void showFaculty(int id) {
    boolean flag = false;
    for (int i = 0; i < flist.size(); i++) {
      if (flist.get(i).getEmployeeID() == id) {
        flist.get(i).display();
        flag = true;
      }
    }
    if (!flag)
      System.out.println("No Faculty with the given id exists !");
  }

  // method to display a student
  public void showStudent(int id) {
    boolean flag = false;
    for (int i = 0; i < slist.size(); i++) {
      if (slist.get(i).getRoll() == id) {
        slist.get(i).display();
        flag = true;
      }
    }
    if (!flag)
      System.out.println("No Student with the given id exists !");
  }

  // method to change the address of a faculty
  public void changeFacultyAddress(int id) {
    boolean flag = false;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < flist.size(); i++) {
      if (flist.get(i).getEmployeeID() == id) {
        System.out.println(
            "1.Change premises\n2.Change pin\n3.Change street\n4.Change city\n5.Change state\nEnter a choice:");
        int j = sc.nextInt();
        flist.get(i).changeAddress(j);
        flag = true;
      }
    }
    if (!flag)
      System.out.println("No Faculty with the given id exists !");
  }

  // method to change the address of a student
  public void changeStudentAddress(int id) {
    boolean flag = false;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < slist.size(); i++) {
      if (slist.get(i).getRoll() == id) {
        System.out
            .print("1.Change premises\n2.Change pin\n3.Change street\n4.Change city\n5.Change state\nEnter a choice:");
        int j = sc.nextInt();
        slist.get(i).changeAddress(j);
        flag = true;
      }
    }
    if (!flag)
      System.out.println("No Student with the given id exists !");
  }
}

class q2 {
  public static void main(String[] args) {
    Institute obj = new Institute();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print(
          "1. Add Student\n2. Add Faculty\n3. Show Student\n4. Show Faculty\n5. Change Student Address\n6. Change Faculty Address\n7. Exit\nEnter Choice :");
      int ch = Integer.parseInt(sc.nextLine());
      switch (ch) {
      case 1:
        obj.addStudent();
        break;
      case 2:
        obj.addFaculty();
        break;
      case 3:
        System.out.print("Enter Student Roll Number :- ");
        int roll = Integer.parseInt(sc.nextLine());
        obj.showStudent(roll);
        break;
      case 4:
        System.out.print("Enter Faculty Id :- ");
        int id = Integer.parseInt(sc.nextLine());
        obj.showFaculty(id);
        break;
      case 5:
        System.out.print("Enter Student Roll Number :- ");
        roll = Integer.parseInt(sc.nextLine());
        obj.changeStudentAddress(roll);
        break;
      case 6:
        System.out.print("Enter Faculty Id :- ");
        id = Integer.parseInt(sc.nextLine());
        obj.changeFacultyAddress(id);
        break;
      default:
        System.exit(0);
        break;
      }
    }
  }
}
