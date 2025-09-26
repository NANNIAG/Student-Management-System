package com.nandini.service;

public class StudentServiceFactory
{
	private static  StudentService studentService;
	static{
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService(){
		return studentService;
	}
}
