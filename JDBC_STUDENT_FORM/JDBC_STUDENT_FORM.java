package JDBC_STUDENT_FORM;

import java.util.Scanner;

public class JDBC_STUDENT_FORM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CURD_OP ob=new CURD_OP();
		
	
         
		int ch;
		do {
			System.out.println("ENTER UR CHOICE BUDDY !!\n");
			System.out.println("==================================\n");

			System.out.println("1 ENTER TO INSERT UR DATA");
			System.out.println("2 ENTER TO DIAPLAY DATA");
			System.out.println("3 ENTER TO UPDATE UR DATA");
			System.out.println("4 ENTER TO DELETE DATA");
			System.out.println("5 FOR EXIT\n\n");
			System.out.println("==================================\n");
			
			ch = sc.nextInt();
		

				switch (ch) 
				{
					
				case 1:	 ob.insert_Data(); break;
				case 2:  ob.dispaly_data(); break;
				case 3:  ob.update_Data();  break;
				case 4:  ob.delete_data();  break;
				default :
					System.out.println("THANK YOU FOR APPROCHING !!");
				}
		} while (ch < 5);
		
		
	}
}
