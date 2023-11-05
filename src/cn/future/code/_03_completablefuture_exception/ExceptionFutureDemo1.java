package cn.future.code._03_completablefuture_exception;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/20:28
 */
public class ExceptionFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            int len = 1 / 0;
            return "result1";
        }).thenApply(cn -> {
            return cn + " result2";
        }).exceptionally(ex -> {
            CommonUtils.printThreadLog("异常 : " + ex.getMessage());
            return "UnKnown";
        });
    }
}
