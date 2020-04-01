package com.caigicungco.repository;

import com.caigicungco.entity.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<WardEntity,Integer> {
    List<WardEntity> findByDistrictId(Integer districtId);
}
