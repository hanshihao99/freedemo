package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/15:25
 */
public class ThenComposeDemo1 {
    public static CompletableFuture<String> readFileFuture(String filePath){
        return CompletableFuture.supplyAsync(()->{
            String result = CommonUtils.readFile(filePath);
            return result;
        });
    }

    public static CompletableFuture<String[]> splitFuture(String context){
        return CompletableFuture.supplyAsync(()->{
            String[] split = context.split(",");
            return split;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 编排两个依赖关系的异步任务 thenCompose

        //使用 thenApply()
//        CompletableFuture<CompletableFuture<String[]>> splitWords = readFileFuture("resource/filter.txt").thenApply(con -> {
//            return splitFuture(con);
//        });
//        CompletableFuture<String[]> future = splitWords.get();
//        String[] words = future.get();
//        System.out.println(Arrays.toString(words));

        //使用 thenCompose
        CompletableFuture<String[]> splitWords = readFileFuture("resource/filter.txt").thenCompose(con -> {
            return splitFuture(con);
        });
        String[] words = splitWords.get();
        System.out.println(Arrays.toString(words));
    }
}
