package q3.MemberList;

import java.util.*;

public class MemberList {
  protected ArrayList<Member> mlist = new ArrayList<Member>(10);
  protected static int i = 0;

  public void addMember() throws Exception {
    int id;
    String n, dob;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your name:");
    n = sc.nextLine();
    System.out.print("Enter date of birth(dd/mm/yyyy):");
    dob = sc.next();
    i++;
    id = i;
    Member m = new Member(id, n, dob);
    if (mlist.size() == 10) {
      throw new IndexOutOfBoundsException();
    }
    mlist.add(m);
    System.out.println("Member registered with ID:"+id);
  }

  public void displayMembers() {
    System.out.println("The following members have been registered:");
    for (Member m : mlist) {
      m.display();
    }
  }

  public void searchMember(int id) {
    boolean flag = false;
    for (Member m : mlist) {
      if (m.retID() == id) {
        flag = true;
        System.out.println("Member found");
        m.display();
      } else {
        continue;
      }
    }
    if (!flag) {
      System.out.println("Member not found!");
    }
  }

  public void editDetails(int id) {
    boolean flag = false;
    int index = 0;
    String n, d;
    for (Member m : mlist) {
      if (m.retID() == id) {
        flag = true;
        break;
      }
      index++;
    }
    if (!flag) {
      System.out.println("ID not found!");
      return;
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Name:");
    n = sc.nextLine();
    System.out.print("Enter corrected date of birth(dd/mm/yyyy):");
    d = sc.next();
    Member me = new Member(id, n, d);
    mlist.set(index, me);
    System.out.println("Member with ID:" + id + " has been updated");
  }

  public int makeIssue(int id) {
    boolean flag = false;
    int index = 0;
    for (Member m : mlist) {
      if (m.retID() == id) {
	flag = true;
        if (m.possibleIssues() != 0) {
          m.issued = m.issued + 1;
          mlist.set(index, m);
          return 1;
        } else {
          System.out.println("No more issues possible!");
          return 0;
        }
      } else {
        index++;
      }
    }
    if (!flag) {
      System.out.println("Member not found!");
      return 0;
    }
    return 1;
  }

  public int revokeIssue(int id) {
    boolean flag = false;
    int index = 0;
    for (Member m : mlist) {
      if (m.retID() == id) {
	flag = true;
        if (m.possibleIssues() > 0) {
          m.issued = m.issued - 1;
          mlist.set(index, m);
          return 1;
        } else {
          System.out.println("Some unexpected Error occurred");
          return 0;
        }
      } else {
        index++;
      }
    }
    if (!flag) {
      System.out.println("Member not found!");
      return 0;
    }
    return 1;
  }

  public int search(int id) {
    int index = 0;
    for (Member m : mlist) {
      if (m.retID() == id) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public Member get(int index) {
    return mlist.get(index);
  }
  public void set(int index, Member element){
    mlist.set(index, element);
  }
}
