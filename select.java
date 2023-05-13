import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class select {

	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery("select * from employee");
            
            while(rs.next()) {
            	int emp_id=rs.getInt(1);
            	String First_Name=rs.getString(2);
            	String Last_Name=rs.getString(3);
            	int Salary=rs.getInt(4);
            	int Age=rs.getInt(5);
            	
            	
            	System.out.println("Emp Id: "+emp_id);
            	System.out.println("Emp First Name: "+First_Name);
            	System.out.println("Emp First Name: "+Last_Name);
            	System.out.println("Emp Salary: "+Salary);
            	System.out.println("Emp Age: "+Age);
            	
            }
			
				
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}