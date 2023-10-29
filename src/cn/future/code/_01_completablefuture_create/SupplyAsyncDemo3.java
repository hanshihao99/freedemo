package cn.future.code._01_completablefuture_create;

import cn.future.code.utils.CommonUtils;

import javax.security.auth.callback.Callback;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/21:09
 */
public class SupplyAsyncDemo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CommonUtils.printThreadLog("main 线程开始执行");

        CompletableFuture<String> newsFuture = CompletableFuture.supplyAsync(() -> {
            String content = CommonUtils.readFile("resource/news.txt");
            CommonUtils.printThreadLog(content);
            return content;
        }, executor);

        CommonUtils.printThreadLog("main 线程执行其他任务");
        String result = newsFuture.get();
        System.out.println("news : " + result);
        CommonUtils.printThreadLog("main 线程结束");

        executor.shutdown();

    }
}
