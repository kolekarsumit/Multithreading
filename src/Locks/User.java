package Locks;

public class User {

    public static void main(String[] args) {


        BankAccount_Lock bankAccount = new BankAccount_Lock();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }

}
