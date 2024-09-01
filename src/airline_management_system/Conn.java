package airline_management_system;
import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn(){
		try {
			
			// 1) register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2) download jar file - mysql connector
			
			// 3) create connection string
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","Ajay@1999");
			
			// 4) create Statement
			s = c.createStatement();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
// Connection establishment
//class Conn{
//	Connection c;
//	Statement s;
//	Conn(){
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			c = DriverManager.getConnection("jdbc:mysql:///db_name","username","password");
//			s = c.createStatement();
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//}
