package com.caigicungco.conver;

import com.caigicungco.DTO.BaseDTO;
import com.caigicungco.entity.BaseEntity;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.Date;

abstract class AbstractConver<E extends BaseEntity,D extends BaseDTO> {

    protected static ModelMapper modelMapper = new ModelMapper();

    abstract D toDTO(E entity);
    abstract E toEtity(D dto);

    public String[] converToArray(String data){
        if(StringUtils.isNotBlank(data)){
            return data.split("~");
        }
        return null;
    }

    public  String converToString(String[] data){
        if(data != null){

            return StringUtils.join(data,"~");
        }
        return null;
    }

    public void setAdd(D d,String username){
        d.setId(null);
        d.setCreatedBy(username);
        d.setCreatedDate(new Date(System.currentTimeMillis()));
    }

    public void setAdd(E d,String username){

        d.setId(null);
        d.setCreatedBy(username);
        d.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    }


    public void setUpdate(D d,String username){

        d.setModifiedBy(username);
        d.setModifiedDate(new Date(System.currentTimeMillis()));
    }
}
