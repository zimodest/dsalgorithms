package com.modest.mian;

import java.io.IOException;
import java.io.InputStream;

/**
 * description
 *
 * @author modest
 * @date 2019/09/18
 */
public class Main {

    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("idea.txt");

        byte[] bytes = new byte[256];
//        try {
//            inputStream.read(bytes);
//            System.out.println(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
