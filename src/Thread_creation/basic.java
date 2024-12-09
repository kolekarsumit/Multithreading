package Thread_creation;

public class basic {


    public static void main(String[] args) {
        System.out.println("hello Thread_creation.word");

//using Extebd THread class
//        Thread_creation.word w=new Thread_creation.word();
//        w.start();


        //Using Runnable interaface
        word1 w=new word1();
        Thread t1=new Thread(w);
        t1.start();
        for (int i=0;i<10000;i++){
            System.out.println("hello");

        }
    }
}
