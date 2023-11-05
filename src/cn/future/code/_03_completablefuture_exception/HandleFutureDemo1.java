package cn.future.code._03_completablefuture_exception;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/20:28
 */
public class HandleFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> handleFuture = CompletableFuture.supplyAsync(() -> {
            int len = 1 / 0;
            return "result1";
        }).thenApply(cn -> {
            return cn + " result2";
        }).handle((result,ex) ->{
            if(ex != null){
                System.out.println("异常如下 ： " + ex.getMessage());
                return "UnKnown";
            }
            return result;
        });

        String result = handleFuture.get();
        CommonUtils.printThreadLog(result);
    }
}
