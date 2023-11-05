package cn.future.code._02_completablefuture_callback;

import cn.future.code.utils.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/23:44
 */
public class ThenAcceptDemo1 {

    public static void main(String[] args) {
        CommonUtils.printThreadLog("mian 线程开始");

//        CompletableFuture.supplyAsync(() -> {
//            CommonUtils.printThreadLog("异步线程开始执行");
//            String content = CommonUtils.readFile("resource/filter.txt");
//            return content;
//        }).thenApply(content ->{
//            String[] splitWords = content.split(",");
//            return splitWords;
//        }).thenAccept(con ->{
//            CommonUtils.printThreadLog("thenAccept 开始执行");
//            System.out.println("con : " + Arrays.toString(con));
//        });

        // 直接将获取到的filter文件输出
        CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("异步线程开始执行");
            String content = CommonUtils.readFile("resource/filter.txt");
            return content;
        }).thenAccept(con ->{
            CommonUtils.printThreadLog("thenAccept 开始执行");
            System.out.println("con : " + con);
        });

        CommonUtils.printThreadLog("main 线程执行其他任务");
        // 如果不等待的话，main线程会直接执行完毕，导致异步线程还没输出结果，就已经被关闭了
        CommonUtils.sleepSecond(1);
        CommonUtils.printThreadLog("main 线程结束");

    }
}
