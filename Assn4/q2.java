import java.util.concurrent.*;
import java.util.*;

class IncreaseDecrease {
  int a = 10;

  void increase(int n) {// method not synchronized
    for (int i = 1; i <= 5; i++) {
      a = a + n;
      System.out.println(a);
      try {
        Thread.sleep(100);
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
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("Interruption occurred!");
      }
    }
  }
}

class MyThread1 extends Thread {
  IncreaseDecrease t;
  int n;
  Semaphore sem;

  MyThread1(IncreaseDecrease t, int n, Semaphore s) {
    this.t = t;
    this.n = n;
    this.sem = s;
  }

  public void run() {
    try {
      sem.acquire();
      System.out.print("Thread 1 running!! ");
      t.increase(this.n);
      sem.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class MyThread2 extends Thread {
  IncreaseDecrease t;
  int n;
  Semaphore sem;

  MyThread2(IncreaseDecrease t, int n, Semaphore s) {
    this.t = t;
    this.n = n;
    this.sem = s;
  }

  public void run() {
    try {
      sem.acquire();
      System.out.print("Thread 2 running!! ");
      t.decrease(this.n);
      sem.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class q2 {
  public static void main(String args[]) {
    int n;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number:");
    n = sc.nextInt();
    IncreaseDecrease obj = new IncreaseDecrease();// only one object
    Semaphore sem = new Semaphore(1);
    MyThread1 t1 = new MyThread1(obj, n, sem);
    MyThread2 t2 = new MyThread2(obj, 11, sem);

    try {
      t2.start();
      t1.start();
      t1.join();
      t2.join();
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Main thread was Interrupted!");
    }
    System.out.println("The final value of the variable:" + obj.a);
    sc.close();
  }
}
