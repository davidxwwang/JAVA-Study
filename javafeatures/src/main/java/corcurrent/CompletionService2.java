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
        Future<String> futureTask = completionService.submit(()->{
            System.out.print("我在运行！！！\n");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, result);




        try {

          //  Future<String> finished = completionService.take();
          //  String result2 = finished.get();

            System.out.print("并没有阻塞后?\n");
            String result3 = futureTask.get();

            System.out.print("并没有阻塞后\n");
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
