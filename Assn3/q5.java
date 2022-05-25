import java.util.*;
import java.io.*;

class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  private int roll, score;
  private String name;

  Student(int r, String n, int s) {
    this.roll = r;
    this.score = s;
    this.name = n;
  }

  @Override
  public String toString() {
    return ("Roll:" + this.roll + ", Name:" + this.name + ", Score:" + this.score);
  }
}

class q5 {

  public static void main(String[] args) {

    Student s1 = new Student(1, "John", 30);
    Student s2 = new Student(2, "Rachel", 25);
    Student s3 = new Student(3, "Mike", 45);

    try {
      FileOutputStream f = new FileOutputStream(new File("Students.dat"));
      ObjectOutputStream o = new ObjectOutputStream(f);

      // Write objects to file
      o.writeObject(s1);
      o.writeObject(s2);
      o.writeObject(s3);

      o.close();
      f.close();

      FileInputStream fi = new FileInputStream(new File("Students.dat"));
      ObjectInputStream oi = new ObjectInputStream(fi);

      // Read objects
      ArrayList<Student> slist = new ArrayList<Student>();
      boolean eof = false;
      while (!eof) {
        try {
          Student s = (Student) oi.readObject();
          slist.add(s);
        } catch (EOFException e) {
          eof = true;
        }
      }
      for (Student s : slist) {
        System.out.println(s);
      }
      oi.close();
      fi.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("Error initializing stream");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

}
