package cn.future.code._03_completablefuture_arrange;

import cn.future.code.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/22/18:56
 */
public class AllOfDemo {
    
    public static CompletableFuture<String> readFile(String path){
        return CompletableFuture.supplyAsync(()->{
            String result = CommonUtils.readFile(path);
            return result;
        });
    }

    public static void main(String[] args) {
        //使用 AllOf 合并future

        // 1、创建list集合存储文件名
        List<String> listFile = Arrays.asList("resource/news.txt", "resource/news1.txt", "resource/news2.txt");

        // 2、根据文件名调用readFile 创建多个 CompletableFuture，并存入list集合中
        List<CompletableFuture<String>> listFuture = listFile.stream().map(filename -> {
            return readFile(filename);
        }).collect(Collectors.toList());

        // 3、将list 转成数组以供 allOf调用
        int len = listFuture.size();
        CompletableFuture[] listFutureArray = listFuture.toArray(new CompletableFuture[len]);

        // 4、调用allOf 方法合并多个future任务
        CompletableFuture<Void> allOffFuture = CompletableFuture.allOf(listFutureArray);

        // 5、当多个异步任务都完成后，使用回调操作文件结果，统计符合条件的个数
        CompletableFuture<Long> completableFuture = allOffFuture.thenApply(con -> {
            return listFuture.stream()
                    .map(future -> future.join())
                    .filter(content -> content.contains("CompletableFuture"))
                    .count();
        });

        // 6、获取结果
        Long count = completableFuture.join();
        System.out.println("count = " + count);

    }
}
