package com.caigicungco.controller;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.DTO.GPUDTO;
import com.caigicungco.service.CPUService;
import com.caigicungco.service.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GPUController {

    @Autowired
    public GPUService gpuService;

    @GetMapping(value = "/admin/gpu")
    public String showList(Model model){
        List<GPUDTO> gpus = gpuService.findAll();
        model.addAttribute("gpus",gpus);
        return "gpu/view";
    }

    @GetMapping(value = "/admin/gpu/{id}")
    public String del(@PathVariable(name = "id") Long id){
        String msg = gpuService.delete(id)? "del-sussesfull" : "del-err";
        return "redirect:/admin/gpu?msg=" + msg;
    }


    @PostMapping(value = "/admin/gpu")
    public String add(GPUDTO dto){
        String msg = "";
        dto = gpuService.add(dto,"HDZ");
        msg = dto == null? "add-err" : "add-sussesfull";
        return "redirect:/admin/gpu?msg=" + msg;
    }
}
