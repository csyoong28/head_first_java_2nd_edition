package soonyoong.headfirst.java;

public class java12cTestSyncTest {
    public static void main (String[] args) {
        java12cTestSync job = new java12cTestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
      }
 }

