import java.util.*;

class IncreaseDecrease {
  int a = 10;

  void increase(int n) {// method not synchronized
    for (int i = 1; i <= 5; i++) {
      a = a + n;
      System.out.println(a);
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        System.out.println("Interruption occurred!");
      }
    }
  }

  void decrease(int n) {
    for (int i = 1; i <= 5; i++) {
      a = a - n;
      System.out.println(a);
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        System.out.println("Interruption occurred!");
      }
    }
  }
}

class MyThread1 extends Thread {
  IncreaseDecrease t;
  int n;

  MyThread1(IncreaseDecrease t, int n) {
    this.t = t;
    this.n = n;
  }

  public void run() {
    System.out.print("Thread 1 running!! ");
    t.increase(this.n);
  }
}

class MyThread2 extends Thread {
  IncreaseDecrease t;
  int n;

  MyThread2(IncreaseDecrease t, int n) {
    this.t = t;
    this.n = n;
  }

  public void run() {
    System.out.print("Thread 2 running!! ");
    t.decrease(this.n);
  }
}

class q1 {
  public static void main(String args[]) {
    int n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number:");
    n = sc.nextInt();
    IncreaseDecrease obj = new IncreaseDecrease();// only one object
    MyThread1 t1 = new MyThread1(obj, n);
    MyThread2 t2 = new MyThread2(obj, 11);
    t1.start();
    t2.start();
    sc.close();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      System.out.println("Main thread was Interrupted!");
    }
    System.out.println("The final value of the variable:" + obj.a);
  }
}
