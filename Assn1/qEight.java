/*
 * Add constructors in the Student class of earlier problem so that objects can
 * be created with i) roll only, ii) roll and name only, iii) roll, name and
 * score, iv) no value. Also include a copy constructor. Check whether
 * constructors are working or not. Verify, copy constructor results into deep
 * copy or not.
 */
class Student {
  String name;
  int rollNo;
  int score;

  // constructor - 1
  Student() {
    this.rollNo = 0;
    this.name = "dummy";
    this.score = 0;
  }

  // constructor - 2
  Student(int rollNo) {
    this.rollNo = rollNo;
    this.name = "dummy";
    this.score = 0;
  }

  // constructor - 3
  Student(int rollNo, String name) {
    this.rollNo = rollNo;
    this.name = name;
    this.score = 0;
  }

  // constructor - 4
  Student(int rollNo, String name, int score) {
    this.rollNo = rollNo;
    this.name = name;
    this.score = score;
  }

  // copy constructor
  Student(Student s) {
    this.name = s.name;
    this.rollNo = s.rollNo;
    this.score = s.score;
  }

  void display() {
    System.out.println("Name: " + this.name);
    System.out.println("Roll No: " + this.rollNo);
    System.out.println("Score: " + this.score);
  }

}

class qEight {
  public static void main(String[] args) {
    // using only roll no.
    Student s1 = new Student(15);
    System.out.println("s1:");
    s1.display();

    // using roll no. and name
    Student s2 = new Student(16, "Jesse");
    System.out.println("s2:");
    s2.display();

    // using roll no., name and score
    Student s3 = new Student(15, "Heisenberg", 77);
    System.out.println("s3:");
    s3.display();

    // using no value
    Student s4 = new Student();
    System.out.println("s4:");
    s4.display();

    // using copy constructor (deep copy)
    Student s5 = new Student(s3);
    System.out.println("Before:");
    s5.display();

    s3.name = "Debarghya Maitra";
    System.out.println("After change:");
    s5.display();

    // using simple assignment operator = (shallow copy)
    Student s6 = s3;
    System.out.println("Before:");
    s6.display();

    s3.name = "Hank Schrader";
    System.out.println("After change:");
    s6.display();
  }
}
