package Synchronization;

public class Counter {

    int count;

    public synchronized void increase(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
