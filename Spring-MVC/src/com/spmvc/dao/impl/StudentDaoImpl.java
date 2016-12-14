package com.spmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spmvc.dao.StudentDao;
import com.spmvc.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Student> getStudent() {
		String sql="select *from student";
		List<Student> list=jdbcTemplate.query(sql,new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
				Student student=new Student();
				student.setSid(arg0.getInt(1));
				student.setSname(arg0.getString(2));
				student.setT_id(arg0.getInt(3));
				return student;
			}
			
		});
		return list;
	}

}
