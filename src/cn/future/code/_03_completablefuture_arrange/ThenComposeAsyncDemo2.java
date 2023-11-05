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
public class ThenComposeAsyncDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //使用 thenCompose
        CompletableFuture<String> readFile = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("read 任务");
            String words = CommonUtils.readFile("resource/filter.txt");
            return words;
        });
        CompletableFuture<String[]> future = readFile.thenComposeAsync(con -> CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("split 任务");
            return con.split(",");
        }),executor);


        String[] words = future.get();
        System.out.println(Arrays.toString(words));
        executor.shutdown();
    }
}
