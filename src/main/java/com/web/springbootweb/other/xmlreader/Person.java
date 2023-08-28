package com.web.springbootweb.other.xmlreader;

import com.web.springbootweb.other.proxylearn.Dog;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/28 11:59
 */
public class Person {

    private String name;

    private String sex;

    private Dog pat;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Dog getPat() {
        return pat;
    }

    public void setPat(Dog pat) {
        this.pat = pat;
    }
}
