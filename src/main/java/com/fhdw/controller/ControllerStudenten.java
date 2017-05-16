package com.fhdw.controller;

/**
 * Created by timon on 29.04.2017.
 */

import com.fhdw.objects.Student;
import com.fhdw.services.domain.studenten.IStudentService;
import com.fhdw.services.domain.studiengruppen.IStudiengruppeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ControllerStudenten {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IStudiengruppeService studiengruppeService;

    @RequestMapping("/studenten")
    public ModelAndView studenten(){
        ModelAndView mav = new ModelAndView("listestudenten");
        mav.addObject("studenten", studentService.getAll());
        mav.addObject("studiengruppen", studiengruppeService.getAll());
        mav.addObject("newStudent", new Student());
        return mav;
    }

    @RequestMapping(value = "/studenten/new", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
        if(!result.hasErrors()){
            studentService.create(student);
        }
        return "redirect:/studenten";
    }

    @RequestMapping(value="/studenten/del/{MatrikelID}", method=RequestMethod.GET)
    public String removeStudent(@PathVariable("MatrikelID") Long MatID) {
        studentService.delStudentByMatrikelID(MatID);
        return "redirect:/studenten";
    }
}