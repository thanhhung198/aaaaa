package com.caigicungco.utils;

import com.caigicungco.response.UploadFileResponse;
import com.caigicungco.service.FileStorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FileUtils {


    public UploadFileResponse uploadFile(MultipartFile file,String fileName) {

        fileName += getType(file.getOriginalFilename());
        fileName = fileStorageService.storeFile(file,fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    public List<UploadFileResponse> uploadMultipleFiles(MultipartFile[] files,String[] fileName) {
        List<UploadFileResponse> rs = new ArrayList<>();
        IntStream.range(0,files.length).forEach(index ->{
            rs.add(uploadFile(files[index],fileName[index]));
        });

        return rs;
    }

    @Autowired
    private FileStorageService fileStorageService;

    public String getType(String name){
        String rs = "";
        int lastDot = name.length();
        for(int i = name.length() - 1; i >= 0; --i){
            if(name.charAt(i) == '.'){
                lastDot= i;
                break;
            }
        }

        return name.substring(lastDot);
    }


    public String inputStreamToString(InputStream inputStream){
        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
        return result;
    }




}
