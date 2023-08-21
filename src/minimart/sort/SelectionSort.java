package minimart.sort;

/**
 * @Description: 选择排序
 * @Auther: hanshihao
 * @Date: 2023/05/20/17:16
 */
public class SelectionSort {
    /**
     * 选择排序思路：
     * 1、首先每次遍历，判断首位数据与之后所有数据比较，找到最小或最大数据，记录下标
     * 2、将最小或者最大下标放至首位 , 接着判断第 i 位置及之后的数据
     * 3、循环完毕后即可
     */

    public static void main(String[] args) {

        int[] arr = {12, 24, 3, 121, 31, 41};

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] < arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
