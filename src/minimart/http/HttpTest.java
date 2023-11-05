package minimart.http;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/29/20:27
 */
public class HttpTest {

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.setPassword("123456");
        inner.setUsername("jerry");
        String s = HttpUtil.gretRequest(inner);
        System.out.println(s);
    }
}
