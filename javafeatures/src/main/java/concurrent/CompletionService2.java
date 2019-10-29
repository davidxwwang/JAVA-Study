package concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CompletionService2 {


    // 解耦 任务的提交和任务的完成
    static void testCompletionService(){

        // 执行任务的线程池
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);

        String result = "任务结束，返回的是我！！";
        // Future 描述了一项未来可能完成的任务
        // 任务也是有生命周期的
        Future<String> futureTask = completionService.submit(()->{
            System.out.print("我在运行！！！\n");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // 当futureTask被cancel掉后，会将运行的线程interupt，线程抛出InterruptedException异常
                e.printStackTrace();
            }
        }, result);

        // 取消任务，仅仅是把对应的thread的interupt标志位设置下
//        boolean couldCancel = futureTask.cancel(true);
//        System.out.print("任务可以被取消" + couldCancel);

        try {
            System.out.print("阻塞前?\n");

            // 当futureTask被cancel掉后，会抛出CancellationException异常
            String result3 = futureTask.get();

            System.out.print("阻塞后\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e){
            e.printStackTrace();
        }

    }

    public static void main (String[] args){
        testCompletionService();

    }
}
