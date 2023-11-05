package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/16:43
 */
public class ThenCombineDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main 开始");

        // 读取敏感词内容
        CompletableFuture<String[]> filterWordsFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("read filter start");
            String filters = CommonUtils.readFile("resource/filter.txt");
            String[] filterWords = filters.split(",");
            return filterWords;
        });

        // 读取新闻稿件
        CompletableFuture<String> newsFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("read news start");
            String news = CommonUtils.readFile("resource/news.txt");
            return news;
        });

        CompletableFuture<String> combineFuture = newsFuture.thenCombine(filterWordsFuture, (news, words) -> {
            CommonUtils.printThreadLog("replace start");
            for (String word : words) {
                if (news.indexOf(word) >= 0) {
                    news = news.replace(word, "**");
                }
            }
            return news;
        });
        CommonUtils.printThreadLog("main 执行其他任务");

        String filterContent = combineFuture.get();
        System.out.println(filterContent);
        CommonUtils.printThreadLog("main 结束");

    }
}
