package Java;

import java.lang.reflect.Method;

// Thread implementation

class A implements Runnable {
    @Override
    public void run() {
        System.out.println("A run");
    }
}

class B extends A {
    @Override
    public void run() {
        System.out.println("B run");
    }
}

class Counter {
    int count;
    public synchronized void increment() {  // synchronized is used to avoid race condition
        count++;
    }
}

public class ThreadsUsage {
    public static void main(String[] args) throws InterruptedException, SecurityException, ClassNotFoundException {

        // extends and implements
        Runnable tempA = new A();
        Thread t1 = new Thread(tempA);
        t1.start();

        // inner class / within class implementation with lambda expression
        Runnable tempB = () -> System.out.println("Inner run 1");
        Thread t2 = new Thread(tempB);
        t2.start();

        // same as above but elaborated
        Runnable tempC = new Runnable() {
            public void run() {
                System.out.println("Inner run 2");
            }
        };
        Thread t3 = new Thread(tempC);
        t3.start();

        // Avoiding thread race condition
        Counter counter = new Counter();
        Runnable tempD = () -> {
            for (int i=0; i<1000; i++) {
                counter.increment();
            }
        };
        Runnable tempE = () -> {
            for (int i=0; i<1000; i++) {
                counter.increment();
            }
        };
        Thread t4 = new Thread(tempD);
        Thread t5 = new Thread(tempE);
        t4.start();
        t5.start();
        t4.join();      // critical, this makes the code to wait for the threads 
                        // to execute before executing next line
        t5.join();
        System.out.println(counter.count);
        Object obj = new Object();
        Method[] methods = Class.forName("Java.Demo").getMethods();
        // System.out.println(t4.getClass().toString());

        for (Method method : methods) {
            System.out.println(method.toString());
        }
    }
}