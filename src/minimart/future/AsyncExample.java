package minimart.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/06/06/22:53
 */
public class AsyncExample {
    public static void main(String[] args) {
        // 创建一个CompletableFuture对象
        CompletableFuture<String> future = calculateAsync();

        // 注册回调函数
        future.thenAccept(result -> System.out.println("计算结果: " + result));

        // 执行其他任务
        System.out.println("正在执行其他任务...");

//        // 等待异步方法执行完成
//        try {
//            TimeUnit.SECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        System.out.println("主程序执行完成");
    }

    public static CompletableFuture<String> calculateAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 模拟长时间计算
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 返回计算结果
            return "完成";
        });

        return future;
    }
}
