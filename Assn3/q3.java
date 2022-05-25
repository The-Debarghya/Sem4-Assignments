import java.io.*;
import java.util.*;

class q3 {
  public static void main(String[] args) {
    String filename;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the file/folder name:");
    filename = sc.nextLine();
    try {
      File f = new File(filename);
      System.out.println("The entered path exists");
      if (f.isFile()) {
        System.out.println(filename + " is a File");
        if (f.canRead()) {
          System.out.println("File has read permissions");
        } else {
          System.out.println("File doesn't have read permissions");
        }
        if (f.canWrite()) {
          System.out.println("File has write permissions");
        } else {
          System.out.println("File doesn't have write permissions");
        }
      } else {
        System.out.println(filename + " is a Directory");
        System.out.println("The files/folders in the directory:");
        String[] contents = f.list();
        for (int i = 0; i < contents.length; i++) {
          System.out.println(contents[i]);
        }
      }
    } catch (Exception e) {
      System.out.println("File/Folder doesn't exist");
    }
    sc.close();
  }
}
