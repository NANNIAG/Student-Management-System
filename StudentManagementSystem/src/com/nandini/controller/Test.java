package com.nandini.controller;

import java.util.Scanner;

import com.nandini.dto.Student;
import com.nandini.service.StudentService;
import com.nandini.service.StudentServiceFactory;

public class Test {

	public static void main(String[] args) {
		Scanner sc = null;
		System.out.println("============================");
		System.out.println("Student Management System!!");
		System.out.println("============================");
		try {
			sc = new Scanner(System.in);
			String sid = "";
			String sname = "";
			String saddr = "";
			String status = "";
			Student student = null;
			StudentService studentService = StudentServiceFactory.getStudentService();
			while (true) {
				System.out.println();
				System.out.println("1. Add Student");
				System.out.println("2. Search Student");
				System.out.println("3. Update Student");
				System.out.println("4. Delete Student");
				System.out.println("5. Exit");
				System.out.println("Your Option : ");
				int option = sc.nextInt();
				sc.nextLine();
				switch (option) {

				case 1:
					System.out.println("Student ID : ");
					sid = sc.nextLine();
					System.out.println("Student Name : ");
					sname = sc.nextLine();
					System.out.println("Student Address : ");
					saddr = sc.nextLine();
					student = new Student();
					student.setSid(sid);
					student.setSname(sname);
					student.setSaddr(saddr);
					status = studentService.addStudent(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Status : Student Added Successfully");
					}
					if (status.equalsIgnoreCase("existed")) {
						System.out.println("Status : Student Already Existed");
					}
					if (status.equalsIgnoreCase("failure")) {
						System.out.println("Status : Student Insertion Failure");
					}

					break;
				case 2:
					System.out.print("Student Id    : ");
					sid = sc.nextLine();
					student = studentService.searchStudent(sid);
					if (student == null) {
						System.out.println("Status   : Student Not Existed");
					} else {
						System.out.println("Status   : Student Existed");
						System.out.println("Student Details");
						System.out.println("------------------");
						System.out.println("Student Id      : " + student.getSid());
						System.out.println("Student Name    : " + student.getSname());
						System.out.println("Student Address : " + student.getSaddr());
					}

					break;
				case 3:
					System.out.print("Student Id    : ");
					sid = sc.nextLine();
					student = studentService.searchStudent(sid);
					if (student == null) {
						System.out.println("Status  : Student Not Existed");
					} else {
						System.out.print("Student Name [Old : " + student.getSname() + "] New : ");
						sname = sc.nextLine();
						System.out.print("Student Address [Old : " + student.getSaddr() + "] New : ");
						saddr = sc.nextLine();

						Student newStudent = new Student();
						newStudent.setSid(sid);
						newStudent.setSname(sname);
						newStudent.setSaddr(saddr);
						status = studentService.updateStudent(newStudent);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Status  : Student Updated Successfully");
						}
						if (status.equalsIgnoreCase("failure")) {
							System.out.println("Status  : Student Updation Failure");
						}

					}

					break;

				case 4:
					System.out.print("Student Id    : ");
					sid = sc.nextLine();

					status = studentService.deleteStudent(sid);

					if (status.equalsIgnoreCase("success")) {
						System.out.println("Status  : Student Deleted Successfully");
					}
					if (status.equalsIgnoreCase("failure")) {
						System.out.println("Status  : Student Deletion Failure");
					}
					if (status.equalsIgnoreCase("notexisted")) {
						System.out.println("Status  : Student Not Existed");
					}

					break;

				case 5:
					System.out.println("ThankYou for using Student Management System !!");
					System.exit(0);
					break;
				default:
					System.out.println("YOU SELECTED AN INVALID OPTION !");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
