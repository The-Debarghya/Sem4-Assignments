package q3.BookList;

public class Book {
  protected int id;
  protected int slno;
  protected String title;
  boolean isAvailable;

  public Book(int i, int s, String t) {
    this.id = i;
    this.slno = s;
    this.title = t;
    this.isAvailable = true;
    System.out.println("Book added with ID:" + this.id + ", Serial:" + this.slno);
  }

  public Book(Book b) {
    this.id = b.id;
    this.slno = b.slno;
    this.title = b.title;
    this.isAvailable = b.isAvailable;
  }

  public int retID() {
    return this.id;
  }

  public int retSlNo() {
    return this.slno;
  }

  public String retTitle() {
    return this.title;
  }

  public boolean isAvailable() {
    return this.isAvailable;
  }

  public void changeAvailability() {
    this.isAvailable = !this.isAvailable;
  }

  @Override
  public String toString() {
    return ("ID:" + this.id + ", Sl No.:" + this.slno + ", Title:" + this.title + ", Availability:" + this.isAvailable);
  }
}
