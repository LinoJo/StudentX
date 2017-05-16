package com.fhdw.controller;

/**
 * Created by linus on 10.05.2017.
 */

import com.fhdw.enums.Role;
import com.fhdw.interfaces.MitarbeiterRepo;
import com.fhdw.objects.Mitarbeiter;
import com.fhdw.services.security.IMitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerMitarbeiter {
    @Autowired
    private IMitarbeiterService mitarbeiterService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MitarbeiterRepo mitarbeiterRepo;

    @RequestMapping("/mitarbeiter")
    public ModelAndView mitarbeiter(){
        ModelAndView mav = new ModelAndView("listemitarbeiter");

        List<Mitarbeiter> mitarbeiterList = mitarbeiterService.getAll();

        List<Mitarbeiter> toRemove = new ArrayList<Mitarbeiter>();
        for(Mitarbeiter a: mitarbeiterList){
            if(a.getEmail().equals("admin")){
                toRemove.add(a);
            }
        }
        for(Mitarbeiter a: mitarbeiterList){
            if(a.getEmail().equals("user")){
                toRemove.add(a);
            }
        }

        mitarbeiterList.removeAll(toRemove);

        mav.addObject("newMitarbeiter", new Mitarbeiter());
        mav.addObject("allMitarbeiter", mitarbeiterList);
        return mav;
    }

    @RequestMapping(value = "/mitarbeiter/new", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute("newMitarbeiter") Mitarbeiter mitarbeiter, BindingResult result) {
        if(!result.hasErrors()){
            mitarbeiter.setPasswort(passwordEncoder.encode(mitarbeiter.getPasswort()));
            mitarbeiterRepo.save(mitarbeiter);
        }
        return "redirect:/mitarbeiter";
    }
}