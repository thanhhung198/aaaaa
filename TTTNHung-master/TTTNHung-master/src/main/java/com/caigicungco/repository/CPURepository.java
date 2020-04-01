package com.caigicungco.repository;


import com.caigicungco.entity.CPUEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPURepository extends JpaRepository<CPUEntity,Long> {
    CPUEntity findByName(String name);
}
