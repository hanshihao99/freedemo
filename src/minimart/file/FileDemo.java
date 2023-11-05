package minimart.file;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MultipartDataSource;

import java.awt.*;
import java.io.File;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/11/01/22:19
 */
public class FileDemo {

    public static void main(String[] args) {
        String path = "/upload/";
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }

        File file1 = new File(path + 1);
    }
}
