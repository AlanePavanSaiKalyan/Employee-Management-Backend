package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.service.S3StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:5173")
public class S3FileUploadController {
    private final S3StorageService s3StorageService;
    public S3FileUploadController(S3StorageService s3StorageService){
        this.s3StorageService = s3StorageService;
    }


    @PutMapping("/upload")
    public ResponseEntity<Map<String,String>> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("error","Invalid or no file selected"));
        }
        else{
            String key = s3StorageService.uploadFile(multipartFile);
            return ResponseEntity.ok(Map.of("message","File uploaded Successfully","key",key));
        }
    }
}
