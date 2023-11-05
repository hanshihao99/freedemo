package cn.future.code.futures;

import cn.future.code.utils.CommonUtils;

import java.util.concurrent.*;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/20/23:50
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long starttime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // step 1: 读取敏感词汇 => thread1
        Future<String[]> filterWordsFuture = executor.submit(() -> {
            String str = CommonUtils.readFile("resource/filter.txt");
            String[] filterWords = str.split(",");
//            CommonUtils.printThreadLog(str);
            return filterWords;
        });

        // step 2: 读取新闻稿 => thread2
        Future<String> newsFuture = executor.submit(() -> {
//            CommonUtils.printThreadLog("str");
            return CommonUtils.readFile("resource/news.txt");
        });

        // step 3: 替换操作 => thread3
        Future<String> replaceFuture = executor.submit(() -> {
            String[] words = filterWordsFuture.get();
            String news = newsFuture.get();
            for(String word : words){
                if(news.indexOf(word) >= 0){
                    news = news.replace(word,"**");
                }
            }
//            CommonUtils.printThreadLog(news);
            return news;
        });


        // step 4: 打印输出替换后的新闻稿 => main
        String filteredNews = replaceFuture.get();
        System.out.println("filteredNews :" + filteredNews);
        Long endtime = System.currentTimeMillis();
        Long re = endtime - starttime;
        System.out.println("耗时：" + re);


        // step 5: 关闭线程池
        executor.shutdown();

    }
}
