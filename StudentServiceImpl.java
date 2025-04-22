package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.model.Student;
import com.myspring.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired 
	private StudentRepository repository;
	@Override
	public int insert(Student std) {
	   return repository.insertStudent(std);
	}

	@Override
	public int update(Student std, int id) {
	 	return repository.updateStudent(std, id);
	}

	@Override
	public Student getById(int id) {
	   return repository.getByIdStudent(id);
	}

	@Override
	public List<Student> getAll() {
		return repository.getAll();
	}

	@Override
	public int delete(int id) {
		return repository.deleteStudent(id);
	}
}