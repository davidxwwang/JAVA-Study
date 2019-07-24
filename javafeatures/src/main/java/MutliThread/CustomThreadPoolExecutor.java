package MutliThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// http://www.cnblogs.com/zedosu/p/6665306.html

public class CustomThreadPoolExecutor {


    private ThreadPoolExecutor pool = null;


    /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----10
     * maximumPoolSize 最大线程池大小----30
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(5)====5容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 							即当提交第26个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 						          任务会交给RejectedExecutionHandler来处理
     */

    /**
     * 方法中建立一个核心线程数为10个，缓冲队列容量为5个线程任务，
     * 执行时会先睡眠3秒，保证提交10任务时，线程数目被占用完，
     * 再提交5个任务时，会把5个任务加到阻塞队列
     * 再提交20个任务时，线程池新增20个线程，这时到了30（maximumPoolSize），自此以后提交的任务都被拒绝了
     * 会交给CustomRejectedExecutionHandler 异常处理类来处理。
     *
     *
     */
    public void init() {
        /**
         * maximumPoolSize被设置成了30，说明最多只能生成30个线程
         * 如果每个任务执行的时间都够久，那么从第36个任务开始，就会被拒绝（30个最大线程 + 5个queue的容量）
         *      当然，先生成10个线程，再入5个ArrayBlockingQueue，再生成20个线程
         */
        pool = new ThreadPoolExecutor(
                10,
                30,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }


    public void destory() {
        if(pool != null) {
            pool.shutdownNow();
        }
    }


    public ExecutorService getCustomThreadPoolExecutor() {
        return this.pool;
    }

    private class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = "第** " + count.addAndGet(1) + " **号线程";
            System.out.println("新生成了第 " + count.get() + "个 线程，名称为：" + threadName);
            t.setName(threadName);
            return t;
        }
    }


    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        private AtomicInteger rejectCount = new AtomicInteger(0);

        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("有" + rejectCount.addAndGet(1) + "个任务被拒绝");
            // 记录异常
            // 报警处理等

            try {
                // 核心改造点，由blockingqueue的offer改成put阻塞方法
                BlockingQueue<Runnable> queue = executor.getQueue();

                // 一直会阻塞queue，直到有空间插入为止
                executor.getQueue().put(r);
                System.out.print("l am here !\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}

