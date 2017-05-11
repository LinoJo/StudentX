package com.fhdw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fhdw.services.domain.IStudiengruppeService;

@Controller
public class ControllerStudiengruppe {
	@Autowired
    private IStudiengruppeService studiengruppeService;

    @RequestMapping("/studiengruppe")
    public ModelAndView studiengruppe(){
        ModelAndView mav = new ModelAndView("listestudiengruppe");
        mav.addObject("studiengruppe", studiengruppeService.getAll());
        return mav;
    }
}
