package com.fhdw.services.security;

import com.fhdw.objects.Mitarbeiter;

/**
 * Created by Timon Caspari on 10.05.2017.
 */
public interface IMitarbeiterService {
    Mitarbeiter getMitarbeiterByEmail(String Email);
}
