package com.caigicungco.service;


import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.conver.ElectronicConver;
import com.caigicungco.conver.VersionConver;
import com.caigicungco.entity.ElectronicEntity;
import com.caigicungco.entity.VersionEntity;
import com.caigicungco.repository.ElectronicRepository;
import com.caigicungco.repository.VersionRepository;
import com.caigicungco.utils.ElectronicUtils;
import com.caigicungco.utils.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElectronicService {

    @Autowired
    private ElectronicRepository repository;

    @Autowired
    private ElectronicConver electronicConver;

    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    VersionConver versionConver;

    public List<ElectronicDTO> findByProducerName(String producerName,Pageable pageable){
        Page<ElectronicEntity> page = repository.findByProducerName(producerName,pageable);

        return page.getContent().stream().map(electronicConver::toDTO).collect(Collectors.toList());
    }
    public Page<ElectronicDTO> findByProducerNamePage(String producerName,Pageable pageable){
        Page<ElectronicEntity> page = repository.findByProducerName(producerName,pageable);

        return page.map(electronicConver::toDTO);
    }

    public boolean addAll(List<ElectronicDTO> electronics){

        List<ElectronicEntity> electronicEntities = electronics.stream().map(electronicConver::toEtity).collect(Collectors.toList());

        electronicEntities.forEach(electronic ->{
            electronicConver.setAdd(electronic,"admin");
            electronic.setUri(StringUtils.decodeURI(electronic.getName()));
            if(electronic.getVersions() != null){
                electronic.getVersions().forEach(version->{
                    versionConver.setAdd(version,"admin");
                    version.setElectronicEntity(electronic);
                });
            }


            if(!checkUri(electronic.getUri())){
                System.err.println("==== >BAT DAU THEM " + electronic.getUri());
                repository.save(electronic);
                System.err.println("==== >THEM " + electronic.getUri() + " THANH CONG");
            }else{
                System.err.println("Trùng URI ELECTRONIC " + electronic.getUri());
            }
        });


        return true;
    }

    public boolean checkUri(String uri){
        return repository.countByUri(uri) > 0;
    }

    public List<ElectronicDTO> findAll(){
        return repository.findAll()
                .stream().map(electronicConver::toDTO)
                .collect(Collectors.toList());
    }

    public List<ElectronicDTO> findAll(Pageable pageable){
        Page<ElectronicEntity> pages = repository.findAll(pageable);


        List<ElectronicEntity> entities = pages.getContent();
        return entities.stream().map(electronicConver::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ElectronicDTO add(ElectronicDTO dto){
        ElectronicEntity electronic = electronicConver.toEtity(dto);

        for (VersionEntity version : electronic.getVersions()) {
            versionConver.setAdd(version, "admin");
            version.setElectronicEntity(electronic);
        }

        return electronicConver.toDTO(repository.save(electronic));
    }

    public ElectronicDTO findByUri(String url){
        Optional<ElectronicEntity> optional = repository.findByUri(url);
        if(!optional.isPresent()){
            return null;
        }
        return electronicConver.toDTO(repository.findByUri(url).get());
    }

    public List<ElectronicDTO> findElectronic(String type, String highlight) {

        List<ElectronicEntity> list = repository.findByTypeAndHighlightsContainingOrderByCreatedDateAsc(type, highlight);

        return list.stream()
                .map(electronicConver::toDTO)
                .collect(Collectors.toList());
//        return repository
//                .findByTypeAndHighlightsContainingOrderByCreatedDateAsc(type,highlight)
//                .stream().map(electronicConver::toDTO)
//                .collect(Collectors.toList());
    }

}
