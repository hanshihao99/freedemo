package cn.future.code.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/20/23:17
 */
public class CommonUtils {

    //读取指定路径的文件
    public static String readFile(String pathToFile){
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(pathToFile));
            return new String(bytes, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

    //休眠指定的毫秒数
    public static void sleepMillis(long millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //休眠指定的秒数
    public static void sleepSecond(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //打印出书带有线程信息的日志
    public static void printThreadLog(String message){
        // 时间戳 ｜ 线程id ｜ 线程名 ｜ 日志信息
        String result = new StringJoiner("|").add(String.valueOf(System.currentTimeMillis()))
                .add(String.format("%2d",Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(message).toString();
        System.out.println(result);
    }
}
