package ch05;

import org.junit.Test;

import java.io.Serializable;

public class Test1 implements Serializable {

    private static final long serialVersionUID = 7162955568868357363L;
    private static Test2 test2;
//    private Test2 test; // error: 序列化问题
    private int value;

    public Test1(Test2 test2, int value) {
        this.test2 = test2;
        this.value = value;
    }

    public static void main(String[] args){

        Test2 test2 = new Test2("test2");
        Test1 test1 = new Test1(test2, 1);
    }
}
