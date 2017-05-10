package com.fhdw.services.security;

import com.fhdw.objects.Student;

public interface IStudentService {
	Student getStudentByMatrikelID(Long matrikelID);
}
