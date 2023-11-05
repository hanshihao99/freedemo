package minimart.http;

import javax.xml.ws.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/29/19:28
 */
public class HttpUtil {
        public static String gretRequest(Inner inner) {

            String responseBody = null;
            try {
                // 设置请求的 URL
                URL url = new URL("http://192.168.2.105:8080/users/login");

                // 创建 HttpURLConnection 对象
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 设置请求方法为 POST
                connection.setRequestMethod("POST");

                // 设置请求头
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Cookie", "JSESSIONID=C3B02959D5CF8A68EAD64DF8F50E7907");

                // 开启输出流，以便发送请求体数据
                connection.setDoOutput(true);

                // 构建请求体数据
                String requestBody = inner.toString();

                // 发送请求体数据
                try (OutputStream outputStream = connection.getOutputStream()) {
                    byte[] requestBodyBytes = requestBody.getBytes("UTF-8");
                    outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
                }

                // 获取响应信息
                int responseCode = connection.getResponseCode();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                responseBody = response.toString();
                // 输出响应结果
                System.out.println("Response Code: " + responseCode);
                System.out.println("Response Body: " + responseBody);


                // 关闭连接
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println("url 调用结束");

            return responseBody;
        }


    public static void main(String[] args) {

        String responseBody = null;
        try {
            // 设置请求的 URL
            URL url = new URL("http://localhost:8080/users/login");

            // 创建 HttpURLConnection 对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为 POST
            connection.setRequestMethod("POST");

            // 设置请求头
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Cookie", "JSESSIONID=C3B02959D5CF8A68EAD64DF8F50E7907");

            // 开启输出流，以便发送请求体数据
            connection.setDoOutput(true);

            // 构建请求体数据
            Inner inner = new Inner();
            inner.setPassword("123456");
            inner.setUsername("jerry");
            String requestBody = inner.toString();

            // 设置请求体数据为 JSON 格式，并发送请求体数据
            connection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] requestBodyBytes = requestBody.getBytes("UTF-8");
                outputStream.write(requestBodyBytes, 0, requestBodyBytes.length);
            }

            // 获取响应信息
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            responseBody = response.toString();
            // 输出响应结果
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + responseBody);


            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("url 调用结束");

    }
    }