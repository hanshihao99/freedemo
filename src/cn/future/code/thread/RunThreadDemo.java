package cn.future.code.thread;

import cn.future.code.utils.CommonUtils;

import javax.print.DocFlavor;
import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/17:33
 */
public class RunThreadDemo {

    private static int num = 0;

    public static void main(String[] args) {


        CommonUtils.printThreadLog("main启动");
        for(int i = 0;i<100000;i++){
            num++;
        }
        //启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<100000;i++){
                    num++;
                }
                CommonUtils.printThreadLog("线程启动");
//                CommonUtils.sleepMillis(1000);
                CommonUtils.printThreadLog("线程结束");
            }
        }).start();

        System.out.println("main线程在开启异步线程之前执行其他任务");

        //开启一个异步任务
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<100000;i++){
                    num++;
                }
                CommonUtils.printThreadLog("线程2启动");
//                CommonUtils.sleepMillis(1000);
                CommonUtils.printThreadLog("线程2结束");
            }
        });

        System.out.println("main线程在开启异步线程之后执行其他任务");

        future.join();

        CommonUtils.printThreadLog("main线程等待异步任务执行完毕后结束");

        System.out.println(num);
    }
}
