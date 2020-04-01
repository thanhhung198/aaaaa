package com.caigicungco.api;

import com.caigicungco.DTO.ShopCartDTO;
import com.caigicungco.DTO.api.ModelAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShopCartAPI {


    @PostMapping("/api/shopcart")
    public ResponseEntity<ModelAPI> checkOut(@RequestBody ShopCartDTO shopCartDTO) {
        System.out.println(shopCartDTO);
        return ResponseEntity.ok(null);
    }


}
