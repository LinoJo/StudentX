package com.fhdw.services.security;

import com.fhdw.objects.Mitarbeiter;

import java.util.List;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
public interface IMitarbeiterService {
    Mitarbeiter getMitarbeiterByEmail(String Email);

    List<Mitarbeiter> getAll();

    void delMitarbeiterByEmail(String Email);

    void updateMitarbeiter(Mitarbeiter mitarbeiter);
}
