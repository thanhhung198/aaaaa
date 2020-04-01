package com.caigicungco.controller;

import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.VersionDTO;
import com.caigicungco.constant.TypeFile;
import com.caigicungco.constant.product.ElectronicType;
import com.caigicungco.entity.GPUEntity;
import com.caigicungco.response.UploadFileResponse;
import com.caigicungco.service.CPUService;
import com.caigicungco.service.ElectronicService;
import com.caigicungco.service.GPUService;
import com.caigicungco.service.ProducerService;
import com.caigicungco.utils.ElectronicUtils;
import com.caigicungco.utils.FileUtils;
import com.caigicungco.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Controller
public class MobileControler {

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private CPUService cpuService;

    @Autowired
    private GPUService gpuService;

    @Autowired
    private ProducerService producerService;

    @GetMapping(value = {"/admin/mobile/ae","/admin/sanpham/ae"})
    public String viewAE(Model model, @RequestParam(name = "type",defaultValue = "add") String type){

        model.addAttribute("gpus",gpuService.findAll());
        model.addAttribute("cpus",cpuService.findAll());
        model.addAttribute("producers",producerService.findAll());


        if(type.equalsIgnoreCase("add")){

        }else{

        }
        return "mobile/add-edit";
    }




    @PostMapping(value = "/admin/mobile/ae")
    public String aeElectronic(@RequestParam(required = false,name = "electronic")String electronicJson,
                               @RequestParam(name = "versions") String versionsJson,
                               @RequestParam(name = "pictureTitle",required = false) MultipartFile file,
                               HttpServletRequest request
    ) {

        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

        try {
            ElectronicDTO electronic =  new ObjectMapper().readValue(electronicJson, ElectronicDTO.class);
            electronic.setType(ElectronicType.MOBILE.Value());
            String url = StringUtils.decodeURI(electronic.getName());
            if(electronicService.findByUri(url) != null){
                return "redirect:/admin/electronic/ae?add=uri-error";
            }
            electronic.setUri(url);

            String type = file.getContentType();
            if(!type.contains("image/")){
                return "redirect:/admin/mobile/ae?add=err-img";
            }



            UploadFileResponse uploadFileResponse = fileUtils.uploadFile(file,url + "-title");
            electronic.setPictureTitle(uploadFileResponse.getFileName());


            VersionDTO[] versions = new ObjectMapper().readValue(versionsJson,VersionDTO[].class);

            Arrays.stream(versions).forEach(item->{
                List<String> picturesVersion = new ArrayList<>();
                String nameVersionImg = "version-img-" + item.getId();
                List<MultipartFile> files = multiRequest.getFiles(nameVersionImg);
                IntStream.range(0,files.size()).forEach(index->{
                    String fileNameVersion = url + "-" + nameVersionImg + "-" + index;
                    UploadFileResponse uploadFileVersion = fileUtils.uploadFile(files.get(index),fileNameVersion);
                    picturesVersion.add(uploadFileVersion.getFileName());
                });

                item.setPictures(picturesVersion.toArray(new String[picturesVersion.size()]));
            });
            electronic.setVersions(Arrays.asList(versions));

            electronicService.add(electronic);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/admin/sanpham/ae?add=err";
        }

        return "redirect:/admin/sanpham/ae";
    }
}
