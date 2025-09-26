package com.nandini.factory;

import com.nandini.dao.StudentDao;
import com.nandini.dao.StudentDaoImpl;

public class StudentDaoFactory {
      private static StudentDao studentDao;
      static {
    	  studentDao=new StudentDaoImpl();
      }
      public static StudentDao getStudentDao() {
    	  return studentDao;
      }
}
