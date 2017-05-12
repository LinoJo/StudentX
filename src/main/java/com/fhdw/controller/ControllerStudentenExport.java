package com.fhdw.controller;

import com.fhdw.objects.Student;
import com.fhdw.services.domain.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by timon on 12.05.2017.
 */
@Controller
public class ControllerStudentenExport {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/studentenexport")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        String csvFileName = "Studenten_"+ getZeitstempel() +".csv";

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setHeader(headerKey, headerValue);

        List<Student> studentList = studentService.getAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] header = { "MatrikelID", "Vorname", "Nachname", "Geschlecht", "Email", "Geburtsdatum", "PLZ", "Ort", "Straße", "Activated", "StudienGruppenID", "Praxisfirma"};

        csvWriter.writeHeader(header);

        for (Student s : studentList){
            csvWriter.write(s, header);
        }

        csvWriter.close();
    }

    public String getZeitstempel() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
    }
}
