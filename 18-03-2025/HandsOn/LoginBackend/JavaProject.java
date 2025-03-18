package LoginBackend;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaProject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the gmail: ");
//		String enteredMail = sc.next();
//		
//		String query = "SELECT * FROM userdata WHERE gmail =" + "\"" + enteredMail +"\"";
		String url = "jdbc:mysql://localhost:3306/usermail";
		
		try{
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established Successfully");
			
			System.out.println("Enter the gmail: ");
			String enteredMail = sc.next();
			
			String query = "SELECT * FROM userdata WHERE gmail =" + "\"" + enteredMail +"\"";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				String pass = rs.getString("passkey");
				String userName = enteredMail.split("@")[0];
				System.out.println("Enter the password: ");
				String enteredPass = sc.next();
				
				if(enteredPass.equals(pass)){
					System.out.println("Welcome Back! User " + userName + "!");
				}
				else {
					System.out.println("Incorrect Password!");
				}
			}
			else {
				System.out.println("User does not exist");
			}
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
