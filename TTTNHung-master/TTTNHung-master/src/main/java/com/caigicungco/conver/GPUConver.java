package com.caigicungco.conver;

import com.caigicungco.DTO.GPUDTO;
import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.entity.GPUEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GPUConver extends AbstractConver<GPUEntity, GPUDTO> {

    @Autowired
    private ElectronicConver electronicConver;

    @Override
    public GPUDTO toDTO(GPUEntity entity) {
        GPUDTO gpudto = modelMapper.map(entity,GPUDTO.class);
        return gpudto;
    }

    @Override
    public GPUEntity toEtity(GPUDTO dto) {
        GPUEntity gpuEntity = modelMapper.map(dto,GPUEntity.class);
        return gpuEntity;
    }
}
