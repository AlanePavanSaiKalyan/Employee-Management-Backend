package com.pavan.EmployeeCrud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3StorageService {
    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public S3StorageService(S3Client s3Client){
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile file) throws IOException{
        String fileName = file.getOriginalFilename();
        String safeFileName = fileName==null?"file":fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
        String key = "uploads/"+ UUID.randomUUID()+safeFileName;
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(file.getContentType()==null?"application/octet-stream":file.getContentType()).build();
        s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        return key;

    }
}
