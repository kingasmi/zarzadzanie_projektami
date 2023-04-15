package com.project.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.model.Student;

public interface StudentService {
	Optional<Student> getStudent(Integer studentId);
	Student setStudent(Student student);
	void deleteStudent(Integer studentId);
	Page<Student> getStudenci(Pageable pageable);
	Page<Student> searchByImie(String imie, Pageable pageable);

}
