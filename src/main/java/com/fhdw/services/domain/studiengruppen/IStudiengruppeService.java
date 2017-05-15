package com.fhdw.services.domain.studiengruppen;

import java.util.List;

import com.fhdw.objects.Studiengruppe;

public interface IStudiengruppeService {
	Studiengruppe getStudiengruppeByStudiengruppenID(Long StudiengruppenID);
	
	List<Studiengruppe> getAll();

}
