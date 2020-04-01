package com.caigicungco.controller;

import com.caigicungco.DTO.ElectronicDTO;


import com.caigicungco.response.UploadFileResponse;
import com.caigicungco.service.FileStorageService;
import com.caigicungco.utils.FileUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ElectronicController {

    @Autowired
    private FileUtils fileUtils;

    @GetMapping(value = "/admin/electronic/ae")
    public String viewAE(Model model, @RequestParam(name = "type",defaultValue = "add") String type){
        if(type.equalsIgnoreCase("add")){

        }else{

        }
        return "electronic/add-edit";
    }




    @PostMapping(value = "/admin/electronic/ae")
    public String aeElectronic(@RequestParam(required = false,name = "json")String json,
                               @RequestParam(name = "pictureTitle",required = false) MultipartFile file
                               ){



        try {
            System.out.println(json);
            ElectronicDTO electronic =  new ObjectMapper().readValue(json, ElectronicDTO.class);
            String type = file.getContentType();
            if(!type.contains("image/")){
                return "redirect:/admin/electronic/ae?add=err-img";
            }

            UploadFileResponse uploadFileResponse = fileUtils.uploadFile(file,"electronic-");


            System.out.println(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/admin/electronic/ae?add=err";
        }

        return "redirect:/admin/electronic/ae";
    }






}
