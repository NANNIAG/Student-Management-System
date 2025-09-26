package com.nandini.service;

import com.nandini.dao.StudentDao;
import com.nandini.dto.Student;
import com.nandini.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.add(student);
		return status;

	}

	@Override
	public Student searchStudent(String sid) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		Student student = studentDao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student newStudent) {
		StudentDao studentDao = StudentDaoFactory.getStudentDao();
		String status = studentDao.update(newStudent);
		return status;
	}

	@Override
	public String deleteStudent(String sid) 
	 {
			StudentDao studentDao = StudentDaoFactory.getStudentDao();
			String status = studentDao.delete(sid);
			return status;
		}
}
