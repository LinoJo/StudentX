package com.fhdw.services.domain.studiengruppen;

import java.util.List;

import com.fhdw.objects.Studiengruppe;

public interface IStudiengruppeService {
	Studiengruppe getStudiengruppeByStudiengruppenID(Long studiengruppenID);
	
	List<Studiengruppe> getAll();

	Long getCount();
	
	void delStudiengruppeByID(Long studiengruppenID);

	Studiengruppe create(Studiengruppe studiengruppe);
}
