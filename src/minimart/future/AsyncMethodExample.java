package minimart.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/06/06/22:46
 */
public class AsyncMethodExample {
    public static void main(String[] args) {
        System.out.println("主线程开始执行");

        // 调用异步方法
        calculateAsync();

        // 执行其他任务
        System.out.println("主线程执行其他任务");

        // 等待异步方法执行完成
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完成");
    }

    public static void calculateAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // 模拟耗时操作
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 异步操作完成后的处理
            System.out.println("异步方法执行完成");
        });

        // 注册异常处理
        future.exceptionally(ex -> {
            System.out.println("异步方法执行出错: " + ex.getMessage());
            return null;
        });
    }
}
