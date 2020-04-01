package com.caigicungco.controller;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.DTO.CustomerDTO;
import com.caigicungco.service.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CPUController {
    @Autowired
    private CPUService cpuService;



    @GetMapping(value = "/admin/cpu")
    public String showList(Model model){
        List<CPUDTO> cpus = cpuService.finAll();
        model.addAttribute("cpus",cpus);
        return "cpu/view";
    }

    @GetMapping(value = "/admin/cpu/{id}")
    public String del(@PathVariable(name = "id") Long id){
        String msg = cpuService.delete(id)? "del-sussesfull" : "del-err";
        return "redirect:/admin/cpu?msg=" + msg;
    }


    @PostMapping(value = "/admin/cpu")
    public String add(CPUDTO dto){
        String msg = "";
        dto = cpuService.add(dto,"HDZ");
        msg = dto == null? "add-err" : "add-sussesfull";
        return "redirect:/admin/cpu?msg=" + msg;
    }

    @GetMapping(value = "/admin/test/{id}")
    public ModelAndView showListData(){
        ModelAndView modelAndView = new ModelAndView("cpu/view");
        modelAndView.addObject("cpus",cpuService.finAll());

        return modelAndView;
    }
}
