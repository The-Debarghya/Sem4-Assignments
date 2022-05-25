package q3.BookList;

import java.util.*;

public class BookList {
  private ArrayList<Book> blist = new ArrayList<Book>(20);

  public void addBook() throws Exception {
    int id, n;
    String t;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Title of Book:");
    t = sc.nextLine();
    System.out.print("No. of copies you want to register:");
    n = sc.nextInt();
    Random random = new Random();
    id = random.nextInt(100000);
    for (int i = 1; i <= n; i++) {
      Book b = new Book(id, i, t);
      if (blist.size() == 20) {
        throw new IndexOutOfBoundsException();
      }
      blist.add(b);
    }
  }

  public void displayAll() {
    System.out.println("The following books have been registered:");
    for (Book b : blist) {
      System.out.println(b);
    }
  }

  public int availableCopies(int id) {
    int ct = 0;
    for (Book b : blist) {
      if (b.isAvailable() && b.retID() == id) {
        ct++;
      } else {
        continue;
      }
    }
    return ct;
  }

  public int totalCopies(int id) {
    int ct = 0;
    for (Book b : blist) {
      if (b.retID() == id) {
        ct++;
      } else {
        continue;
      }
    }
    return ct;
  }

  public void searchBook(int id) {
    boolean flag = false;
    for (Book b : blist) {
      if (b.retID() == id) {
        flag = true;
        System.out.println("Book found");
        System.out.println(b);
      } else {
        continue;
      }
    }
    if (!flag) {
      System.out.println("Book not found!");
    }
  }

  public void addCopies(int id) {
    int ct = 0, n;
    String s = "";
    for (Book b : blist) {
      if (b.retID() == id) {
        s = b.retTitle();
        ct++;
      } else {
        continue;
      }
    }
    if(ct == 0){
    	System.out.println("The book with that ID doesn't exist");
	return;
    }	
    Scanner sc = new Scanner(System.in);
    System.out.print("How many copies you want to add:");
    n = sc.nextInt();
    if (n == 0) {
      return;
    }
    for (int i = ct + 1; i <= ct + n; i++) {
      Book b = new Book(id, i, s);
      blist.add(b);
    }
  }

  public int search(int id, int sl) {
    int index = 0;
    for (Book b : blist) {
      if (b.retID() == id && b.retSlNo() == sl) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public Book get(int index) {
    return blist.get(index);
  }
  public void set(int index, Book element){
    blist.set(index, element);
  }
}
