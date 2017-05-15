package com.fhdw.controller;

import com.fhdw.objects.Studiengruppe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fhdw.services.domain.studiengruppen.IStudiengruppeService;

import javax.validation.Valid;

@Controller
public class ControllerStudiengruppe {
	@Autowired
    private IStudiengruppeService studiengruppeService;

    @RequestMapping("/studiengruppe")
    public ModelAndView studiengruppe(){
        ModelAndView mav = new ModelAndView("listestudiengruppe");
        mav.addObject("studiengruppe", studiengruppeService.getAll());
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
}
