package minimart.io.util;

import java.io.*;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/29/15:28
 */
public class FIleIOUtil {

    public static Object InFileRead(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }

    public static void OutFileWrite(String path,Object object) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }
}
