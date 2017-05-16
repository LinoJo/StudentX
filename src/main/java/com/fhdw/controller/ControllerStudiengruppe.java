package com.fhdw.controller;

import com.fhdw.objects.Studiengruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fhdw.services.domain.studiengruppen.IStudiengruppeService;
import com.fhdw.services.domain.studenten.IStudentService;

import javax.validation.Valid;

@Controller
public class ControllerStudiengruppe {
	@Autowired
    private IStudiengruppeService studiengruppeService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IStudentService mitarbeiterService;

    @RequestMapping("/studiengruppe")
    public ModelAndView studiengruppe(){
        ModelAndView mav = new ModelAndView("listestudiengruppe");
        mav.addObject("studiengruppen", studiengruppeService.getAll());
        mav.addObject("studenten", studentService.getAll());
        mav.addObject("mitarbeiter", mitarbeiterService.getAll());
        mav.addObject("newStudiengruppe", new Studiengruppe());
        return mav;
    }

    @RequestMapping(value = "/studiengruppe/new", method = RequestMethod.POST)
    public String saveStudiengruppe(@Valid @ModelAttribute("newStudiengruppe") Studiengruppe studiengruppe, BindingResult result) {
        if(!result.hasErrors()){
            studiengruppeService.create(studiengruppe);
        }
        return "redirect:/studiengruppe";
    }
    
    @RequestMapping(value="/studiengruppe/del/{StudiengruppenID}", method=RequestMethod.GET)
    public String removeStudent(@PathVariable("StudiengruppenID") Long studiengruppenID) {
        studiengruppeService.delStudiengruppeByID(studiengruppenID);
        return "redirect:/studiengruppe";
    }
}
