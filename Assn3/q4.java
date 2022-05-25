import java.io.*;
import java.util.*;

class ReaderWriter {

  public void reader(String file) {
    try {
      File f = new File(file);
      Scanner sc = new Scanner(f);
      while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("File was not found");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writer(String file, String name) {
    try {
      FileWriter fw = new FileWriter(file, true);
      fw.write(name);
      fw.write("\n");
      fw.close();
    } catch (FileNotFoundException e) {
      System.out.println("File couldn't be created");
    } catch (IOException e) {
      System.out.println("Error initializing stream.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class q4 {
  public static void main(String[] args) {
    int choice;
    String s;
    Scanner sc = new Scanner(System.in);
    ReaderWriter obj = new ReaderWriter();
    while (true) {
      System.out.print("1.Add a name\n2.Print all added names\n3.Exit\nEnter your choice:");
      choice = sc.nextInt();
      switch (choice) {
      case 1:
        System.out.print("Enter the name:");
        s = sc.next();
        obj.writer("names.txt", s);
        break;
      case 2:
        obj.reader("names.txt");
        break;
      case 3:
        System.exit(0);
      }
    }
  }
}
