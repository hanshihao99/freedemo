package cn.future.code.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/20/23:38
 */
public class CommonUtilsDemo {
    public static void main(String[] args) {
        //测试CommonUtils
        String result = CommonUtils.readFile("resource/news.txt");
        CommonUtils.printThreadLog(result);

        ExecutorService executor = Executors.newFixedThreadPool(5);
    }
}


