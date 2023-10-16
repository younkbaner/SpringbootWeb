package com.web.springbootweb.controller;

import com.web.springbootweb.eneity.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: ywz
 * @time: 2023/10/6 15:46
 */
@RestController
public class ReturnTest {

    @ResponseBody
    @GetMapping("/getPerson")
    public Person getPerson(@PathVariable("age") int age){

        Person person = new Person();
        person.setAge(18);
        person.setName("wenzhong");
        return person;
    }
}
