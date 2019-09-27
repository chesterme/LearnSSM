package ch05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static void main(String[] args){

        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Test2 test2 = new Test2("test2");
            Test1 test1 = new Test1(test2, 1);
            oos.writeObject(test1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
