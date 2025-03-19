package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectdb";
		String query = "INSERT INTO users(username,gmail,userpass) VALUES (?,?,?);";
		
		try {
			Connection conn = DriverManager.getConnection(url,"root","root");
			System.out.println("Connection Established!");
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "Varun");
			ps.setString(2, "varunk@gmail.com");
			ps.setString(3, "V4run@66");
		
			int rows = ps.executeUpdate();
			System.out.println(rows + "row(s) affected");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
