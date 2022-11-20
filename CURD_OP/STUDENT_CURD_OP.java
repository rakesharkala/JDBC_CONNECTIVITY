package JDBC_;

import java.util.Scanner;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.awt.geom.Arc2D.Double;
import java.sql.*;

public class STUDENT_CURD_OP 
{
	Scanner sc=new Scanner(System.in);
	POJO o=new POJO();

	public static void main(String[] args)
	{
		
	//	POJO o=new POJO();
		STUDENT_CURD_OP ob=new STUDENT_CURD_OP();
		
		Scanner sc=new Scanner(System.in);
		int ch = 0;
		
		do {
			System.out.print("ENTER UR CHOICE :  ");
			System.out.println("\n==========================\n");
			
			System.out.println("1 FOR INSERT   : ");
			System.out.println("2 FOR DISPLAY  : ");
			System.out.println("3 FOR UPDATE   : ");
			System.out.println("4 FOR DELETE   : ");
			System.out.println("5 EXIT");
			ch=sc.nextInt();
			
			switch (ch)
			{
			case 1:
				ob.insertData();
				break;
			case 2:
			    ob.displayData();
			    break;
			case 3:
				ob.updateData();
				break;
				
			case 4:
				ob.deleteData();
				break;
			default :
				System.out.println("THANK YOU VISIT AGAIN ");
			
				
			}
		}
			while (ch<5);
		}
			
			public Connection getConnect() {                 // method to avoid rewritting first 2steps
			
			try
			{
				
				String url="jdbc:mysql://localhost:3306/student_info";     
				String uname="root";
				String pass="7032248200@Aa";                                                //this common to all steps
				
				Class.forName("com.mysql.cj.jdbc.Driver");                                  //2nd step loading drivers nd register
				Connection con=DriverManager.getConnection(url,uname,pass);					//3rd create connection							//forname responsible for load
			
//				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//				Connection con=DriverManager.getConnection("jdbc.mysql://localhost/3306/student_info","root","7032248200@Aa");
				
				return con;
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
			
	}
			public  void insertData()
			{
				
				System.out.println("ENTER COURSE NAME  : ");
				String c_name =sc.next();
				o.setC_name(c_name);
				
				System.out.println("ENTER COURSE ID    : ");
				double cid=sc.nextDouble();
				o.setC_id(cid);
				
				System.out.println("ENTER COURSE FEE   : ");
				double cfee=sc.nextDouble();
				o.setC_fee(cfee);
				
				System.out.println("ENTER COURSE STRUCTURE :");
				String s=sc.next();
				o.setC_struct(s);
				System.out.println("\n\n");
				
				try {
				    Connection con=getConnect();
				    PreparedStatement ps=con.prepareStatement("insert into data(C_NAME,C_ID,C_FEE,C_STRUCT)values (?,?,?,?)");
				    
				    ps.setString(1, o.getC_name());
				    ps.setDouble(2,o.getC_id());
				    ps.setDouble(3,o.getC_fee());
				    ps.setString(4,o.getC_struct());
				    
				    int x=ps.executeUpdate();
				    
				    ps.close();
				    con.close();
				    if(x==1) {
				    	System.out.println("UR DATA INSERTED SUCCESFULLY !!\n\n");
				    }
				    
					
					
				} catch (Exception e) {
					System.out.println("error");
					e.printStackTrace();
				}
			}
			public  void displayData()               // to display data
			{
				try {
					Connection con=getConnect();
					PreparedStatement pt=con.prepareStatement("select * from data");
					
					ResultSet rs=pt.executeQuery();           // retrive
					
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4));
					}
					rs.close();
					pt.close();
					con.close();
					
				} catch (Exception e) {
					System.out.println("invalid");
					e.printStackTrace();
				}	
				
				
				
			}	
			public void deleteData()
			{
				System.out.print("ENTER ID TO DELETE THAT RECORD : ");
				double id =sc.nextDouble();
				try {
					Connection con=getConnect();
					
					PreparedStatement pt=con.prepareStatement("delete from data where C_ID=?");
					pt.setDouble(1, id);
					
					int x=pt.executeUpdate();
					if(x==1) {
						System.out.println("RECORD DELETED");
					}
					else {
						System.out.println("RECORD NOT FOUND \n\n");
					}
					pt.close();
					con.close();
					
					
				} catch (Exception e) {
				   e.printStackTrace();
				}
				
				
			}
			public  void updateData()
			{
				
				System.out.println("ENTER ID :");
				double id=sc.nextDouble();
				o.setC_id(id);
				
				
				System.out.println("ENTER NAME : ");
				String name =sc.next();
				o.setC_name(name);
				
				System.out.println("ENTER THE COURSE FEE :  ");
				double fee=sc.nextDouble();
				o.setC_fee(fee);
				
				
				System.out.println("COURSE STRUCTURE  :  ");
				String s=sc.next();
				o.setC_struct(s);
				
				try {
					String str="update data set C_NAME =?,C_FEE=?,C_STRUCT";
					Connection con =getConnect();
					PreparedStatement pt=con.prepareStatement(str);
					
					pt.setDouble(0, id);
					pt.setString(1,o.getC_name() );
					pt.setDouble(2,o.getC_fee());
					pt.setString(3, o.getC_struct());
				   
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
				
		
}
