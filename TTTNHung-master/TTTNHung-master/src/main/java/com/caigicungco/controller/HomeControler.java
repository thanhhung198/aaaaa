package com.caigicungco.controller;


import com.caigicungco.DTO.BaseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControler {

    @RequestMapping(value = {"/admin/","/admin/home"},method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("msg","Hùng Đz ahihi");
        return modelAndView;
    }

    @RequestMapping(value = {"/blank"},method = RequestMethod.GET)
    public String blank(){

        return "blank";
    }

    @RequestMapping(value = {"/test"},method = RequestMethod.GET)
    public String test(){

        return "test";
    }




    @RequestMapping(value = "/admin/home",method = RequestMethod.POST)
    public String addBasicDTO(BaseDTO dto){

        return "redirect:/admin/home";
    }

}
