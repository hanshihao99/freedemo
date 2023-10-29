package cn.future.code._01_completablefuture_create;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/20:42
 */
// 需求：开启异步任务读取news.txt ，文件中的新闻稿在主线程内打印输出
public class SupplyAsyncDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main 线程开始");

        CompletableFuture<String> newsFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                CommonUtils.printThreadLog("异步线程开始执行");
                String result = CommonUtils.readFile("resource/news.txt");
                return result;
            }
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
//        String result = newsFuture.get();
//        newsFuture.join();
//        System.out.println("news : " + result);
        CommonUtils.printThreadLog("main 线程结束");

    }
}
