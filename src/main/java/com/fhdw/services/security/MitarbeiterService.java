package com.fhdw.services.security;

import com.fhdw.interfaces.MitarbeiterRepo;
import com.fhdw.objects.Mitarbeiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
@Service
public class MitarbeiterService implements IMitarbeiterService{
    @Autowired
    private MitarbeiterRepo mitarbeiterRepo;

    @Override
    public Mitarbeiter getMitarbeiterByEmail(String Email) {
        return mitarbeiterRepo.findOne(Email);
    }

    @Override
    public List<Mitarbeiter> getAll() {
        return (List<Mitarbeiter>) mitarbeiterRepo.findAll();
    }
}
