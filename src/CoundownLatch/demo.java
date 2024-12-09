package CoundownLatch;


import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DependentService implements Callable<String>{

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public String call() throws Exception {

        try {
            System.out.println(Thread.currentThread().getName()+" Service Streted");
            Thread.sleep(2000);
        }
        finally {
            latch.countDown();
        }

        return  "Ok";
    }

}
public class demo {


    public static void main(String[] args) throws InterruptedException {

        int count=3;

        ExecutorService executorService= Executors.newFixedThreadPool(count);
        CountDownLatch latch=new CountDownLatch(count);

        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        System.out.println("Main");
        executorService.shutdown();

    }



}
