package com.caigicungco.service;


import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.conver.CPUConver;
import com.caigicungco.entity.CPUEntity;
import com.caigicungco.repository.CPURepository;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CPUService {

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private CPUConver cpuConver;


    public CPUDTO add(CPUDTO cpudto,String username){
        cpuConver.setAdd(cpudto,username);
        CPUEntity cpuEntity = cpuRepository.save(cpuConver.toEtity(cpudto));
        return cpuConver.toDTO(cpuEntity);
    }

    public List<CPUDTO> finAll(){
        return cpuRepository.findAll().stream().map(cpuConver::toDTO).collect(Collectors.toList());
    }
    public boolean delete(Long id){
        try{
            cpuRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public CPUDTO findById(Long id){
        Optional<CPUEntity> cpuEntity = cpuRepository.findById(id);
        if(!cpuEntity.isPresent()){
            return null;
        }

        CPUDTO cpudto = cpuConver.toDTO(cpuEntity.get());



        return cpudto;
    }


    public List<CPUDTO> findAll() {
        return cpuRepository.findAll().stream().map(cpuConver::toDTO).collect(Collectors.toList());
    }

    public CPUDTO addByJson(String name){
        CPUEntity cpuEntity  = cpuRepository.findByName(name);
        CPUDTO cpudto;
        if(cpuEntity == null){
            cpudto = new CPUDTO();
            cpudto.setName(name);
            cpudto = add(cpudto,"system");
        }else{
            cpudto = cpuConver.toDTO(cpuEntity);
        }
        return cpudto;
    }

    public Map<String, CPUDTO> findAllKeyName() {
        List<CPUDTO> gpus = finAll();
        return gpus.stream().collect(Collectors.toMap(CPUDTO::getName,CPUDTO::gThis));
    }
}
