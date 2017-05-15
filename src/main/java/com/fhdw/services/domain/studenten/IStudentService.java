package com.fhdw.services.domain.studenten;

import com.fhdw.objects.Student;

import java.util.List;

public interface IStudentService {
	Student getStudentByMatrikelID(Long matrikelID);

	List<Student> getAll();

	Student create(Student student);

	void delStudentByMatrikelID(Long MatID);
}
