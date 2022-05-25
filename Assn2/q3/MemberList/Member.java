package q3.MemberList;

public class Member {
  protected int id;
  protected String name;
  protected String dob;
  static final int limit = 5;
  public int issued;

  public Member(int i, String n, String d) {
    this.id = i;
    this.name = n;
    this.dob = d;
    this.issued = 0;
  }

  public Member(Member m) {
    this.id = m.id;
    this.name = m.name;
    this.dob = m.dob;
    this.issued = m.issued;
  }

  public int retID() {
    return id;
  }

  public String retName() {
    return name;
  }

  public String retdob() {
    return dob;
  }

  public int possibleIssues() {
    return limit - issued;
  }

  public void display() {
    System.out.println("ID:" + this.id + ", Name:" + this.name + ", Date of Birth:" + this.dob + ", No. of issues:"
        + this.issued + "(Total possible no. of issues:5)");
  }
}
