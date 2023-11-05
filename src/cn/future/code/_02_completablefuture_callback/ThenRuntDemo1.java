package cn.future.code._02_completablefuture_callback;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/23:53
 */
public class ThenRuntDemo1 {
    public static void main(String[] args) {
        CommonUtils.printThreadLog("mian 线程开始");

        // 直接将获取到的filter文件输出
        CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("异步线程开始执行");
            String content = CommonUtils.readFile("resource/filter.txt");
            return content;
        }).thenRun(()->{
           CommonUtils.printThreadLog("异步线程已经执行完毕");
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        // 如果不等待的话，main线程会直接执行完毕，导致异步线程还没输出结果，就已经被关闭了
        CommonUtils.sleepSecond(1);
        CommonUtils.printThreadLog("main 线程结束");

    }
}
