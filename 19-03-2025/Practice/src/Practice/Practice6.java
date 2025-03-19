package Practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.w3c.dom.CDATASection;

public class Practice6 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/projectdb";
		
		try{
			Connection conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Established!");
			
			DatabaseMetaData metainfo = conn.getMetaData();
			
			System.out.println(metainfo.getDriverName());
			System.out.println(metainfo.getDriverVersion());
			System.out.println(metainfo.getUserName());
			System.out.println(metainfo.getDatabaseProductName());
			System.out.println(metainfo.getDatabaseProductVersion());
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
