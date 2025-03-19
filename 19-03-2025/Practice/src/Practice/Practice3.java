package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice3 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectdb";
		String query = "UPDATE users SET username = ?, gmail = ?, userpass = ? WHERE userid = ?;";
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established!");
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "p+arikishore");
			ps.setString(2, "paripari@gmail.com");
			ps.setString(3, "pari@varun<3");
			ps.setInt(4, 1000);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
