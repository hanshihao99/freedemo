package minimart.sort;

/**
 * @Description: 插入排序
 * @Auther: hanshihao
 * @Date: 2023/05/20/17:31
 */
public class InsertSort {

    /**
     * 插入排序思路：首先认为第一个元素为已排序，将后序数据依次与已排序序列比较，如果小于已排序序列中的某个数据，将该数据插入即可
     *
     * 1、定义 与已排序序列比较的下标，首先for循环从 1开始，因为默认 0 是已排序
     * 2、将 已排序序列后的数据 逐个向前比较，找到位置插入
     */

    public static void main(String[] args) {
        int[] arr = {14, 4, 3, 7, 10};

        int current ; // current 为已排序后的数据，与已排序的数据进行比较
        for(int i = 1;i<arr.length ; i++){
            current = arr[i];
            int preindex = i -1;

            // 如果当前数据 小于 已排序序列中的数据，那么将 大的数据放入后边位置
            while(preindex >= 0 &&  current < arr[preindex]){
                // preindex 的数据替换到至后边位置，将当前位置空出来，以供比较的数据插入
                arr[preindex + 1] = arr[preindex];
                preindex --;
            }

            // 并且将小的数据，放到排序中找到的位置；
            // 因为循环退出的条件为 preindex >= 0 && current < arr[preindex] 说明当前数据找到插入的位置
            // 为什么是放入 preindex + 1 的位置，因为 while循环中，比较完后，preindex-- , 所以此时preindex+1，存放比较完成的数据
             arr[preindex + 1 ] = current;
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
