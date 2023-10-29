package cn.future.code._02_completablefuture_callback;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/23:44
 */
public class ThenAcceptAsyncDemo1 {
    public static void main(String[] args) {
        CommonUtils.printThreadLog("mian 线程开始");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("异步线程开始执行");
            String content = CommonUtils.readFile("resource/filter.txt");
            return content;
        }).thenApplyAsync(content ->{
            CommonUtils.printThreadLog("thenApplyAsync 处理filter文件");
            String[] splitWords = content.split(",");
            return splitWords;
        },executor).thenAcceptAsync(con ->{
            CommonUtils.printThreadLog("thenAcceptAsync 开始执行");
            System.out.println("con : " + Arrays.toString(con));
        },executor).thenRunAsync(() ->{
            CommonUtils.printThreadLog("thenRunAsync 开始执行");
            System.out.println("run 方法执行完毕 ");
        },executor);

        CommonUtils.printThreadLog("main 线程执行其他任务");
        // 如果不等待的话，main线程会直接执行完毕，导致异步线程还没输出结果，就已经被关闭了
        CommonUtils.sleepSecond(1);
        CommonUtils.printThreadLog("main 线程结束");
        executor.shutdown();

    }
}
