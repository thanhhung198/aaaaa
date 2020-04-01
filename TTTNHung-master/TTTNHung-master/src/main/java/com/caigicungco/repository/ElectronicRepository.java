package com.caigicungco.repository;

import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.repository.custom.ElectronicRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ElectronicRepository extends JpaRepository<ElectronicEntity,Long>, ElectronicRepositoryCustom {
    List<ElectronicEntity> findByTypeAndHighlightsContainingOrderByCreatedDateAsc(String type,String highlights);
    Optional<ElectronicEntity> findByUri(String uri);
    Long countByUri(String uri);
    Long countByProducerId(Long id);
    Long countByGpuId(Long id);
    Long countByCpuId(Long id);
    Page<ElectronicEntity> findAll(Pageable pageable);

    Page<ElectronicEntity> findByProducerName(String producerName,Pageable pageable);

}
