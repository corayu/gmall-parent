package com.cora.gmall.product.controller;

import com.cora.gmall.common.result.Result;
import com.cora.gmall.product.test.FdfsTest;
import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class FileUploadController {
    @RequestMapping("fileUpload")
    public Result<String> fileUpload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        String imgUrl = "http://192.168.200.128:80";
        //读取配置
        String path = FileUploadController.class.getResource("traker.conf").getPath();

        //创建tracker连接
        ClientGlobal.init(path);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();

        //获取storage连接
        StorageClient storageClient = new StorageClient(connection, null);

        //通过storage上传文件
        String orignalFileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(orignalFileName);
        String[] jpgs = storageClient.upload_file(file.getBytes(), extension, null);
        for (String jpg : jpgs) {
            imgUrl = imgUrl+"/"+jpg;
            System.out.println(jpg);
        }
        return Result.ok(imgUrl);
    }
}
