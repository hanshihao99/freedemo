package cn.future.code._01_completablefuture_create;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/20:53
 */
public class SupplyAsyncDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("mian 线程开始");

        CompletableFuture<String> newsFuture = CompletableFuture.supplyAsync(() -> {
            String content = CommonUtils.readFile("resource/news.txt");
            return content;
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        String result = newsFuture.get();
        System.out.println("news : " + result);
        CommonUtils.printThreadLog("main 线程结束");

    }
}
