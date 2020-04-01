package com.caigicungco.api;



import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.PageDTO;
import com.caigicungco.DTO.api.ModelAPI;
import com.caigicungco.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600,origins = "*")
public class MobileAPI {
    @Autowired
    ElectronicService electronicService;

    @GetMapping(value = "/api/mobile/{producer}")
    public ResponseEntity<ModelAPI<ElectronicDTO>> findByProducer(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "pageItem",defaultValue = "10") Integer pageItem,
            @PathVariable("producer") String producer){

//        List<ElectronicDTO> electronics = electronicService.findByProducerName(producer,PageRequest.of(page,pageItem));
        Page<ElectronicDTO> pages = electronicService.findByProducerNamePage(producer,PageRequest.of(page - 1,pageItem));

        if(pages == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        ModelAPI<ElectronicDTO> modelAPI = new ModelAPI<>("ok",pages.getContent());
        modelAPI.setPaging(new PageDTO(pages.getTotalElements(),pages.getTotalPages(),pages.getPageable().getPageNumber() + 1));
        return new ResponseEntity<ModelAPI<ElectronicDTO>>(modelAPI, HttpStatus.OK);
    }

    @GetMapping(value = "/api/mobile")
    public ResponseEntity<ModelAPI<ElectronicDTO>> findByProducerId(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "pageItem",defaultValue = "10") Integer pageItem,
            @RequestParam("producerId") Long producerId){

        List<ElectronicDTO> electronics = electronicService.findByProducerName("samsung",PageRequest.of(page,pageItem));
        if(electronics == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        ModelAPI<ElectronicDTO> modelAPI = new ModelAPI<>("ok",electronics);
        return new ResponseEntity<ModelAPI<ElectronicDTO>>(modelAPI, HttpStatus.OK);

    }


}
