package com.web.springbootweb.other.threadlocallearn;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.web.springbootweb.eneity.FileUpRequest;
import org.apache.tomcat.util.http.fileupload.FileUpload;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/13 15:34
 */
public class ThreadTest {

    static final ThreadLocal<String> S_THREAD_LOCAL = new ThreadLocal<>();

    static final ThreadLocal<FileUpRequest> S_FILE_UPLOAD = new ThreadLocal<>();



    public static void main(String[] args) {
        FileUpRequest fileUpRequest = new FileUpRequest();


        S_THREAD_LOCAL.set("你好");
        S_THREAD_LOCAL.set("hello");
        S_FILE_UPLOAD.set(fileUpRequest);
        System.out.println("主方法中的ThreadLocal值:"+ S_THREAD_LOCAL.get());
        System.out.println("主方法中的uploadRequest:"+S_FILE_UPLOAD.get().toString());
        method();

        System.out.println("调用method方法之后的ThreadLocal值:"+ S_THREAD_LOCAL.get());


    }


    public static void method(){

        String s = S_THREAD_LOCAL.get();
        System.out.println("获取到的变量是:"+s);
        FileUpRequest fileUpRequest = S_FILE_UPLOAD.get();
        System.out.println("method中fileUpRequest:"+fileUpRequest.toString());

        S_THREAD_LOCAL.remove();
        S_FILE_UPLOAD.remove();
    }
}
