package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/19:27
 */
public class ReadFileTest {

    public static CompletableFuture<String> readFileFuture(String path){
        return CompletableFuture.supplyAsync(()->{
            String content = CommonUtils.readFile(path);
            return content;
        });
    }

    public static void main(String[] args) {
//        CompletableFuture<String> stringCompletableFuture = readFileFuture("resource/news.txt");
//        String result = stringCompletableFuture.join();
//        System.out.println(result);

        String word = "hello world hello world";
        String word2 = "hello world hello world";
        List<String> list = new ArrayList<>(2);
        list.add(word2);
        list.add(word);
        long hello = list.stream().filter(con -> con.contains("hello")).count();
        System.out.println(hello);
    }
}
