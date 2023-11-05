package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/19:46
 */
public class AnyOfDemo {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepMillis(1);
            return "future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepMillis(3);
            return "future2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.sleepMillis(6);
            return "future3";
        });
        List<CompletableFuture<String>> listFuture = Arrays.asList(future1, future2, future3);
        CompletableFuture[] arrayFuture = listFuture.toArray(new CompletableFuture[0]);

        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(arrayFuture);

        Object result = anyFuture.join();
        System.out.println("result : " + result);
    }
}
