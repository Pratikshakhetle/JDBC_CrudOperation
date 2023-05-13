import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connect
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Establishing Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");

			if (con != null)			
				System.out.println("Connected");		
			else		
				System.out.println("Not Connected");
			
			Statement smt=con.createStatement();
			
			smt.executeUpdate("create table employee(emp_id number,First_Name varchar2(20),Last_Name varchar2(20),Salary number,Age number)");
			System.out.print("Table created sucessfully....");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}