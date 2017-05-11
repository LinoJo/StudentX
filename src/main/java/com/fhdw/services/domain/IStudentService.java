package com.fhdw.services.domain;

import com.fhdw.objects.Student;

import java.util.List;

public interface IStudentService {
	Student getStudentByMatrikelID(Long matrikelID);

	List<Student> getAll();

}
