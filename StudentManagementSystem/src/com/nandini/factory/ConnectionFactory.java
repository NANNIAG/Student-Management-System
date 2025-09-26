package com.nandini.factory;
import java.sql.*;
public class ConnectionFactory {
     private static Connection con=null;
     static {
    	 try {
    		 Class.forName("oracle.jdbc.OracleDriver");
    		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
    	     	 
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     public static Connection getConnection() {
    	 return con;
     }
     public static void close()
     {
    	 try {
    		 
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
}
