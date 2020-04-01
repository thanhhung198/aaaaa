package com.caigicungco.api;


import com.caigicungco.entity.ElectronicEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600,origins = "*")
public class LaptopAPI {


    @GetMapping(value = "/api/laptop/search")
    public ResponseEntity<List<ElectronicEntity>> search(
            @RequestParam(value = "cpu",defaultValue = "")String cpu,
            @RequestParam(value = "gpu",defaultValue = "")String gpu
    ){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
