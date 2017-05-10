package com.fhdw.services.domain;

import com.fhdw.objects.Student;

public interface IStudentService {
	Student getStudentByMatrikelID(Long matrikelID);
}
