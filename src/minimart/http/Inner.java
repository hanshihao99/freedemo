package minimart.http;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/29/20:24
 */
public class Inner {

    String username ;
    String password ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
    }
}
