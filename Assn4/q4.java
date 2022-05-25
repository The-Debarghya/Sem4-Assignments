import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Department {
  private int code;
  private String name;

  public Department(int c, String n) {
    this.code = c;
    this.name = n;
  }

  public int retCode() {
    return code;
  }

  @Override
  public String toString() {
    return (name);
  }
}

class DepartmentList {
  protected ArrayList<Department> dlist = new ArrayList<Department>();

  public void addDept() {
    int code;
    String n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter name of dept.:");
    n = sc.nextLine();
    Random random = new Random();
    code = random.nextInt(100000);
    Department d = new Department(code, n);
    dlist.add(d);
    System.out.println("New department added with code:" + code);
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

  public boolean isEmpty() {
    return dlist.isEmpty();
  }

  public Department get(int index) {
    return dlist.get(index);
  }

  public void displayAll() {
    for (Department d : dlist) {
      System.out.print("Code:" + d.retCode() + ", Name:");
      System.out.println(d);
    }
  }

  public Department[] getList() {
    Department[] a = new Department[dlist.size()];
    return dlist.toArray(a);
  }
}

class Employee {
  protected int empCode, deptCode;
  protected char grade;
  protected String name;
  protected double salary;

  public Employee(int ec, int dc, String n, char g) {
    this.empCode = ec;
    this.deptCode = dc;
    this.grade = g;
    this.name = n;
  }

  public int retCode() {
    return empCode;
  }

  public void setSalary(double d) {
    this.salary = d;
  }

  @Override
  public String toString() {
    return ("Employee code:" + empCode + ", Name:" + name + ", Grade:" + grade + ", Dept. code:" + deptCode
        + ", Salary:Rs." + salary);
  }
}

class EmployeeList {
  protected ArrayList<Employee> elist = new ArrayList<Employee>();

  protected boolean searchCode(int c) {
    for (Employee e : elist) {
      if (e.retCode() == c) {
        return true;
      }
    }
    return false;
  }

  public void addEmployee(DepartmentList dl) {
    JPanel panel = new JPanel();
    if (dl.isEmpty()) {
      JOptionPane.showMessageDialog(panel, "No Departments have been added", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    JFrame frame = new JFrame("Add Employee Details");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
    JPanel p1, p2, p3;
    JTextField t1, t2, t3, t4;
    JRadioButton rb1, rb2, rb3;
    JLabel l1, l2, l3, l4;

    p1 = new JPanel();
    l1 = new JLabel("Emp. Code:");
    l2 = new JLabel("Emp. Name:");
    t1 = new JTextField(10);
    t2 = new JTextField(10);
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);

    p2 = new JPanel();
    l3 = new JLabel("Dept. Code:");
    t3 = new JTextField(10);
    p2.add(l3);
    p2.add(t3);
    Department[] choices = dl.getList();
    final JComboBox<Department> cb = new JComboBox<Department>(choices);
    cb.setVisible(true);
    JLabel lcb = new JLabel("Dept. Name:(Choose)");
    p2.add(lcb);
    p2.add(cb);
    ActionListener cbActionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        Department d = (Department) cb.getSelectedItem();
        String code = Integer.toString(d.retCode());
        t3.setText(code);
        Random random = new Random();
        String empCode = Integer.toString(random.nextInt(100000));
        t1.setText(empCode);
        t3.setEnabled(false);
        t1.setEnabled(false);
      }
    };
    cb.addActionListener(cbActionListener);

    // p3 = new JPanel();
    rb1 = new JRadioButton("A");
    rb2 = new JRadioButton("B");
    rb3 = new JRadioButton("C");
    l4 = new JLabel("Salary:(in Rs.)");
    t4 = new JTextField(10);
    ButtonGroup g = new ButtonGroup();
    JLabel lrb = new JLabel("Grade:");
    g.add(rb1);
    g.add(rb2);
    g.add(rb3);
    p2.add(lrb);
    p2.add(rb1);
    p2.add(rb2);
    p2.add(rb3);
    p2.add(l4);
    p2.add(t4);

    p3 = new JPanel();
    JButton b1 = new JButton("SAVE");
    p3.add(b1);
    ActionListener bActionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        String s1 = t1.getText();
        String s2 = t2.getText();
        String s3 = t3.getText();
        String s4 = t4.getText();
        try {
          int ec = Integer.parseInt(s1);
          int dc = Integer.parseInt(s3);
          double salary = Double.parseDouble(s4);
          char grd;
          if (rb1.isSelected()) {
            grd = 'A';
          } else if (rb2.isSelected()) {
            grd = 'B';
          } else {
            grd = 'C';
          }
          boolean isPresent = searchCode(ec);
          if (isPresent) {
            JOptionPane.showMessageDialog(p1, "Cannot add multiple employees with same code!", "ERROR",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
          Employee e = new Employee(ec, dc, s2, grd);
          e.setSalary(salary);
          elist.add(e);
          JOptionPane.showMessageDialog(p1, "New Employee Successfully Added with Code: " + s1, "SUCCESS",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(p1, "Give proper values!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      }
    };
    b1.addActionListener(bActionListener);
    frame.getContentPane().add(p1, BorderLayout.NORTH);
    frame.getContentPane().add(p2, FlowLayout.CENTER);
    frame.getContentPane().add(p3, BorderLayout.SOUTH);
  }

  public void search(DepartmentList dl) {
    JPanel panel = new JPanel();
    if (dl.isEmpty()) {
      JOptionPane.showMessageDialog(panel, "No Departments have been added", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    JFrame frame = new JFrame("Search For an Employee");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
    JPanel p1, p2;
    JLabel l1;
    JTextField t1;

    p1 = new JPanel();
    l1 = new JLabel("Emp. Code to search:");
    t1 = new JTextField(10);
    p1.add(l1);
    p1.add(t1);

    p2 = new JPanel();
    JButton b1 = new JButton("SEARCH");
    p2.add(b1);
    ActionListener bActionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        try {
          String s1 = t1.getText();
          int code = Integer.parseInt(s1);
          for (Employee e : elist) {
            if (e.retCode() == code) {
              JOptionPane.showMessageDialog(p1, e.toString(), "EMPLOYEE FOUND", JOptionPane.INFORMATION_MESSAGE);
              return;
            }
          }
          JOptionPane.showMessageDialog(p1, "Employee with Code:" + code + ", not found!", "NOT FOUND",
              JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(p1, "Give proper Input!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      }
    };
    b1.addActionListener(bActionListener);

    frame.getContentPane().add(p1, BorderLayout.NORTH);
    frame.getContentPane().add(p2, BorderLayout.SOUTH);
  }
}

class q4 {
  public static void main(String[] args) {
    int choice;
    EmployeeList el = new EmployeeList();
    DepartmentList dl = new DepartmentList();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print(
          "1.Add an employee\n2.Search for an employee\n3.Add a department(cmdline)\n4.List all departments\n5.Exit\nEnter a choice:");
      choice = sc.nextInt();
      switch (choice) {
      case 1:
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            el.addEmployee(dl);
          }
        });
        break;
      case 2:
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            el.search(dl);
          }
        });
        break;
      case 3:
        dl.addDept();
        break;
      case 4:
        System.out.println("The following departments have been entered:");
        dl.displayAll();
        break;
      case 5:
        System.exit(0);
      }
    }
  }
}
