package Thread_lifecycle;

public class MyThread extends  Thread {

    @Override
    public void run(){
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread t1=new MyThread();  //THREAD CREATED STATE-NEW
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());//NOW STATE BECOME - RUNNABLE
        Thread.sleep(100);//HERE WE PAUSED THE MAIN THREAD FOR A WHILE
        System.out.println(t1.getState());
        t1.join();//WAIT TO COMPLETE T1 AND THEN MAIN WILL CONTINUE
        System.out.println(t1.getState());//NOW THE T1 HAD COMPLETE IN PRIVOUS LINE SO HERE STATE OF T1 BECOME TERMINATED


    }
}
