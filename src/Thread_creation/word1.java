package Thread_creation;

public class word1 implements  Runnable{

    @Override
    public void run(){
        for (int i=0;i<10000;i++){
            System.out.println("Thread_creation.word 1");
        }
    }
}
