package JDBC_STUDENT_FORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CURD_OP {
	POJO o=new POJO();
	JDBC_connection ob=new JDBC_connection();
	
	Scanner sc=new Scanner(System.in);
	public void insert_Data()
	{
		System.out.println("\nENTER ur ID  : ");
		int  id =sc.nextInt();
		o.setId(id);
		
		System.out.println("ENTER UR NAME    : ");
		String name=sc.next();
		o.setName(name);

		
		System.out.println("ENTER UR COURSE U HAVE TO ENROLL : ");
		String c=sc.next();
		o.setCourse(c);
		
		System.out.println("ENTER UR DATE OF JOINING :");
		String s=sc.next();
		o.setDoj(s);
		System.out.println("\n\n");
	
		
		try {
		    Connection con=ob.getconnect();
		    PreparedStatement ps=con.prepareStatement("insert into sdata(id,name,course,doj)values (?,?,?,?)");
		    
		    //"
		    
		    
		    ps.setInt(1, o.getId());
		    ps.setString(2,o.getName());
		    ps.setString(3,o.getCourse());
		    ps.setString(4,o.getDoj());
		    
		    int x=ps.executeUpdate();
		    
		    ps.close();
		    con.close();
		    if(x==1)
		    {
		    	System.out.println("UR DATA INSERTED SUCCESFULLY !!\n\n");
		    }
		    
			
			
		} catch (Exception e) {
			System.out.println("YOU NEED CHANGE SOMETHING YAAR");
			e.printStackTrace();
		}
	}

	public void dispaly_data() 
	{
		try {
			String str="select * from sdata";
			Connection con= ob.getconnect();
			PreparedStatement ps=con.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			System.out.println("========================================================");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"    "+rs.getString(2)+"     "+rs.getString(3)+"    "+rs.getString(4));
			}
			System.out.println("========================================================");
			rs.close();
			con.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("you need to change");
			e.printStackTrace();
		}
		
	}

	public void update_Data() 
	{
		System.out.println("ENTER ID :");
		int id=(int) sc.nextDouble();
		o.setId(id);
		
		System.out.println("ENTER ID :");
		int id1=(int) sc.nextDouble();
		o.setId(id1);
		
		
		
		System.out.println("ENTER NAME : ");
		String name =sc.next();
		o.setName(name);
		
		System.out.println("ENTER COURSE :  ");
		String c=sc.next();
		o.setCourse(c);
		
		
		System.out.println("COURSE DOJ  :  ");
		String s=sc.next();
		o.setDoj(s);
		
		try {
			String str="update sdata set id=?,name =?,course=?,doj=?";
			Connection con =ob.getconnect();
			PreparedStatement pt=con.prepareStatement(str);
			
			pt.setInt(0, id);
			pt.setString(1,o.getName() );
			pt.setString(2,o.getCourse());
			pt.setString(3, o.getDoj());
		   
			int x=pt.executeUpdate();
			
			pt.close();
			con.close();
			
			if(x==1) {
				System.out.println("RECORD UPDATED ");
			}
			else {
				System.out.println("DATA NOT FOUND AT INDEX");
			}

		} catch (Exception e) {
			e.printStackTrace();


		}
		
		
	}

	public void delete_data()
	{
		System.out.println("ENTER ID TO DELETE UR RECORD ");
		int id=sc.nextInt();
		o.setId(id);
		
		try {
			String str="delete from sdata where id=? ";
			Connection con= ob.getconnect();
			PreparedStatement ps=con.prepareStatement(str);
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			if(x==1) {
				System.out.println("DELETED SUCCESSFULLY");
			}
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DELETE NOT DONE");
		}
	}

	

	

}
