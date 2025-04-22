package com.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.model.Student;
import com.myspring.service.StudentService;

@RestController
@Controller
@RequestMapping("/Studentpassportdetails")
public class StudentCoontroller {
    @Autowired
	private StudentService  studentSevice;
    
    @PostMapping("/save")
    public  ResponseEntity<String> saveStudent(@RequestBody Student std) {
           int insert = studentSevice.insert(std);
 	       return new ResponseEntity<String>("Save Successfully  "+insert,HttpStatus.OK);
 	}
    
    @PutMapping("/upt/{id}")
    public  ResponseEntity<String> updateStudent(@RequestBody Student std,@PathVariable int id) {
           int upt = studentSevice.update(std,id);
 	       return new ResponseEntity<String>("Update` Successfully  "+upt,HttpStatus.UPGRADE_REQUIRED);
 	}
    
    @GetMapping("/getbyid/{id}")
    public  ResponseEntity<Student> getByIdStudent(@PathVariable int id) {
          Student studentbyId = studentSevice.getById(id);
 	       return new ResponseEntity<Student>(studentbyId,HttpStatus.OK);
 	}
    
    @GetMapping("/getall")
    public  ResponseEntity<List<Student>> getAllStudent() {
        List<Student> allstudent = studentSevice.getAll();
 	       return new ResponseEntity<List<Student>>(allstudent,HttpStatus.OK);
 	}
	
    @DeleteMapping("/delete/{passpno}")
    public  ResponseEntity<String> deleteStudent(@PathVariable int passpno) {
           int del = studentSevice.delete(passpno);
 	       return new ResponseEntity<String>("Deleted` Successfully  "+del,HttpStatus.OK);
 	}
}