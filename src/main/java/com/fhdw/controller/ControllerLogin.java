package com.fhdw.controller;

/**
 * Created by Timon Caspari on 28.04.2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerLogin {
    @RequestMapping("/")

    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}

