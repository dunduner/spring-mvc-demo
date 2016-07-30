package com.spring.mvc.demo.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            log.debug("file is name:{]", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("c:/",System.currentTimeMillis()+file.getOriginalFilename()));
        }

        return "hello";
    }


}
