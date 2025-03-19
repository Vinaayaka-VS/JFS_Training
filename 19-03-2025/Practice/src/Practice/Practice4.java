package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Practice4 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectdb";
		String query = "SELECT * FROM users WHERE userid = ?;";
		
		try{
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established!");
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 1000);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt("userid") + " " + rs.getString("username") + " " + rs.getString("gmail") + " " + rs.getString("userpass"));
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
