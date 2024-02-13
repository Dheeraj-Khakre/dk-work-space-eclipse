package Batch_Processing_SQL_Statment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class Batch_Processing {
	public static void main(String[] args) {
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/library","root", "zxcvbnm#321");

		Statement st = con.createStatement();
		st.addBatch("insert into books values (109,'ML','Maching learning ','Muharshy dk','maching learning algorithms',1999.23,899,current_timestamp)");
		st.addBatch("insert into books values (110,'DL','deep learning','deep learning algorithms','dk mid night',1599.23,1000,current_timestamp)");
		st.addBatch("insert into books values (111,'AI',' AI transformation level 4 and 5  ','ELON Musk 2.0','AI Transformation',2599.23,899,current_timestamp)");
		st.executeBatch();
		System.out.println("add book sucessfull ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /*id int primary key,
		bname varchar(50) not null,
		title varchar(60) not null,
		author_name varchar(30) not null,
		johner varchar(50) not null,
		bprice float,
		no_of_page*/
	}

}
