package com.fhdw.interfaces;

/**
 * Created by timon on 04.05.2017.
 */

import org.springframework.data.repository.CrudRepository;
import com.fhdw.objects.Studiengruppe;

public interface StudiengruppeRepo extends CrudRepository<Studiengruppe, Long>{
}
