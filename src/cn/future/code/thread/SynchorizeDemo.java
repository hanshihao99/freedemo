package cn.future.code.thread;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/21/20:21
 */
public class SynchorizeDemo {
    private static int counter = 0;

    public static void main(String[] args) {
        // 创建多个线程并同时对共享变量进行修改
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出结果
        System.out.println("Counter: " + counter);
    }
}
