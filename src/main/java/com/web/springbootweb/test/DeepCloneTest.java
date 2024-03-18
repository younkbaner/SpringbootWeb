package com.web.springbootweb.test;

/**
 * @description:
 * @author: ywz
 * @time: 2024/3/17 22:11
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 此代码演示深拷贝和浅拷贝的区别
 * 浅拷贝只拷贝对象本身，如果对象内部有引用类型则不拷贝，也就是说原对象和拷贝对象其中的引用类型是同一个
 * 深拷贝不仅拷贝对象本身，对象内部的引用类型会同样的拷贝一份，完成之后，拷贝对象内的引用类型和原对象内的引用类型是两个不同的对象。
 */
public class DeepCloneTest {

    public static void main(String[] args) {

        //演示深拷贝
        //List<String> hobbies = new ArrayList<>();
        //hobbies.add("Reading");
        //hobbies.add("Cooking");
        //
        //Person person1 = new Person("Alice", hobbies);
        //
        //try {
        //    Person person2 = (Person) person1.clone();
        //    System.out.println("Original Person: " + person1);
        //    System.out.println("Cloned Person: " + person2);
        //
        //    List<String> hobbies1 = person1.getHobbies();
        //
        //    hobbies1.add("newAdd");
        //
        //    //此时往 person1的 hobbies 中新添加了一个字符串，
        //    //如果此时打印出来的两个 hobbies 不相同，说明 hobbies 是两份独立的，即是深拷贝
        //    System.out.println("Original Person: " + person1);
        //    System.out.println("Cloned Person: " + person2);
        //
        //
        //} catch (CloneNotSupportedException e) {
        //    e.printStackTrace();
        //}


        //演示浅拷贝
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Cooking");
        PersonOther personOther = new PersonOther("Alice", hobbies);

        try {
            PersonOther personOther2 = (PersonOther) personOther.clone();
            System.out.println("Original Person: " + personOther);
            System.out.println("Cloned Person: " + personOther2);

            if (personOther == personOther2){
                System.out.println("personOther == personOther2,说明二者指向同一个对象，拷贝时仅仅拷贝了对象的引用");
            }

            // 修改原始对象的hobbies列表
            personOther.getHobbies().add("Gardening");

            //如果此时原对象personOther和拷贝对象personOther2被修改后打印的内容是一样的，说明内部引用是一样的，也就是浅拷贝
            System.out.println("Original Person after modification: " + personOther);
            System.out.println("Cloned Person after modification: " + personOther2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}


/**
 * 深拷贝代码示例
 */
@Data
class Person implements Cloneable,Comparable<Person> {
    private String name;
    private List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = new ArrayList<>(hobbies);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        clonedPerson.hobbies = new ArrayList<>(this.hobbies);
        return clonedPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }



    @Override
    public int compareTo(Person o) {
        if (this.name.length()>o.name.length()){
            return -1;
        }
        if (this.name.length()<o.name.length()){
            return 1;
        }

        return 0;
    }
}


/**
 * 浅拷贝代码示例
 */
@Data
class PersonOther implements Cloneable, Comparator<PersonOther> {
    private String name;
    private List<String> hobbies;

    public PersonOther(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    @Override
    public int compare(PersonOther o1, PersonOther o2) {
        if (o1.name.length()>o2.name.length()){
            return 1;
        }
        if (o1.name.length()>o2.name.length()){
            return -1;
        }
        return 0;
    }
}
