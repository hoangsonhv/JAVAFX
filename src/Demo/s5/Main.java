package Demo.s5;

import javax.imageio.IIOException;
import java.io.*;

public class Main {
    public static void main(String [] args){
        try {
            //write file
            FileOutputStream fos = new FileOutputStream("data.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("abc\n");
            dos.writeBytes("def\n");
            dos.writeBytes("ghk");
            //read file
            FileInputStream fis = new FileInputStream("data.txt");
            DataInputStream dis = new DataInputStream(fis);
            String txt = "";
            for(;txt!=null;){
                System.out.println(txt);
                txt = dis.readLine();
            }
        }catch (FileNotFoundException f){
            System.out.println("File Not Found");
        }catch (IOException io){
            System.out.println("File Error");
        }
    }
}
