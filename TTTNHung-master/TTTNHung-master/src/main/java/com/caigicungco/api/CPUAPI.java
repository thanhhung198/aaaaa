package com.caigicungco.api;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.entity.CPUEntity;
import com.caigicungco.service.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CPUAPI {


    @Autowired
    private CPUService cpuService;

    @PostMapping(value = "/api/cpu")
    public ResponseEntity<CPUDTO> add(@RequestBody CPUDTO cpudto) {

        cpudto = cpuService.add(cpudto, "system");
        if (cpudto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<CPUDTO>(cpudto, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/api/cpu/{id}")
    public ResponseEntity<CPUDTO> findById(@PathVariable Long id) {
        CPUDTO cpudto = cpuService.findById(id);
        return cpudto == null ? new ResponseEntity<CPUDTO>(cpudto, HttpStatus.BAD_REQUEST) : new ResponseEntity<CPUDTO>(cpudto, HttpStatus.OK);

    }


}
