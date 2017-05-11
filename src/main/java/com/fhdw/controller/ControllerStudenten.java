package com.fhdw.controller;

/**
 * Created by timon on 29.04.2017.
 */

import com.fhdw.services.domain.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerStudenten {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/studenten")
    public ModelAndView studenten(){
        ModelAndView mav = new ModelAndView("listestudenten");
        return mav;
    }
}