package com.fhdw.interfaces;

/**
 * Created by timon on 05.05.2017.
 */

import com.fhdw.objects.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface MitarbeiterRepo extends CrudRepository<Mitarbeiter, String> {
}

