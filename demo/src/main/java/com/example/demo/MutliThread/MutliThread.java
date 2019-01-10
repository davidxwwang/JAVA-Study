package com.example.demo.MutliThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public  class MutliThread {
    public static void main(String[] args) {

        CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();
        // 1.初始化
        exec.init();

        ExecutorService pool = exec.getCustomThreadPoolExecutor();
        for(int i=1; i<100; i++) {
            System.out.println("提交第" + i + "个任务!");
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(" 这是任务开始工作的地方");
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" 这是任务结束工作的地方");
                    System.out.println(Thread.currentThread().getName() +  " running=====");
                }
            });
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) exec.getCustomThreadPoolExecutor();


         //2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了
         exec.destory();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
//

        int x =3;
        x-= 3;


    }


    private ServerSocket socket;

    private static final Executor exe = Executors.newFixedThreadPool(10);


    void xx(){
        try{
            socket = new ServerSocket(80);
            while (true){
                final Socket connect =socket.accept();
                Runnable task = new Runnable() {
                    @Override
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
