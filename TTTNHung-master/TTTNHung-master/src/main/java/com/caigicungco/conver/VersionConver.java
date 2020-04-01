package com.caigicungco.conver;

import com.caigicungco.DTO.VersionDTO;
import com.caigicungco.entity.VersionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VersionConver  extends AbstractConver<VersionEntity, VersionDTO>{
    @Override
    VersionDTO toDTO(VersionEntity entity) {
        if(entity == null){
            return null;
        }
        VersionDTO dto = modelMapper.map(entity,VersionDTO.class);
        dto.setPictures(converToArray(entity.getPicture()));
        return dto;
    }

    @Override
    VersionEntity toEtity(VersionDTO dto) {

        if(dto == null){
            return  null;
        }
        VersionEntity versionEntity = modelMapper.map(dto,VersionEntity.class);

        versionEntity.setPicture(converToString(dto.getPictures()));

        return versionEntity;

    }
}
