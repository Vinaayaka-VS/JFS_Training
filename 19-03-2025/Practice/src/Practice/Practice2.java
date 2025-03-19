package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectdb";
		String query = "DELETE FROM users WHERE userid = ?";
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established!");
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 1005);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "row(s) affected");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
