/*Each Instructor has name and phone number. One can view instructor information and set the information.
Textbook has a title, author name and publisher. One can set the data for a textbook and view the same.
Each course has a course name, instructor and text book.
One can set the course data and view the same.  Design and implement the classes .*/
class Course {
  String courseName;
  Instructor ins;
  Textbook tb;

  public class Instructor {
    String name;
    long phno;

    public Instructor(String n, long p) { // constructor
      this.name = n;
      this.phno = p;
    }

    void setData(String n, long p) { // sets the attributes of instructor instance
      this.name = n;
      this.phno = p;
    }

    void display() {
      System.out.println("Instructor name:" + this.name + ", phone:" + this.phno);
    }
  }

  public class Textbook {
    String title, author, publisher;

    public Textbook(String t, String a, String p) { // constructor
      this.title = t;
      this.author = a;
      this.publisher = p;
    }

    void setData(String t, String a, String p) { // sets all attributes for textbook instance
      this.title = t;
      this.author = a;
      this.publisher = p;
    }

    void display() {
      System.out.println("Book title:" + this.title + ", Author:" + this.author + ", Publisher:" + this.publisher);
    }
  }

  public Course(String c, String ti, String a, String p, String n, long ph) { // constructor for course class
    this.courseName = c;
    Textbook t = new Textbook(ti, a, p);
    this.tb = t;
    Instructor i = new Instructor(n, ph);
    this.ins = i;
  }

  void display() { // prints all the attributes
    System.out.println("Course Description:");
    System.out.println("Course Name:" + this.courseName + ", ");
    System.out.println("Text book Description:");
    this.tb.display();
    System.out.println("Instructor:");
    this.ins.display();
  }
}

class qEleven {
  public static void main(String[] args) {
    Course c1 = new Course("C Programming", "The C language", "Dennis Ritchie", "xyz", "Abc Def", 565648864);
    c1.display();
    Course c2 = new Course("Advanced OOP", "Mastering Golang", "M. Tsoukalos", "stuv", "Fgh Ijkl", 796767555);
    c2.display();
    Course c3 = new Course("Computer Organization", "Computer Organization & architecture", "W. Stallings", "abcds",
        "Mnop Q Rst", 556656565);
    c3.display();
  }
}
