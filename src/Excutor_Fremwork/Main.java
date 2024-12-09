package Excutor_Fremwork;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {

        long starttime=System.currentTimeMillis();
//        Thread[] threads=new Thread[9];
        ExecutorService executor=Executors.newFixedThreadPool(9);
        for (int i=1;i<10;i++){

            int finalI = i;
//            threads[i-1]=new Thread

            executor.submit(
                    ()->{
                long ans=factor(finalI);
                System.out.println(ans);
                    });
//            threads[i-1].start();
        }

//        for (Thread t:threads){
//            try {
//                t.join();
//            }
//            catch (Exception e){
//                Thread.currentThread().interrupt();
//            }
//        }
        System.out.println("Total time: "+(System.currentTimeMillis()-starttime));
        executor.shutdown();
    }

    private  static long factor(int n){


        try {

            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        long ans=1;
        for (int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}
