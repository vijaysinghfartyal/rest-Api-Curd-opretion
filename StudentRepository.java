package com.myspring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.myspring.model.Student;
@Component
public class StudentRepository {
	@Autowired
	
	
	private JdbcTemplate jdbcTemplate;
	
	static class StudentRowMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		    Student s1 = new Student();
		   // System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getInt(4));
		    
		    s1.setId(rs.getInt(1));
		    s1.setName(rs.getString(2));
		    s1.setEmail(rs.getString(3));
		    s1.setPasspno(rs.getInt(4));
			return s1;
		}
		
	} 
	
	public int insertStudent(Student std) {
	   return jdbcTemplate.update("insert into Studentpassportdetails values(?,?,?,?)", std.getId(),std.getName(),std.getEmail(),std.getPasspno());
	}

    public int updateStudent(Student std, int id) {
	  return jdbcTemplate.update("update Studentpassportdetails set name=?,passpno=? where id=?",std.getName(),std.getPasspno(),id);
	}

	 
	public Student getByIdStudent(int id) {
		 return  jdbcTemplate.queryForObject("select * from Studentpassportdetails where id="+id+"", new StudentRowMapper());
		// return  jdbcTemplate.queryForObject("select * from Studentpassportdetails where id=?", new BeanPropertyRowMapper<Student>(Student.class),id);
	}

	public int deleteStudent(int id) {
		 
		return jdbcTemplate.update("delete from Studentpassportdetails where passpno=?",id);
	}
 
	public List<Student> getAll() {
		 
		return jdbcTemplate.query("select * from studentpassportdetails", new StudentRowMapper());
	}

}