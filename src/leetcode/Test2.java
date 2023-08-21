package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/08/01/15:15
 */
public class Test2 {
    public static void main(String[] args) {

        String str = "hhelllllllohhh";
        HashMap<Character,Integer> res = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(res.containsKey(ch)){
                res.put(ch,res.get(ch)+1);
                continue;
            }
            res.put(ch,1);
        }

        char charstr = 0;
        int maxCount = 0;
        for(Map.Entry<Character,Integer> entry : res.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            if(count > maxCount){
                charstr = ch;
                maxCount = count;
            }

        }
        System.out.println(charstr + " " +  maxCount);
    }
}
