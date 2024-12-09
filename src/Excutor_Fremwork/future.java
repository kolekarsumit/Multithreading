package Excutor_Fremwork;

import java.util.concurrent.*;

public class future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Callable c=()->12;

        Runnable r=()-> System.out.println(" ");
         executorService.submit(() -> c);

//        System.out.println(future.get());
        executorService.shutdown();
    }
}
