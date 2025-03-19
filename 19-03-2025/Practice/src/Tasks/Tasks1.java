package Tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Tasks1 {
	public static void main(String[] args){
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventData", "root", "root");
			
			System.out.println("Welcome to Culturals Event Registration!");
			System.out.println("1. Create New User");
			System.out.println("2. Edit Existing User Details");
			System.out.println("3. Delete User");
			
			System.out.println("Enter your option: ");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1:
				String query1 = "INSERT INTO userdata(collegename,eventname,participant1,participant2,participant3,participant4,mail,teamname) VALUES (?,?,?,?,?,?,?,?);";
				String query2 = "SELECT regno FROM userdata WHERE mail = ?;";
				PreparedStatement ps = conn.prepareStatement(query1);
				PreparedStatement ps2 = conn.prepareStatement(query2);
				
				System.out.println("Enter your college name: ");
				String collegename = sc.nextLine();
				ps.setString(1,collegename);
				
				System.out.println("Enter your event name: ");
				String eventname = sc.nextLine();
				ps.setString(2,eventname);
				
				System.out.println("Enter number of participants[Max-4]: ");
				int count = sc.nextInt();
				sc.nextLine();
				
				for(int i = 3; i < 3 + count; i++){
					System.out.println("Enter Participant Name: ");
					String name = sc.nextLine();
					ps.setString(i, name);
				}
				
	            for (int i = count; i < 6; i++) {
	                ps.setString(i + 3, null);
	            }
				
				System.out.println("Enter your mail id: ");
				String mail = sc.nextLine();
				ps.setString(7,mail);
				
				System.out.println("Enter your team name: ");
				String teamname = sc.nextLine();
				ps.setString(8,teamname);
				
				int rows = ps.executeUpdate();
				
				if(rows != 0){
					System.out.println("Registration Successful");
					ps2.setString(1, mail);
					ResultSet rs = ps2.executeQuery();
					while(rs.next()){
						System.out.println("Your Registration Number is " + rs.getInt(1));
					}
				}
				else{
					System.out.println("Registration Failed");
				}
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			default:
				System.out.println("Kindly choose from the range [1-3]");
				break;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}
}
