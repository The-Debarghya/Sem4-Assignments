import java.util.*;

class ScoreException extends Exception {
  String msg;
  int value;
  private static final long serialVersionUID = 42l;

  ScoreException(int v, String m) {
    this.msg = m;
    this.value = v;
  }

  public String toString() {
    return (msg + "Score is:" + value);
  }
}

class Student {
  private int score;
  private String name;
  private int roll;

  Student(int r, String n) {
    this.name = n;
    this.roll = r;
    this.score = 0;
  }

  void setScore(int s) throws ScoreException {
    if (s <= 100 && s >= 0) {
      this.score = s;
    } else if (s < 0 || s > 100) {
      throw new ScoreException(s, "Invalid score(out of range)");
    }
  }

  public void display() {
    System.out.println("Roll:" + this.roll + ", Name:" + this.name + ", Score:" + this.score);
  }
}

class q5 {
  public static void main(String[] args) {
    Student s1 = new Student(1, "Carl Johnson");
    s1.display();
    Student s2 = new Student(2, "Tommy Vercetti");
    s2.display();
    try {
      s1.setScore(76);
      s1.display();
      s2.setScore(98);
      s2.display();
      s1.setScore(-100);
      s2.setScore(1000);
    } catch (ScoreException se) {
      System.out.println("Exception Raised");
      System.out.println(se);
    } finally {
      s1.display();
      s2.display();
    }
  }
}
