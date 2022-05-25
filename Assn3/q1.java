import java.util.*;

class Department {
  private int code;
  private String name, location;

  public Department(int c, String n, String l) {
    this.code = c;
    this.name = n;
    this.location = l;
  }

  public int retCode() {
    return code;
  }

  public String retName() {
    return name;
  }

  public String retLocation() {
    return location;
  }

  @Override
  public String toString() {
    return ("Dept. Code:" + code + ", Name:" + name + ", location:" + location);
  }
}

class Employee {
  private int empCode, deptCode;
  private String name;
  double basic = 500;

  public Employee(int ec, int dc, String n) {
    this.empCode = ec;
    this.deptCode = dc;
    this.name = n;
  }

  public int retEmpCode() {
    return empCode;
  }

  public int retDeptCode() {
    return deptCode;
  }

  public String retName() {
    return name;
  }

  public void incrBasic(double d) {
    basic = basic + d;
  }

  @Override
  public String toString() {
    return ("Employee code:" + empCode + ", Name:" + name + ", Dept. code:" + deptCode + ", Basic salary:Rs." + basic);
  }
}

class DepartmentList {
  protected ArrayList<Department> dlist = new ArrayList<Department>();

  public void addDept() {
    int code;
    String n, loc;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter name of dept.:");
    n = sc.nextLine();
    System.out.print("Enter Dept. location:");
    loc = sc.nextLine();
    Random random = new Random();
    code = random.nextInt(100000);
    Department d = new Department(code, n, loc);
    dlist.add(d);
    System.out.println("New department added with code:"+code);
  }

  public int search(int code) {
    int flag = 0;
    for (Department d : dlist) {
      if (d.retCode() == code) {
        return flag;
      }
      flag++;
    }
    return -1;
  }

  public Department get(int index) {
    return dlist.get(index);
  }

  public void set(int index, Department element) {
    dlist.set(index, element);
  }

  public int size() {
    return dlist.size();
  }
}

class EmpCodeComparator implements Comparator<Employee> {
  public int compare(Employee e1, Employee e2) {
    if (e1.retEmpCode() == e2.retEmpCode())
      return 0;
    else if (e1.retEmpCode() > e2.retEmpCode())
      return 1;
    else
      return -1;
  }
}

class DeptCodeComparator implements Comparator<Employee> {
  public int compare(Employee e1, Employee e2) {
    if (e1.retDeptCode() == e2.retDeptCode())
      return 0;
    else if (e1.retDeptCode() > e2.retDeptCode())
      return 1;
    else
      return -1;
  }
}

class BasicPayComparator implements Comparator<Employee> {
  public int compare(Employee e1, Employee e2) {
    if (e1.basic == e2.basic)
      return 0;
    else if (e1.basic < e2.basic)
      return 1;
    else
      return -1;
  }
}

class EmployeeList {
  protected ArrayList<Employee> elist = new ArrayList<Employee>();

