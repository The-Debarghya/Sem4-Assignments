/*Design and implement Student class with roll, name and score as attributes.
It will have methods to set attributes (attribute values passed as arguments), display the attributes,
copy (that copies the content of invoking object to another object passed as argument). 
Verify that methods are working properly.*/

class Student {
  int roll;
  String name;
  int score;

  public Student(int r, String n, int s) { // normal constructor
    this.roll = r;
    this.name = n;
    this.score = s;
  }

  Student(Student s) { // copy constructor
    System.out.println("Copy constructor called");
    roll = s.roll;
    name = s.name;
    score = s.score;
  }

  void display() { // method to display the attributes
    System.out.println("Roll:" + roll + " Name:" + name + " Score:" + score);
  }

}

class qSeven {
  public static void main(String[] args) { // driver func
    Student s1 = new Student(1, "Carl Johnson", 76);
    s1.display();
    Student s2 = new Student(2, "Tommy Vercetti", 56);
    s2.display();
    Student s3 = new Student(s1); // copy constructor is called
    s3.display();
    Student s4 = s2; // the reference is copied in this case
    s4.display();
  }
}
