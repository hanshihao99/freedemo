package leetcode;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/07/14/23:50
 */
public class DemoInt {

    public static void main(String[] args) {
        int[] arr = new int[]{40,30,3,5};
        String[] ss = new String[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            ss[i] = arr[i] + "";
        }
        Arrays.sort(ss,(a,b)->{
            String ab = a + b; String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuffer sb = new StringBuffer();
        for(String s : ss) sb.append(s);
        int len = sb.length();
        int k =0;
        while(k < len - 1 && sb.charAt(k) == '0') k++;
        System.out.println(sb.substring(k));

    }
}
