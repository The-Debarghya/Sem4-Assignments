import java.util.*;

class q7 {

  public static void main(String[] args) {
    String line;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a sentence:");
    line = sc.nextLine();
    int count = line.length() - line.replace("a", "").length();
    System.out.println("[*] Number of occurrences of 'a':" + count);
    String findStr = "and";
    int lastIndex = 0;
    int ct = 0;
    if(line.matches(".*\\band\\b.*")){
        System.out.println("True");
    }else System.out.println("False");
    while (lastIndex != -1) {
      lastIndex = line.indexOf(findStr, lastIndex);
      if (lastIndex != -1) {
        ct++;
        lastIndex += findStr.length();
      }
    }
    System.out.println("[*] Number of occurrences of 'and' in the whole string is:" + ct);
    // int index = line.indexOf("The");
    if (line.startsWith("The")) {
      System.out.println("[*] The string starts with 'The'");
    } else {
      System.out.println("[*] The string doesn't start with 'The'");
    }
    char[] chrs = new char[line.length()];
    line.getChars(0, line.length(), chrs, 0);
    // char[] chrs = line.toCharArray();
    System.out.println("[*] The characters in the string:");
    for (char c : chrs) {
      System.out.print(c + " ");
    }
    System.out.printf("\n");
    System.out.println("[*] The tokens present in the whole string are:");
    String[] tokens = line.split("@|\\.|\\ ");
    for (int i = 0; i < tokens.length; i++) {
      System.out.println(tokens[i]);
    }
    sc.close();
  }
}
