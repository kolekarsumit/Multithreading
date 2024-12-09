package Lambda;

public class user {


    public static void main(String[] args) {

//        Runnable runnable=()-> {System.out.println("Hello");};
//        Thread t1=new Thread(runnable);
//        t1.start();



        //this also an lambda expression
//        Thread t1=new Thread(()-> System.out.println("hello"));


        Thread t1=new Thread(()->{
                for (int i=0;i<10;i++){
                    System.out.println("Number : "+i);
                }
        });
        t1.start();
    }
}
