package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/15:25
 */
public class ThenComposeAsyncDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 使用 thenComposeAsync
        CompletableFuture<String[]> splitWords = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("read 任务");
            String words = CommonUtils.readFile("resource/filter.txt");
            return words;
        }).thenComposeAsync(con -> {
            CommonUtils.printThreadLog("thenComposeAsync 任务");
            return CompletableFuture.supplyAsync(()->{
                CommonUtils.printThreadLog("split 任务");
                return con.split(",");
            });
        }, executor);

        String[] words = splitWords.get();
        System.out.println(Arrays.toString(words));
        executor.shutdown();
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        //使用 thenCompose
//        CompletableFuture<String[]> splitWords = CompletableFuture.supplyAsync(() -> {
//            CommonUtils.printThreadLog("read 任务");
//            String words = CommonUtils.readFile("resource/filter.txt");
//            return words;
//        }).thenComposeAsync(con -> CompletableFuture.supplyAsync(()->{
//            CommonUtils.printThreadLog("split 任务");
//            CommonUtils.printThreadLog("split 任务结束");
//            return con.split(",");
//        }),executor);
//
//
//        String[] words = splitWords.get();
//        System.out.println(Arrays.toString(words));
//        executor.shutdown();
//    }
}
