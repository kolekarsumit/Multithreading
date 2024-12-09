package Locks;

public class BankAccount {

    private  int balance=100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" Proceding with withdraws");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" Completing Withdraw . Remaing balance "+balance);

        }
        else {
            System.out.println(Thread.currentThread().getName()+" Insufficient Balence");
        }
    }
}
