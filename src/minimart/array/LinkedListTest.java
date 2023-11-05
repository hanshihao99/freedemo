package minimart.array;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/06/11/21:08
 */
public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1,2,3,4};
        int length = arr.length;

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(4);
        list.addFirst(0);

        for(int s : list){
            System.out.println(s);
        }

    }
}
