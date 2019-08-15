package corcurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CompletionService2 {


    // 解耦 任务的提交和任务的完成
    static void testCompletionService(){

        // 执行任务的线程池
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);

        String result = "第卅五个";
        // Future 描述了一项任务，任务也是有生命周期的
        Future<String> futureTask = completionService.submit(()->{
            System.out.print("我在运行！！！\n");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                // 当futureTask被cancel掉后，会将运行的线程interupt，线程抛出InterruptedException异常
                e.printStackTrace();
            }
        }, result);

        futureTask.cancel(true);


        try {

          //  Future<String> finished = completionService.take();
          //  String result2 = finished.get();

            System.out.print("阻塞前?\n");

            // 当futureTask被cancel掉后，会抛出CancellationException异常
            String result3 = futureTask.get();

            System.out.print("阻塞后\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main (String[] args){
        testCompletionService();

    }
}
