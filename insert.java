import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@SuppressWarnings("unused")
public class insert {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
               
		      PreparedStatement psmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		      
		      while(true) {
		    	  System.out.print("Enter emp Id: ");
		    	  int emp_id=Integer.parseInt(br.readLine());
		    	  
		    	  System.out.print("Enter emp first Name: ");
		    	  String First_Name=br.readLine();
		    	  
		    	  System.out.print("Enter emp last Name: ");
		    	  String Last_Name=br.readLine();
		    	  
		    	  System.out.print("Enter emp Salary: ");
		    	  int Salary=Integer.parseInt(br.readLine());
		    	  
		    	  System.out.print("Enter emp Age: ");
		    	  int Age=Integer.parseInt(br.readLine());
		    	  
		    	  
		    	  psmt.setInt(1, emp_id);
		    	  psmt.setString(2, First_Name);
		    	  psmt.setString(3, Last_Name);
		    	  psmt.setInt(4, Salary);
		    	  psmt.setInt(5, Age);
		    	  
		    	  
		    	  int count=psmt.executeUpdate();
		    	  if(count>0)
		    		  System.out.println(count+"record Inserted..");
		    	  else
		    		  System.out.println("no record Inserted..");
		    	  
		    	  System.out.println("Do you want to more record[Yes/No] ");
		    	  String ch=br.readLine();
		    	  if(ch.equalsIgnoreCase("no"))
		    	  break;
		    	  
		      }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}