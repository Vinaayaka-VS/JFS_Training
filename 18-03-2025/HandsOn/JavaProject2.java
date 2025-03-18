package SignupBackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JavaProject2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/usermail";
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "root");
			Statement st = conn.createStatement();
			
			System.out.println("Enter the gmail: ");
			String gmail = sc.next();
			
			System.out.println("Enter the password: ");
			String password = sc.next();
			
			System.out.println("Enter the password again: ");
			String repeatpassword = sc.next();
			
			if(password.equals(repeatpassword)){
				String query = "INSERT INTO userdata(gmail,passkey) VALUES ("+"\"" + gmail +"\""+ "," + "\"" +password +"\""+")";
				
				int lines = st.executeUpdate(query);
				if(lines > 0){
					System.out.println("User registration Successful");
				}
				else{
					System.out.println("User registration Failed");
				}
			}
			else{
				System.out.println("Passwords do not match!");
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
