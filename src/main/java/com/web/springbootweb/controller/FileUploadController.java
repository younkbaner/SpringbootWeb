package com.web.springbootweb.controller;

import com.web.springbootweb.eneity.FileUpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: ywz
 * @time: 2023/8/9 23:35
 */

@RestController
public class FileUploadController {


    @PostMapping("/fileUpload")
    public void fileUp(@RequestBody MultipartFile file , HttpServletRequest servletRequest, FileUpRequest request) throws IOException {
        System.out.println("文件上传请求:"+request.toString());

        if(file != null){
            System.out.println("处理上传的文件:"+file.getOriginalFilename());

            file.transferTo(new File("src/main/resources/temp/test.xlsx"));

        }

        System.out.println("处理完成");

    }
}