  public void addEmployee(DepartmentList dlist) {
    int code, index, deptCode;
    String name;
    if (dlist.size() == 0) {
      System.out.println("Dept. has been added yet!");
      return;
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter name:");
    name = sc.nextLine();
    System.out.print("Enter a Dept. code:");
    deptCode = sc.nextInt();
    index = dlist.search(deptCode);
    if (index == -1) {
      System.out.print("Invalid Dept. Please re-enter:");
      deptCode = sc.nextInt();
    }
    Random random = new Random();
    code = random.nextInt(100000);
    Employee e = new Employee(code, deptCode, name);
    elist.add(e);
    System.out.println("New Employee added with code:"+code);
  }

  public void search(int code, DepartmentList dlist) {
    int flag = 0, idx;
    for (Employee e : elist) {
      if (e.retEmpCode() == code) {
        flag = 1;
        System.out.println("Employee found, Details:");
        System.out.println(e);
        System.out.println("Dept. Details:");
        idx = dlist.search(e.retDeptCode());
        Department d = dlist.get(idx);
        System.out.println(d);
      }
    }
    if (flag == 1) {
      System.out.println("Employee with that code not found!");
    }
  }

  public void displayAll(DepartmentList dlist) {
    if (dlist.size() == 0 || elist.size() == 0) {
      System.out.println("No employees has been added!");
      return;
    }
    int idx;
    for (Employee e : elist) {
      System.out.print(e);
      System.out.print(" ");
      idx = dlist.search(e.retDeptCode());
      Department d = dlist.get(idx);
      System.out.println(d);
    }
  }

  public void totalBasicPay(int deptCode, DepartmentList dlist) {
    if (dlist.size() == 0 || elist.size() == 0) {
      System.out.println("No employees has been added!");
      return;
    }
    double total = 0;
    for (Employee e : elist) {
      if (e.retDeptCode() == deptCode) {
        total = total + e.basic;
      }
    }
    System.out.println("Total basic pay for Dept. with code:" + deptCode + ", is:Rs." + total);
  }

  public void remove(int code) {
    if (elist.size() == 0) {
      System.out.println("No employees has been added!");
      return;
    }
    int idx = 0;
    for (Employee e : elist) {
      if (e.retEmpCode() == code) {
        elist.remove(idx);
        System.out.println("The employee with Code:" + code + ", has been successfully removed");
      }
      idx++;
    }
    if (elist.size() > idx) {
      System.out.println("The Employee Code wasn't found");
    }
  }

  public void modifyPayment(int code, double d) {
    if (elist.size() == 0) {
      System.out.println("No employees has been added!");
      return;
    }
    int idx = 0;
    for (Employee e : elist) {
      if (e.retEmpCode() == code) {
        e.incrBasic(d);
        elist.set(idx, e);
        System.out.println("Basic payment updated successfully");
        break;
      }
      idx++;
    }
    if (elist.size() == idx) {
      System.out.println("Employee not found");
    }
  }

  public void sort(int i) {
    if (i == 1) { // descending order according to basic pay
      Collections.sort(elist, new BasicPayComparator());
    } else if (i == 2) { // according to Department code
      Collections.sort(elist, new DeptCodeComparator());
    } else if (i == 3) { // according to Employee code
      Collections.sort(elist, new EmpCodeComparator());
    }
  }
}

class q1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DepartmentList dl = new DepartmentList();
    EmployeeList el = new EmployeeList();
    int choice, i;
    double d;
    while (true) {
      System.out.print(
          "1.Add Department\n2.Add Employee\n3.Search for a Dept.\n4.Search for an Employee\n5.Display All Employees\n6.Find total basic pay for a Dept.\n7.Modify Basic pay for an employee\n8.Remove an employee\n9.Sort Employee List\n10.Exit\nEnter a choice:");
      choice = sc.nextInt();
      switch (choice) {
      case 1:
        dl.addDept();
        break;
      case 2:
        el.addEmployee(dl);
        break;
      case 3:
        System.out.print("Enter dept. code to search:");
        i = sc.nextInt();
        int x = dl.search(i);
        if(x >= 0){
          Department de = dl.get(x);
          System.out.println(de);
        }else{
          System.out.println("The dept. with that code not found!");
        }
        break;
      case 4:
        System.out.print("Enter employee code to search:");
        i = sc.nextInt();
        el.search(i, dl);
        break;
      case 5:
        el.displayAll(dl);
        break;
      case 6:
        System.out.print("Enter Dept. code:");
        i = sc.nextInt();
        el.totalBasicPay(i, dl);
        break;
      case 7:
        System.out.print("Enter employee code:");
        i = sc.nextInt();
        System.out.print("Enter amount you want to add:Rs.");
        d = sc.nextDouble();
        el.modifyPayment(i, d);
        break;
      case 8:
        System.out.print("Enter employee code to remove:");
        i = sc.nextInt();
        try{
          el.remove(i);
        }catch(ConcurrentModificationException e){
          //System.out.println("An error occurred");
          continue;
        }
        break;
      case 9:
        System.out.print("How do you want to sort?(1.Payment wise desc.2.Dept. code wise3.Employee code wise)\n Enter a choice:");
        i = sc.nextInt();
        el.sort(i);
        break;
      case 10:
        System.exit(0);
      }
    }
  }
}
