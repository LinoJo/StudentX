package com.fhdw.interfaces;

/**
 * Created by timon on 05.05.2017.
 */

import com.fhdw.objects.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MitarbeiterRepo extends CrudRepository<Mitarbeiter, Long> {
    List<Mitarbeiter> findByNachname(String Nachname);
}
