package leetcode;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/04/23/22:43
 * 出租车打表遇到4就跳过，表显示85，实际消费应该是多少
 */
public class JumpForBuss {

    public static void main(String[] args) {
        int num = 100;
        int i = new JumpForBuss().PayMoney(num);
        System.out.println(i);

    }

    public int PayMoney(int num){
        int pay = 0 , count = 0;
        for(int i = 0 ; i<Integer.MAX_VALUE ;i++){
            if(String.valueOf(i).contains("4")){
                pay++;
            }
            count++;
            if((count + pay) == num){
                break;
            }
        }
        return count;
    }
}
