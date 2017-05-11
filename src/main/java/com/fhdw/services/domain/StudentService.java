package com.fhdw.services.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fhdw.interfaces.StudentRepo;
import com.fhdw.objects.Student;

import java.util.List;

@Service
public class StudentService implements IStudentService{
	@Autowired
    private StudentRepo studentRepo;

    @Override
    public Student getStudentByMatrikelID(Long matrikelID) {
        return studentRepo.findOne(matrikelID);
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentRepo.save(student);
    }
}
