package sample;

import java.util.concurrent.ConcurrentHashMap;

public class TestThreadConcurrentHashMap extends Thread {
    static ConcurrentHashMap<Integer, String> h = new ConcurrentHashMap<Integer, String>();

    @Override
    public void run() {
        try {
            System.out.println("Started sleep run");
            Thread.sleep(1000);
            System.out.println("Ended sleep run");
            h.put(103, "D");
        } catch (InterruptedException e) {
            System.out.println("Child Thread will add objects");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        h.put(100, "X");
        h.put(101, "Y");
        h.put(102, "Z");
        System.out.println("Initialized HashMap");
        TestThreadConcurrentHashMap t = new TestThreadConcurrentHashMap();
        t.start();
        System.out.println("Started 2nd Thread");
        for (Object o : h.entrySet()) {
            System.out.println("El: " + o);
            System.out.println("Started sleep For loop");
            Thread.sleep(1000);
            System.out.println("Ended sleep For loop");
        }
        System.out.println(h);
    }
}
