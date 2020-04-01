package com.caigicungco.repository;


import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.entity.CPUEntity;
import com.caigicungco.entity.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<ProducerEntity,Long> {
    ProducerEntity findByName(String name);


}
