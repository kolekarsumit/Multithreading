package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount_Lock {

    private  int balance=100;

    private final Lock lock=new ReentrantLock();


    public  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);

        try{

            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance>=amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Proceding with withdraws");
                        balance -= amount;
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " Completing Withdraw . Remaing balance " + balance);
                    }
                    catch(Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else {
                    System.out.println(Thread.currentThread().getName()+" Insufficient Balence");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" Could not acquire the lock, will try later");

            }
        }
        catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
