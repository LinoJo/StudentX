package com.fhdw.controller;

/**
 * Created by timon on 29.04.2017.
 */

import com.fhdw.objects.Student;
import com.fhdw.services.domain.studenten.IStudentService;
import com.fhdw.services.domain.studiengruppen.IStudiengruppeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ControllerStudenten {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IStudiengruppeService studiengruppeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/studenten")
    public ModelAndView studenten(){
        ModelAndView mav = new ModelAndView("listestudenten");
        mav.addObject("studenten", studentService.getAll());
        mav.addObject("studiengruppen", studiengruppeService.getAll());
        mav.addObject("updateStudent", new Student());
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

    @RequestMapping(value = "/studenten/update", method = RequestMethod.POST)
    public String updateStudent(@RequestParam("MatrikelID") String MatrikelIDStr,
                                @RequestParam("Vorname") String Vorname,
                                @RequestParam("Nachname") String Nachname,
                                @RequestParam("Geschlecht") String Geschlecht,
                                @RequestParam("Email") String Email,
                                @RequestParam("Geburtstag") Date Geburtsdatum,
                                @RequestParam("Strasse") String Strasse,
                                @RequestParam("PLZ") Integer PLZ,
                                @RequestParam("Ort") String Ort,
                                @RequestParam("StudienGruppenID") Long StudienGruppenID,
                                @RequestParam("Praxisfirma") String Praxisfirma
    ){
        Student stdt = studentService.getStudentByMatrikelID(Long.parseLong(MatrikelIDStr));
        stdt.setVorname(Vorname);
        stdt.setNachname(Nachname);
        stdt.setGeschlecht(Geschlecht);
        stdt.setEmail(Email);
        stdt.setGeburtsdatum(Geburtsdatum);
        stdt.setStrasse(Strasse);
        stdt.setPLZ(PLZ);
        stdt.setOrt(Ort);
        stdt.setStudienGruppenID(StudienGruppenID);
        stdt.setPraxisfirma(Praxisfirma);

        studentService.updateStudent(stdt);

        return "redirect:/studenten";
    }

    @RequestMapping(value="/studenten/del/{MatrikelID}", method=RequestMethod.GET)
    public String removeStudent(@PathVariable("MatrikelID") Long MatID) {
        studentService.delStudentByMatrikelID(MatID);
        return "redirect:/studenten";
    }
}