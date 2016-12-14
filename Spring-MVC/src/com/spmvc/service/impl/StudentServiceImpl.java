package com.spmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmvc.dao.StudentDao;
import com.spmvc.model.Student;
import com.spmvc.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getStudent() {
		return studentDao.getStudent();
	}

}
