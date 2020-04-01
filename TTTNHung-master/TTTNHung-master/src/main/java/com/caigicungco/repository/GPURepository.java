package com.caigicungco.repository;

import com.caigicungco.entity.GPUEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPURepository extends JpaRepository<GPUEntity,Long>{
    GPUEntity findByName(String name);
}
