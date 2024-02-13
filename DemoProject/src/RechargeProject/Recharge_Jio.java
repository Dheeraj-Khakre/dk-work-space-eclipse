package RechargeProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.Period;

import java.time.temporal.Temporal;
import java.util.HashMap;

import java.util.Scanner;

public class Recharge_Jio {
	static Scanner sc = new Scanner(System.in);

	public static String isValidNo() {
		System.out.println("enter your mobile number ");
		String number = sc.next();
		if (number.length() == 10) {
			return number;

		} else {
			System.out.println("invailid number please enter right no.");
			return isValidNo();
		}

	}

	public static void main(String[] args) {

		String number = isValidNo();
		System.out.println("enter your plan to recharge your mobile");
		System.out.println("rs = 249rs validity 28 day / 1 gb/day unlimited calling ");
		System.out.println("rs = 569rs validity 56 day / 1.5 gb/day unlimited calling ");
		System.out.println("rs = 749rs validity 84 day / 2 gb/day unlimited calling ");
		System.out.println("rs = 3000rs validity 1 year / 3 gb/day unlimited calling ");
		System.out.println("enter your plan in rupees ");

		float price = sc.nextInt();
		int day = 0;
		String date = "";

		if (price == 249) {

			Period period = Period.ofDays(28);
			Temporal t = period.addTo(LocalDateTime.now());

			// System.out.println("Your validity :" + t);
			day = 28;
			date = t.toString();
			System.out.println(date);

		} else if (price == 569) {
			Period period = Period.ofDays(56);
			Temporal t = period.addTo(LocalDateTime.now());
			// System.out.println("Your validity :" + t);
			day = 56;
			date = t.toString();

		} else if (price == 749) {
			Period period = Period.ofDays(84);
			Temporal t = period.addTo(LocalDateTime.now());
			// System.out.println("Your validity :" + t);
			day = 84;
			date = t.toString();

		} else if (price == 3000) {
			Period period = Period.ofYears(1);
			Temporal t = period.addTo(LocalDateTime.now());
			// System.out.println("Your validity :" + t);
			day = 365;
			date = t.toString();

		} else {
			System.out.println("your enter wronge inputr please try again");
			Recharge_Jio.main(null);
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
			String select = "select number , day,date2 from recharge ";
			PreparedStatement ps = con.prepareStatement(select);

			ResultSet rs = ps.executeQuery();
			HashMap<String, String> hm = new HashMap<String, String>();

			while (rs.next()) {
				hm.put(rs.getString("number"), rs.getString("date2"));
			}
			if (hm.containsKey(number)) {

				System.out.println("your recharge allreadydone ");
				System.out.println("your vailidity is : " + hm.get(number));
			} else {
				String sql1 = "insert into recharge(number,amount,date2,day) values(?,?,?,?)";

				ps = con.prepareStatement(sql1);
				ps.setString(1, number);
				ps.setFloat(2, price);
				ps.setString(3, date);
				ps.setInt(4, day);
				int x = ps.executeUpdate();
				if (x > 0) {
					System.out.println("recharge done  of this number : " + number);
					System.out.println("Your validity :" + date);
				} else {
					System.out.println("recharge isnot done");
				}
			}

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.getMessage();
			// a.getMessage();

		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
	}

}
