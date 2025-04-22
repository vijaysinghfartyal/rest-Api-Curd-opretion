
package com.myspring.service;

import java.util.List;

import com.myspring.model.Student;

public interface StudentService {
	int  insert(Student std);
	int  update(Student std,int id);
	Student getById(int id);
	List<Student> getAll();
	int delete(int id);
	

}