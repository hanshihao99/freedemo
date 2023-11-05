package minimart.io.file;

import minimart.io.util.FIleIOUtil;

import java.io.IOException;
import java.io.Serializable;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/29/15:28
 */
public class FileIODemo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Demo demo = new Demo(1, 20);
        System.out.println(demo.num);
        FIleIOUtil.OutFileWrite("resource/io.txt",demo);
        Object o = FIleIOUtil.InFileRead("resource/io.txt");
        Demo dd = (Demo)o;
        System.out.println(dd);

    }
}

class Demo implements Serializable {
    int num ;
    int size ;

    public Demo(int num, int size) {
        this.num = num;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "num=" + num +
                ", size=" + size +
                '}';
    }
}