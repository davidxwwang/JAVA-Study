package MutliThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.*;

public  class MutliThread {

    public static void main(String[] args) {

        CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();
        // 1.初始化
        exec.init();

        ExecutorService pool = exec.getCustomThreadPoolExecutor();
        for(int i=1; i<101; i++) {
            MyTask task = new MyTask();
            task.setTaskId("第" + i + "号任务");

            pool.execute(task);
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) exec.getCustomThreadPoolExecutor();
        System.out.print("\n统计下数据" + new Date());

        // todo 为什么这个方法被block了,这里要好好的理解下 为什么获得是68/67，我非常的不能理解
        long finished = threadPoolExecutor.getCompletedTaskCount();
        System.out.print("\n共完成了" + finished + "个任务 " + new Date());
         //2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了，结束了
         exec.destory();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finished2 = threadPoolExecutor.getCompletedTaskCount();

        while (true);

//
//        ExecutorService pool1=Executors.newSingleThreadExecutor();
//
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        MyThread t3 = new MyThread();
//        MyThread t4 = new MyThread();
//        MyThread t5 = new MyThread();
//
//        pool1.execute(t1);
//        pool1.execute(t2);
//        pool1.execute(t3);
//        pool1.execute(t4);
//        pool1.execute(t5);
//
//        if (!pool1.isShutdown()){
//            pool1.shutdown();
//        }
//
//        ExecutorService pool2=Executors.newFixedThreadPool(2);
//
//        pool2.execute(t1);
//        pool2.execute(t2);
//        pool2.execute(t3);
//        pool2.execute(t4);
//        pool2.execute(t5);
//        if (!pool2.isShutdown()){
//            pool2.shutdown();
//        }
//

//        ExecutorService  service = new ThreadPoolExecutor(1,
//                2,
//                60L,
//                TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>(),  //ArrayBlockingQueue
//                new CustomThreadFactory(),
//                new CustomRejectedExecutionHandler()));


    }


    private ServerSocket socket;

    private static final Executor exe = Executors.newFixedThreadPool(10);


    void xx(){
        try{
            socket = new ServerSocket(80);
            while (true){
                final Socket connect =socket.accept();
                Runnable task = new Runnable() {
                    public void run() {
                        handlerequest(connect);
                    }
                };
                new Thread(task).start();
                exe.execute(task);
            }

        }catch (IOException ex){

        }
    }

    void handlerequest(Socket socket){

    }




}
