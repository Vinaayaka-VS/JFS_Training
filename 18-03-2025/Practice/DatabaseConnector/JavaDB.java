package DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDB {
	public static void main(String[] args){
		String query = "SELECT * FROM userdata";
		String url = "jdbc:mysql://localhost:3306/usermail";
		String user = "root";
		String logpassword = "root";
		
		try{
			Connection con = DriverManager.getConnection(url, user, logpassword);
			System.out.println("Connection Established Successfully");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				int id = rs.getInt("userid");
				String email = rs.getString("gmail");
				String password = rs.getString("passkey");
				
				System.out.println(id + " " + email + " " + password);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
