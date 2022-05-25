package q3.Transaction;

import java.util.*;
import q3.BookList.*;
import q3.MemberList.*;

class Transaction {
  protected int bookID, memID, slno;
  public boolean retrn;

  public Transaction(int bid, int mid, int s) {
    this.bookID = bid;
    this.memID = mid;
    this.slno = s;
    this.retrn = false;
  }

  public int retBookID() {
    return bookID;
  }

  public int retMemID() {
    return memID;
  }

  public int retSlNo() {
    return slno;
  }
}

public class TransactionList {
  protected ArrayList<Transaction> tlist = new ArrayList<Transaction>();

  public void issueBook(BookList bl, MemberList ml) {
    int mid, bid, sl;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter member ID:");
    mid = sc.nextInt();
    System.out.print("Enter book ID:");
    bid = sc.nextInt();
    System.out.print("Enter Book Serial:");
    sl = sc.nextInt();
    int idx1 = bl.search(bid, sl);
    if (idx1 < 0) {
      System.out.println("Book with that ID and Sl. No. not found!");
      return;
    }
    Book b = new Book(bl.get(idx1));
    if(!b.isAvailable()){
      System.out.println("Book is not available at this moment!");
      return;
    }
    int idx2 = ml.search(mid);
    if (idx2 < 0) {
      System.out.println("Member with that ID is not registered!");
      return;
    }
    //Member m = new Member(ml.get(idx2));
    if(ml.makeIssue(mid) == 0){
      return;
    }
    b.changeAvailability();
    bl.set(idx1, b);
    Transaction t = new Transaction(bid, mid, sl);
    tlist.add(t);
    System.out.println("Book with ID:"+t.bookID+", Serial:"+t.slno+" is issued to Member:"+t.memID);
  }
  public void returnBook(BookList bl, MemberList ml){
    int mid, bid, sl, idx;
    boolean flag=false;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter book ID:");
    bid = sc.nextInt();
    System.out.print("Enter book serial:");
    sl = sc.nextInt();
    System.out.print("Enter member ID:");
    mid = sc.nextInt();
    for(Transaction t : tlist){
      if(t.retBookID() == bid && t.retSlNo() == sl && t.retMemID() == mid){
        flag=true;
        if(!t.retrn){
          t.retrn = !t.retrn;
          idx = bl.search(bid, sl);
          Book b = new Book(bl.get(idx));
          b.changeAvailability();
          bl.set(idx, b);
          if(ml.revokeIssue(mid) == 0){
            return;
          }
          System.out.println("The book was successfully returned!");
          return;
        }else{
          System.out.println("The book was already returned!");
          return;
        }
      }else{
        continue;
      }
    }
    if(!flag){
      System.out.println("Transaction details didn't match with any!");
      return;
    }
  }
}
