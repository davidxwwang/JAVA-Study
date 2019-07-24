package MutliThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.function.Supplier;

public class MyTask implements Runnable {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String taskId;

    // 任务完成花费的时间
    private String costTime;


    @Override
    public void run(){


        Long begin = System.currentTimeMillis();

        String threadName =  Thread.currentThread().getName();
        System.out.println(taskId +  "在线程<<<" +  threadName + ">>>开始运行了" + "运行时间：" + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();

        Supplier<String> time  = () -> {return (begin - end) + "ms";};
        costTime = time.get();

        System.out.println(taskId +  "在线程<<<" +  threadName + ">>>运行，花费了" + costTime + " ||现在任务结束了" );
    }



    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }
}
