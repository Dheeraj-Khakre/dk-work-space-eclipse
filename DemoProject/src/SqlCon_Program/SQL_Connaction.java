package SqlCon_Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SQL_Connaction {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
			String sql = "insert into person values(?,?,?,?,current_timestamp)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "dk mid night sly");
			ps.setInt(2, 21);
			// ps.setString(3,number);
			ps.setString(3, "a23a4@gmail.com");
			ps.setString(4, "sdfgwert");
			
	//	ps.setDate(5,new Date().getDate());
			int x = ps.executeUpdate();
			//System.out.println(x);
			if (x > 0)

				System.out.print(" person data added succefully");
			else {
				System.out.println(" person data not added");
			}
			ps.close();
			con.close();

		} catch (Exception e ) {

			e.getStackTrace();
		}

	}

}
