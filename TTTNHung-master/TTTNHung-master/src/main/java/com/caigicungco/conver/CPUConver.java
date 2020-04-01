package com.caigicungco.conver;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.entity.CPUEntity;
import com.caigicungco.entity.ElectronicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CPUConver extends AbstractConver<CPUEntity, CPUDTO> {

    @Autowired
    private ElectronicConver electronicConver;
    @Override
    public CPUDTO toDTO(CPUEntity entity) {
        CPUDTO cpudto = modelMapper.map(entity,CPUDTO.class);
        return cpudto;
    }
    @Override
    public CPUEntity toEtity(CPUDTO dto) {
        return modelMapper.map(dto,CPUEntity.class);
    }
}
