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
public class ThenApplyDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("mian 线程开始");

        CompletableFuture<String[]> filterFuture = CompletableFuture.supplyAsync(() -> {
//            CommonUtils.printThreadLog("读取filter 文件内容");
//            String content = CommonUtils.readFile("resource/filter.txt");
//            return content;
            return "尼玛, NB, tmd, MD";
        }).thenApply(content -> {
            CommonUtils.printThreadLog("处理filter文件内容");
            String[] split = content.split(",");
            return split;
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        String[] result = filterFuture.get();
        System.out.println(Arrays.toString(result));
        CommonUtils.printThreadLog("main 线程结束");

    }
}
