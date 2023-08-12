package com.web.springbootweb.eneity;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/9 23:37
 */


public class FileUpRequest {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FileUpRequest{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
