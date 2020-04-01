package com.caigicungco.conver;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.entity.CPUEntity;
import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.entity.ProducerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProducerConver extends AbstractConver<ProducerEntity, ProducerDTO> {

    @Autowired
    private ElectronicConver electronicConver;
    @Override
    public ProducerDTO toDTO(ProducerEntity entity) {
        ProducerDTO producerDTO = new org.modelmapper.ModelMapper().map(entity,ProducerDTO.class);
        return producerDTO;
    }

    @Override
    public ProducerEntity toEtity(ProducerDTO dto) {
        return modelMapper.map(dto,ProducerEntity.class);
    }
}
