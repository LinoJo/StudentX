package com.fhdw.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fhdw.interfaces.StudentRepo;
import com.fhdw.objects.Student;

@Service
public class StudentService implements IStudentService{
	@Autowired
    private StudentRepo studentRepo;

    @Override
    public Student getStudentByMatrikelID(Long matrikelID) {
        return studentRepo.findOne(matrikelID);
    }

}
