import java.util.*;
import q3.BookList.*;
import q3.MemberList.*;
import q3.Transaction.*;

class q4{
    public static void main(String[] args){
        BookList bl = new BookList();
        MemberList ml = new MemberList();
        TransactionList t = new TransactionList();
        int choice;
        while(true){
            Scanner sc = new Scanner(System.in);
            int i;
            System.out.print("1.Add a book\n2.Search for a book\n3.Add copies of a book\n4.Display all registered books\n5.Total copies & available copies of a book\n6.Add member\n7.Search for a member\n8.Display all members\n9.Edit details of a member\n10.Issue a book\n11.Return a book\n12.Exit\nEnter a choice:");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    try{
                        bl.addBook();    
                    }catch(Exception e){
                        System.out.println("Some error occurred while adding the book!");
                    }break;
                case 2:
                    System.out.print("Enter ID:");
                    i = sc.nextInt();
                    bl.searchBook(i);
                    break;
                case 3:
                    System.out.print("Enter ID:");
                    i = sc.nextInt();
                    bl.addCopies(i);
                    break;
                case 4:
                    bl.displayAll();
                    break;
                case 5:
                    System.out.print("Enter ID:");
                    i = sc.nextInt();
                    System.out.println("Total number of copies of the book:"+i+" registered:"+bl.totalCopies(i)+", available copies:"+bl.availableCopies(i));
                    break;
                case 6:
                    try{
                        ml.addMember();
                    }catch(Exception e){
                        System.out.println("Some error occurred while adding the member!");
                    }break;
                case 7:
                    System.out.print("Enter memberID:");
                    i = sc.nextInt();
                    ml.searchMember(i);
                    break;
                case 8:
                    ml.displayMembers();
                    break;
                case 9:
                    System.out.print("Enter memberID:");
                    i = sc.nextInt();
                    ml.editDetails(i);
                    break;
                case 10:
                    t.issueBook(bl, ml);
                    break;
                case 11:
                    t.returnBook(bl, ml);
                    break;
                case 12: System.exit(0);
            }
        }
    }
}
