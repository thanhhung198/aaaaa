package com.caigicungco.api;


import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.api.ModelAPI;
import com.caigicungco.constant.product.ElectronicHighlights;
import com.caigicungco.constant.product.ElectronicStatus;
import com.caigicungco.constant.product.ElectronicType;
import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.entity.VersionEntity;
import com.caigicungco.repository.ElectronicRepository;
import com.caigicungco.service.ElectronicService;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ElectronicAPI {


    @Autowired
    private ElectronicService electronicService;


    public static ElectronicEntity initELectronic(){
        ElectronicEntity entity = new ElectronicEntity();
        entity.setCreatedBy("admin");
        entity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        entity.setName("iphone 11");
        entity.setGuarantee(12);
        entity.setType(ElectronicType.MOBILE.Value());
        entity.setStatus(ElectronicStatus.CON_HANG.Value());
        entity.setHighlights(ElectronicHighlights.HOT.Value() + "," + ElectronicHighlights.NEW.Value());
        entity.setDescribes("Sản Phẩm Đắt VL |Sản Phẩm Xấu VL |Nhưng vẫn nhiều người mua ok");
        entity.setRam("12G");
        entity.setSecondaryMamory("128G");
        VersionEntity versionEntity = new VersionEntity();
        versionEntity.setColor("RED");
        versionEntity.setPrice(999);
        versionEntity.setCreatedBy("admin");
        versionEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        versionEntity.setElectronicEntity(entity);


        entity.setVersions(Arrays.asList(new VersionEntity[]{versionEntity}));
        return  entity;

    }

    @GetMapping(value = "/api/test")
    public ResponseEntity<List<ElectronicDTO>> findTest(){
        List<ElectronicDTO> list = electronicService.findAll();
        return new ResponseEntity<List<ElectronicDTO>>(list,HttpStatus.OK);
    }

    @GetMapping(value = "/api/electronic/{uri}")
    public ResponseEntity<ElectronicDTO> findByUri(@PathVariable String uri){
        ElectronicDTO electronicDTO = electronicService.findByUri(uri);
        if(electronicDTO != null){
            return new ResponseEntity<ElectronicDTO>(electronicDTO,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }





    @GetMapping(value = "/api/electronic")
    public ResponseEntity<ModelAPI> findAll(@RequestParam("page") Integer page,
                                                       @RequestParam(value = "pageItem",defaultValue = "10") Integer pageItem){
        List<ElectronicDTO> electronics = electronicService.findAll(PageRequest.of(page,pageItem));
        if(electronics == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        ModelAPI<ElectronicDTO> modelAPI = new ModelAPI<>("ok",electronics);
        return new ResponseEntity<ModelAPI>(modelAPI, HttpStatus.OK);
}



    @GetMapping(value = "/api/electronic/{type}/{highlights}")
    public ResponseEntity<ModelAPI> findByHightLight(@PathVariable(value = "type") String type,
                                                                @PathVariable(name = "highlights") String highlights) {
        ModelAPI<ElectronicDTO> modelAPI = new ModelAPI<>();
        List<ElectronicDTO> listResult = new ArrayList<>();
        boolean checkType = false;
        for (ElectronicType eType : ElectronicType.values()) {
            if(eType.Value().equalsIgnoreCase(type)){
                checkType = true;
                break;
            }
        }
        if(!checkType){
            modelAPI.setStatus(ModelAPI.STATUS_ERROR);
            return new ResponseEntity<ModelAPI>(modelAPI,HttpStatus.BAD_REQUEST);
        }

        boolean checkHighlight = false;
        for (ElectronicHighlights eHighlights : ElectronicHighlights.values()){
            if(eHighlights.Value().equalsIgnoreCase(highlights)){
                checkHighlight = true;
                break;
            }
        }

        if(!checkHighlight){
            modelAPI.setStatus(ModelAPI.STATUS_ERROR);
            return new ResponseEntity<ModelAPI>(modelAPI,HttpStatus.BAD_REQUEST);
        }
        listResult = electronicService.findElectronic(type,highlights);
        modelAPI.setStatus(ModelAPI.STATUS_OK);
        modelAPI.setData(listResult);
        return new ResponseEntity<ModelAPI>(modelAPI, HttpStatus.OK);
    }


    @PostMapping(value = "/api/electronic")
    public ResponseEntity<ElectronicDTO> addElectronic(@RequestBody ElectronicDTO dto){
        dto = electronicService.add(dto);
        if(dto == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping(value = "/api/electronic/list")
    public ResponseEntity addElectronic(@RequestBody List<ElectronicDTO> dtos){

        if(electronicService.addAll(dtos)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
}
