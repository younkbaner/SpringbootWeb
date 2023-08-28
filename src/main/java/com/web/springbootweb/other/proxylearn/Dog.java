package com.web.springbootweb.other.proxylearn;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 10:33
 */
public class Dog implements AnnimalInterface {


    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println("我是一只小狗,我会看家");
    }
}
