package com.fhdw.services.domain.studiengruppen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhdw.interfaces.StudiengruppeRepo;
import com.fhdw.objects.Studiengruppe;

@Service
public class StudiengruppeService implements IStudiengruppeService{
	@Autowired
	private StudiengruppeRepo StudiengruppeRepo;
	
	@Override
    public Studiengruppe getStudiengruppeByStudiengruppenID(Long StudiengruppeID) {
        return StudiengruppeRepo.findOne(StudiengruppeID);
    }

    @Override
    public List<Studiengruppe> getAll() {
        return (List<Studiengruppe>) StudiengruppeRepo.findAll();
    }

    @Override
    public Long getCount() {
        return StudiengruppeRepo.count();
    }
}
