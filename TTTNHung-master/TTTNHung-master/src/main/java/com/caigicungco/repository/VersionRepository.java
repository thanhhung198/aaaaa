package com.caigicungco.repository;


import com.caigicungco.entity.CPUEntity;
import com.caigicungco.entity.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<VersionEntity,Long> {

}
