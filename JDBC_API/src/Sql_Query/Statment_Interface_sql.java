package Sql_Query;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
  



public class Statment_Interface_sql {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306","root","zxcvbnm#321");

        Statement st = con.createStatement();
        st.execute("create database if not exists dk");
        st.execute("use dk");
       // st.execute("create table if not exists emp(id int , ename varchar(20),yoe int ,sal float)");
       // st.execute("insert into emp values (103,'the dark knight',8,25000)");
      //  System.out.println("insert data  successfully ");
        ResultSet res= st.executeQuery("select * from emp");
        while(res.next()) {
       
        	System.out.println("employee id : "+res.getInt("id"));
        	System.out.println("employee eame : "+res.getString("ename"));
        	System.out.println("employee year of experiance : "+res.getInt("yoe"));
        	System.out.println("employee salary : "+res.getFloat("sal"));
         	System.out.println("--------***----------------------***------");
        }
        st.close();
        con.close();
        
        
	}

}
