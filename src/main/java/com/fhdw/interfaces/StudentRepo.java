package com.fhdw.interfaces;

/**
 * Created by timon on 04.05.2017.
 */

import org.springframework.data.repository.CrudRepository;
import com.fhdw.objects.Student;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepo
// CRUD refers Create, Read, Update, Delete

public interface StudentRepo extends CrudRepository<Student, Long>{
}
