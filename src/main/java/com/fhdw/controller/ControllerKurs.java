package com.fhdw.controller;

/**
 * Created by linus on 10.05.2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerKurs {
    @RequestMapping("/kurs")

    public ModelAndView kurs(){
        ModelAndView mav = new ModelAndView("listekurs");
        return mav;
    }
}