package cn.future.code._02_completablefuture_callback;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/22:21
 */
public class ThenApplyDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("mian 线程开始");

        CompletableFuture<String> filterFuture = CompletableFuture.supplyAsync(() -> {
            String content = CommonUtils.readFile("resource/filter.txt");
            return content;
        });

        CompletableFuture<String[]> resultFuture = filterFuture.thenApply(content -> {
            String[] split = content.split(",");
            return split;
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        System.out.println("news : " + Arrays.toString(resultFuture.get()));
        CommonUtils.printThreadLog("main 线程结束");

    }

}
