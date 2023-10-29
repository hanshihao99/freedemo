package cn.future.code._01_completablefuture_create;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/20:28
 */
// 使用异步任务读取news.txt 的新闻稿，并打印输出
public class RunAsyncDemo3 {

    public static void main(String[] args) {
        CommonUtils.printThreadLog("main start");

        CompletableFuture.runAsync(()->{
            CommonUtils.printThreadLog("异步任务开始执行");
            String result = CommonUtils.readFile("resource/news.txt");
            CommonUtils.printThreadLog(result);
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        CommonUtils.sleepMillis(2000);
    }
}
