package cn.future.code._01_completablefuture_create;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/18:08
 */
public class RunAsyncDemo1 {
    public static void main(String[] args) {

        CommonUtils.printThreadLog("main 线程启动");

        // CompletableFuture 异步任务开始
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepMillis(3000);
                CommonUtils.printThreadLog("读取文件结束");
            }
        });

        CommonUtils.printThreadLog("main 继续执行任务");
        CommonUtils.sleepMillis(1000);
        CommonUtils.printThreadLog("main 线程结束");
    }
}
