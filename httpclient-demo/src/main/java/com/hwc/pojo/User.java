package com.hwc.pojo;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/8/27 16:54
 * @Created by huangwencai
 */
public class User {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
