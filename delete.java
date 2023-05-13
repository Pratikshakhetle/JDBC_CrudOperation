import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
            Statement smt=con.createStatement();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    
            while(true) {
		    	  System.out.print("Enter Deletion emp Id: ");
		    	  int emp_id=Integer.parseInt(br.readLine());
		    	  
		    	  int count=smt.executeUpdate("delete from emp where emp_id="+emp_id);
		    	  if(count==1)
		    		  System.out.println(count+"record Deleted....");
		    	  else
		    		  System.out.println("no record Deleted..");
		    	  
		    	  System.out.println("Do you want to Delete more record[Yes/No] ");
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