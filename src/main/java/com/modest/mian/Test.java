package com.modest.mian;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * description
 *
 * @author modest
 * @date 2019/09/18
 */
public class Test {
    public static void main(String[] args) {
        Class c = Student.class;


        //构造方法
        try {
            //获取对应的public修饰的构造方法
            Constructor constructor = c.getConstructor();
            constructor.newInstance();

            //获取对应的private修饰的构造方法对象
            Constructor cons = c.getDeclaredConstructor(String.class, String.class, int.class);

            //private的构造方法不能直接调用newInstance创建对象，需要暴力反射
            //设置取消权限检查(暴力反射)
            cons.setAccessible(false);
            Student student = (Student)cons.newInstance("jin","男",10);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }
}



