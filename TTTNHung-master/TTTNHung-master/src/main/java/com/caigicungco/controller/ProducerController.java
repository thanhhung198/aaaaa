package com.caigicungco.controller;

import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping(value = "/admin/producer")
    public String showList(Model model){
        List<ProducerDTO> producers = producerService.finAll();
        model.addAttribute("producers",producers);
        return "producer/view";
    }

    @GetMapping(value = "/admin/producer/{id}")
    public String del(@PathVariable(name = "id") Long id){
        String msg = producerService.delete(id)? "del-sussesfull" : "del-err";
        return "redirect:/admin/producer?msg=" + msg;
    }


    @PostMapping(value = "/admin/producer")
    public String add(ProducerDTO dto){
        String msg = "";
        dto = producerService.add(dto,"HDZ");
        msg = dto == null? "add-err" : "add-sussesfull";
        return "redirect:/admin/producer?msg=" + msg;
    }
}
