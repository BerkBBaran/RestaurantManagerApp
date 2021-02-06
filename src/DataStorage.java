import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataStorage {

	public Connection con;
	public String connectionURL="jdbc:mysql://localhost:3306/hms?serverTimezone=UTC"; 
	public String username="root";  //Type your MYSQL username
	public String password="password"; //Type your MYSQL password
	private ResultSet rs;
	
	
	public ResultSet readData(String SqlQuery) throws SQLException {  //Just write to query then it will give you result set

		try {
		    con =
		       DriverManager.getConnection(connectionURL,username,password);
		    Statement stmt  = con.createStatement();
			rs=stmt.executeQuery(SqlQuery);
			  
			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				con.close();			 //close connection
			}
			return rs;
	}
	public void writeData(Person P) throws FileNotFoundException, IOException, SQLException {
		try {
		    con =
		       DriverManager.getConnection(connectionURL,username,password);

			PreparedStatement ps = con.prepareStatement("INSERT INTO person (id,name,date_of_birth) VALUES (?, ?, ?)");
			
			ps.setInt(1, P.getId());
			ps.setString(2, P.getName());	
			ps.setString(3, P.getDateOfBirth().toString());
			ps.executeUpdate();
			  
			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				con.close();
			}

		
		
	}
	
}
