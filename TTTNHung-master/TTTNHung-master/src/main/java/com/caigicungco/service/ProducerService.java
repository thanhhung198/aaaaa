package com.caigicungco.service;


import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.conver.ProducerConver;
import com.caigicungco.entity.ProducerEntity;
import com.caigicungco.repository.ElectronicRepository;
import com.caigicungco.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ProducerConver producerConver;

    @Autowired
    private ElectronicRepository electronicRepository;


    public ProducerDTO add(ProducerDTO producerdto,String username){
        producerConver.setAdd(producerdto,username);
        ProducerEntity producerEntity = producerRepository.save(producerConver.toEtity(producerdto));
        return producerConver.toDTO(producerEntity);
    }

    public List<ProducerDTO> finAll(){
        List<ProducerEntity> producerEntities = producerRepository.findAll();
        return producerEntities.stream().map(producerConver::toDTO).collect(Collectors.toList());
    }
    public boolean delete(Long id){
        Long coutEleictronic = electronicRepository.countByProducerId(id);
        if(coutEleictronic > 0){
            return false;
        }

        producerRepository.deleteById(id);
        return true;
    }

    public ProducerDTO findById(Long id){
        Optional<ProducerEntity> producerEntity = producerRepository.findById(id);
        if(!producerEntity.isPresent()){
            return null;
        }

        ProducerDTO producerdto = producerConver.toDTO(producerEntity.get());
        return producerdto;
    }


    public List<ProducerDTO> findAll() {
        return producerRepository.findAll().stream().map(producerConver::toDTO).collect(Collectors.toList());
    }

    public ProducerDTO addByJson(String name){
        ProducerEntity producerEntity = producerRepository.findByName(name);
        ProducerDTO producerDTO;
        if(producerEntity == null){
            producerDTO = new ProducerDTO();
            producerDTO.setName(name);
            producerDTO = add(producerDTO,"system");
        }else{
            producerDTO = producerConver.toDTO(producerEntity);
        }

        return producerDTO;
    }
}
