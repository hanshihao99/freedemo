package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/15:25
 */
public class ThenComposeDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 编排两个依赖关系的异步任务 thenCompose

        //使用 thenCompose
        CompletableFuture<String[]> splitWords = CompletableFuture.supplyAsync(() -> {
            String words = CommonUtils.readFile("resource/filter.txt");
            return words;
        }).thenCompose(con -> CompletableFuture.supplyAsync(()->{
            return con.split(",");
        }));


        String[] words = splitWords.get();
        System.out.println(Arrays.toString(words));
    }
}
