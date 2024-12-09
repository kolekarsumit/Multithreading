package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranExample {

    private  final Lock lock=new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer Method");
            innermethod();
        }
        finally {
            lock.unlock();
        }
    }
    public void innermethod(){
        lock.lock();
        try {
            System.out.println("Inner Method");

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentranExample ex=new ReentranExample();
        ex.outerMethod();
    }
}
