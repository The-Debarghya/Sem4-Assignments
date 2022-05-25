//Write a program that accepts number of command line parameters and displays
//the parameters and count of such parameters.
class qTwo {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("No arguments supplied!");
      System.exit(1);
    }
    System.out.println("The command-line arguments are:\n");
    for (int x = 0; x < args.length; x++)
      System.out.println("args[" + x + "]: " + args[x]);
    System.out.println("Total number of command-line arguments:" + args.length);
  }
}
