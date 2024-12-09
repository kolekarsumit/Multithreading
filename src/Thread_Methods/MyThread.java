package Thread_Methods;

public class MyThread extends  Thread {


    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){




       for(int i=0;i<5;i++){
           String a="";
           for(int j=0;j<10000;j++){
               a+="A";
           }


           System.out.println(Thread.currentThread().getName()+" - Priority "+Thread.currentThread().getPriority()+" count : "+i);
           try{

               Thread.sleep(100);
           }catch(Exception e){
               System.out.println(e);
           }
       }
    }

    public static void main(String[] args) {
        MyThread t1=new MyThread("Low Priority");
        MyThread t2=new MyThread("Medium Prioriy");
        MyThread t3=new MyThread("High Priority");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
