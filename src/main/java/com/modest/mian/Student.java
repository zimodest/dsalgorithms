package com.modest.mian;

/**
 * description
 *
 * @author modest
 * @date 2019/09/19
 */
public class Student {

    private String name;

    public String gender;

    private int age;

    public Student() {

    }
    private Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void sleep() {
        System.out.println("sleep");
    }

    public void eat() {
        System.out.println("eat");
    }
}
