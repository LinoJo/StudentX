package com.fhdw.controller;

/**
 * Created by linus on 10.05.2017.
 */

import com.fhdw.objects.Mitarbeiter;
import com.fhdw.services.security.IMitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerMitarbeiter {
    @Autowired
    private IMitarbeiterService mitarbeiterService;

    @RequestMapping("/mitarbeiter")
    public ModelAndView mitarbeiter(){
        ModelAndView mav = new ModelAndView("listemitarbeiter");

        List<Mitarbeiter> mitarbeiterList = mitarbeiterService.getAll();

        mav.addObject("newMitarbeiter", new Mitarbeiter());
        mav.addObject("allMitarbeiter", mitarbeiterList);
        return mav;
    }
}