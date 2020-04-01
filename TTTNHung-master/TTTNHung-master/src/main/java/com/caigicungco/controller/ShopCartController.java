package com.caigicungco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class ShopCartController {
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("shop-cart");
        return modelAndView;
    };
}
