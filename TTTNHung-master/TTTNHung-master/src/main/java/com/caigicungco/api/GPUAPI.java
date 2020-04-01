package com.caigicungco.api;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class GPUAPI {
    @PostMapping("/login")
    public ResponseEntity<ResponseRest<Token>> login(){
        Token token = new Token();
        token.setAccess_token("ahihi");
        ResponseRest<Token> tokenResponseEntity = new ResponseRest<Token>();
        tokenResponseEntity.setData(token);
        tokenResponseEntity.setMessage("suss");
        tokenResponseEntity.setStats(200);
        return ResponseEntity.ok(tokenResponseEntity);
    }

}
