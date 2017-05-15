package com.fhdw.controller;

/**
 * Created by timon on 29.04.2017.
 */

import com.fhdw.objects.Student;
import com.fhdw.services.domain.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ControllerStudenten {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/studenten")
    public ModelAndView studenten(){
        ModelAndView mav = new ModelAndView("listestudenten");
        mav.addObject("studenten", studentService.getAll());
        mav.addObject("newStudent", new Student());
        return mav;
    }

    @RequestMapping(value = "/studenten", method = RequestMethod.POST)
    public void saveStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
        if(!result.hasErrors()){
            studentService.create(student);
        }
    }
}