package com.caigicungco.repository.custom;


import com.caigicungco.builder.ElectronicSearchBuilder;
import com.caigicungco.entity.ElectronicEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ElectronicRepositoryCustom {
    public List<ElectronicEntity> search(ElectronicSearchBuilder builder);
    void removeCPUId(Long cpuId);
}
