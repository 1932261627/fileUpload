package com.example.fileupload.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author : ZH
 * @date : 2021/6/8
 */
@RestController
@RequestMapping("/file")
public class FileUpload {
    @PostMapping()
    public void fileUpload(@RequestParam("fileUpload")MultipartFile xlsxFile)  {
        if(xlsxFile==null){
            return ;
        }

        if(!xlsxFile.isEmpty()){
            System.out.println(xlsxFile.getName());
            System.out.println(xlsxFile.getSize());
            System.out.println(xlsxFile.getOriginalFilename());
        }

        //考虑生成的文件名
        String fileName="C:\\"+xlsxFile.getOriginalFilename();

        File file=new File(fileName);
        if(!file.exists()){

            try {
                xlsxFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //long start = System.currentTimeMillis();
            //try(OutputStream outputStream=new FileOutputStream(file)){
            //    byte[] fileBytes=xlsxFile.getBytes();
            //    outputStream.write(fileBytes);
            //
            //}catch (IOException e){
            //    System.out.println(e.getMessage());
            //}
            //long end = System.currentTimeMillis();
            //System.out.println("时间为：" + (end - start));

        }

    }

}
