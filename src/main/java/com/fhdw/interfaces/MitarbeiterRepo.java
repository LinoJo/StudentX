package com.fhdw.interfaces;

/**
 * Created by timon on 05.05.2017.
 */

import com.fhdw.objects.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

public interface MitarbeiterRepo extends CrudRepository<Mitarbeiter, Long> {
    Mitarbeiter findMitarbeiterByEmail(String Email);
}
