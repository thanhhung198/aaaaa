package com.caigicungco.service;

import com.caigicungco.DTO.GPUDTO;
import com.caigicungco.conver.GPUConver;
import com.caigicungco.entity.GPUEntity;
import com.caigicungco.repository.GPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GPUService {

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private GPUConver gpuConver;

    public List<GPUDTO> findAll(){
        List<GPUEntity> gpuEntities = gpuRepository.findAll();
        return gpuEntities.stream().map(gpuConver::toDTO).collect(Collectors.toList());
    }


    public GPUDTO add(GPUDTO dto, String username) {
        gpuConver.setAdd(dto,username);

        GPUEntity gpuEntity = gpuRepository.save(gpuConver.toEtity(dto));
        if(gpuEntity == null){
            return null;
        }
        return gpuConver.toDTO(gpuEntity);
    }

    public boolean delete(Long id) {
        try{
            gpuRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public GPUDTO addByJson(String name){
        GPUEntity gpuEntity  = gpuRepository.findByName(name);
        GPUDTO gpudto;
        if(gpuEntity == null){
            gpudto = new GPUDTO();
            gpudto.setName(name);
            gpudto = add(gpudto,"system");
        }else{
            gpudto = gpuConver.toDTO(gpuEntity);
        }
        return gpudto;
    }

    public Map<String,GPUDTO> findAllKeyName(){
        List<GPUDTO> gpus = findAll();
        return gpus.stream().collect(Collectors.toMap(GPUDTO::getName,GPUDTO::gThis));
    }
}
