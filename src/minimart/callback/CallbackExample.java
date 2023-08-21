package minimart.callback;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/06/06/22:59
 */
public class CallbackExample {
    public static void main(String[] args) {
        System.out.println("主线程开始执行");

        // 调用带回调函数的方法
        performOperation(5, result -> {
            // 回调函数的实现
            System.out.println("操作完成，结果为: " + result);
        });

        // 执行其他任务
        System.out.println("主线程执行其他任务");

        System.out.println("主线程执行完成");
    }

    public static void performOperation(int value, Callback callback) {
        // 模拟耗时操作
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 完成操作后调用回调函数，并传递结果
        int result = value * 2;
        callback.onComplete(result);
    }
}

// 回调接口
interface Callback {
    void onComplete(int result);
}