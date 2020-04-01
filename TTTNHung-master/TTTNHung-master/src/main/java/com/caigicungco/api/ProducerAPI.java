package com.caigicungco.api;

import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.DTO.api.ModelAPI;
import com.caigicungco.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600,origins = "*")
public class ProducerAPI {
    @Autowired
    ProducerService producerService;

    @GetMapping(value = "/api/producer")
    public ResponseEntity<ModelAPI<ProducerDTO>> findAll(){
        List<ProducerDTO> producerDTOList = producerService.findAll();
        ModelAPI<ProducerDTO> modelAPI = new ModelAPI<ProducerDTO>("ok",producerDTOList);
        return new ResponseEntity<ModelAPI<ProducerDTO>>(modelAPI, HttpStatus.OK);
    }
}
