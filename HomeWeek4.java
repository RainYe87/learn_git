package com.week4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeWeek4 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //定义Callable，具体的线程处理在call()里进行
        Callable<String> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                String result = "Hello World";
                //返回result
                return result;
            }
        };
        //定义FutureTask,持有Callable 引用
        FutureTask<String> futureTask = new FutureTask(callable);
        //开启线程
        new Thread(futureTask).start();

        try {
            //获取结果
            String result = futureTask.get();
            //确保拿到result 并输出
            System.out.println("异步结果为："+result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
        System.exit(0);
    }


}
