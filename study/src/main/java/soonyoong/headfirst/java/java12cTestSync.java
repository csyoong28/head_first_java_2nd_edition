package soonyoong.headfirst.java;

public class java12cTestSync implements Runnable {
    private int balance;
    public void run() {
       for(int i = 0; i < 50; i++) {
        increment();
        System.out.println("balance is " + balance);       
      }
    }
    public void increment() {
       int i = balance;
       balance = i + 1;
    }
 }

