package com.fhdw.controller;

/**
 * Created by linus on 10.05.2017.
 */

import com.fhdw.interfaces.MitarbeiterRepo;
import com.fhdw.objects.Mitarbeiter;
import com.fhdw.services.security.IMitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public String saveMitarbeiter(
            @RequestParam("Vorname") String Vorname,
            @RequestParam("Nachname") String Nachname,
            @RequestParam("Geschlecht") String Geschlecht,
            @RequestParam("Email") String Email,
            @RequestParam("Passwort") String Passwort,
            @RequestParam("Geburtsdatum") String Geburtsdatum,
            @RequestParam("Strasse") String Strasse,
            @RequestParam("PLZ") Integer PLZ,
            @RequestParam("Ort") String Ort,
            @RequestParam("Position") Integer Position,
            @RequestParam("Role") Integer Role
            ){
        Mitarbeiter ma = new Mitarbeiter();

        if (Role == 2){
            ma.setRole(com.fhdw.enums.Role.ROLE_ADMIN);
        }
        else {
            ma.setRole(com.fhdw.enums.Role.ROLE_USER);
        }

        Date dt = new Date();

        DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        try{
            dt = format.parse(Geburtsdatum);
        }
        catch (ParseException e){

        }

        ma.setVorname(Vorname);
        ma.setNachname(Nachname);
        ma.setEmail(Email);
        ma.setPasswort(passwordEncoder.encode(Passwort));
        ma.setGeburtsdatum(dt);
        ma.setActivated(Boolean.TRUE);
        ma.setGeschlecht(Geschlecht);
        ma.setPosition(Position);
        ma.setStrasse(Strasse);
        ma.setPLZ(PLZ);
        ma.setOrt(Ort);

        mitarbeiterRepo.save(ma);

        return "redirect:/mitarbeiter";
    }

    @RequestMapping(value="/mitarbeiter/del/{Email}", method=RequestMethod.GET)
    public String removeStudent(@PathVariable("Email") String Email) {
        mitarbeiterService.delMitarbeiterByEmail(Email);
        return "redirect:/mitarbeiter";
    }
}