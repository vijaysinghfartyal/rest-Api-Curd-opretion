package com.myspring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Setter
@Getter
@ToString */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private int id;
	private String name;
	private String email;
	private int passpno; 
	
 
}
/*
create table Studentpassportdetails(id int primary key,name varchar(255),email varchar(255) unique, passpno int unique);
*/