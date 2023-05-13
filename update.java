import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update {

	public static void main(String[] args) {
		String value;
		int eid;
		int age;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
            Statement smt=con.createStatement();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter emp Id: ");
            value=br.readLine();
            eid=Integer.parseInt(value);
            
            System.out.print("Enter emp Age: ");
            value=br.readLine();
            age=Integer.parseInt(value);
            
            int count=smt.executeUpdate("update emp set Age="+age+" where emp_id="+eid);
	    	  if(count>0)
	    		  System.out.println(count+"Rows Updated..");
	    	  else
	    		  System.out.println("no record found..");
            
		}catch(Exception e) {
			
			System.out.println(e);
		}

	}

}