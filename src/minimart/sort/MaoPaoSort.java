package minimart.sort;

/**
 * @Description: 冒泡排序
 * @Auther: hanshihao
 * @Date: 2023/05/20/16:53
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = {14, 4, 3, 7, 10};

        for (int i = 0; i < arr.length; i++) {
            /**
             * 为什么 j < arr.length - 1 - i;
             * 1、首先 内层for循环是做交换，交换的下标为 j 与 j+1 ，所以 j < arr.length
             * 2、外层for 循环是控制，每交换完一次后，则排除掉末尾数据，进行剩余 arr.length - i 次遍历
             * 3、所以 j 的判断条件为 j < arr.length - 1 - i
             */
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int n : arr) {
            System.out.println(n);
        }
    }
}
