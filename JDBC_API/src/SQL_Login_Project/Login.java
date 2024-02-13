package SQL_Login_Project;



import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;



public class Login {
	static Scanner sc = new Scanner(System.in);

	static Connection getcon() throws SQLException ,ClassNotFoundException{

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/dk","root","zxcvbnm#321");
	    return con;
	}

	public static void main(String[] args) {
		System.out.println("are you new user or exiting user  ");
		System.out.println("if  new usre  than type yes orther wise no ");
		String user = sc.next();
		if (user.equals("yes")) {
			login();
		} else {

			sign();
		}

	}

	private static void sign() {
		System.out.println("enter your detail here one by one : ");
		System.out.println("Enter First  Name :");
		String Fname = sc.next();
		System.out.println("Enter last  Name :");
		String Lname = sc.next();
		       
		System.out.println("Enter  Email :");
		String email = sc.next();

		System.out.println("Enter  Number :");
		String number = sc.next();
		System.out.println("Enter  Birth Date :");
		System.out.println(" in this format:  dd-MM-yyyy");
		String dob = sc.next();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dob, dtf);
		Date DOB = Date.valueOf(date);
		System.out.println("Enter  Password :");
		String password = sc.next();

		System.out.println("Re-Enter Password  :");
		String password2 = sc.next();
		System.out.println("Enter  Country :");
		String country = sc.next();
		System.out.println("Enter  City :");
		String city = sc.next();
		// chacking all detail are right or not ok ...to be continue...
		if (number.length() != 10) {
			System.out.println("number is not valid please re-enter");
			number = sc.next();
		}
		if (!(password.equals(password2))) {
			System.out.println("password not match of conform password");
			System.out.println("Enter  Password :");
			password = sc.next();

			System.out.println("Re-Enter Password  :");
			password2 = sc.next();

		}
		String sql = "insert into users values(?,?,?,?,?,?,?,?,current_timestamp)";
		


		try {

			////Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
			Connection con = getcon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Fname);
			ps.setString(2, Lname);
			ps.setString(3, email);
			ps.setString(4, number);
			ps.setDate(5, DOB);
			ps.setString(6, password);
			ps.setString(7, country);
			ps.setString(8, city);
			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("user has created ");
				succefullLogin(email);
			} else {
				System.out.println("user not create please Re - Enter  all information");
				sign();
			}
		} catch (SQLException  | ClassNotFoundException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
			
		}

	}

	private static void login() {
		try {
			
			String sql = "select * from users";

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
			PreparedStatement ps = con.prepareStatement(sql);


			ResultSet result = ps.executeQuery();
			HashMap<String, String> hm = new HashMap<String, String>();
			while (result.next()) {
				//System.out.println(result.getString("email"));
			//	System.out.println(result.getString("password"));
				hm.put(result.getString("email"), result.getString("password"));
			}
			System.out.println("enter your email or number ");
			String email_Or_Number = sc.next();
			
			if (EmailValidator.isValidEmail(email_Or_Number)) {
			//	System.out.println(hm);
			//	System.out.println(hm.containsKey(email_Or_Number));
				if (hm.containsKey(email_Or_Number)) {
					System.out.println("enter your password here");
					String pasword =sc.next();
					if (hm.get(email_Or_Number).equals(pasword)) {
						System.out.println("Welcome to dk midnight world ");
						succefullLogin(email_Or_Number);
					}
				}
			} else if (email_Or_Number.length() == 10) {
				while (result.next()) {
					hm.put(result.getString("number"), result.getString("password"));
				}
				if (hm.containsKey(email_Or_Number)) {
					System.out.println("enter your password here");
					String pasword =sc.next();
					if (hm.get(email_Or_Number).equals(pasword)) {
						System.out.println("Welcome to dk midnight world ");
						succefullLogin(email_Or_Number);
					}
				}

			}
		else {
				System.out.println(" email is in valid of format please enter valid email or number ");
				System.out.println("go to sign page enter 1 ");
				System.out.println("go to again login page enter 2 ");
				int x = sc.nextInt();
				if (x == 1)
					sign();
				else {
					login();
				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void succefullLogin(String email) {
		System.out.println("thank you for vigiting ");
		System.out.println("do you wanna to see your information ");
		System.out.println("enter yes");
		String yes = sc.next();
		if (yes.equalsIgnoreCase("yes")) {
			
			try {
				String sql = "select * from users where email=?";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "zxcvbnm#321");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, email);
                 ResultSet result = ps.executeQuery();
				while (result.next()) {
					System.out.println("your name : " + result.getString("Fname")+" "+result.getString("Lname") );
					System.out.println("your Email : " + result.getString("email"));
					System.out.println("your number : " + result.getString("number"));
					System.out.println("your birth date : " + result.getString("DOB"));
					System.out.println("your password : " + result.getString("password"));
					System.out.println("your  country: " + result.getString("country"));
					System.out.println("your city  : " + result.getString("city"));
					System.out.println(" ------------------//------------------------");
					System.out.println("do your wanna to change any information ");
					System.out.println("enter yes");
					if (sc.next().equalsIgnoreCase("yes"))
						update_Info();
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("you not enter yes ");
			succefullLogin(email);

			// System.out.println("if you wana to change please login again ...");
		}

		// showinh all detai of user...

	}

	private static void update_Info() {
		// TODO Auto-generated method stub
		System.out.println("enter what you wanna to change ");
		// work  in progras...
		

	}

}
