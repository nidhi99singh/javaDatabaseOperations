import java.sql.*;
import java.util.*;
public class DatabaseEmp {
   //1. Insertion Operation
    void InsertEmp(int eid,String fname,String lname,int age,int salary,String city,int did){
         try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="insert into employee values(?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,eid);
                        stmt.setString(2,fname);
                         stmt.setString(3,lname);
                         stmt.setInt(4,age);
                         stmt.setInt(5,salary);
                          stmt.setString(6,city);
                          stmt.setInt(7,did);
			int i=stmt.executeUpdate();
			if(i==1)
                        {
                            System.out.print("Data Inserted Successfully");
                        }else{
                            System.out.print("Data Insertion unSuccessful");
                        }            
            }catch(Exception ex){
		System.out.println(ex);
                }   
        }
    //2.  Select operation
    void display(int id)	
            {
                try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="select * from employee where e_id=?";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,id);
             
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Emp_Id:"+rs.getInt(1)+"\nF_Name:"+rs.getString(2)+"\nL_name:"+rs.getString(3)+"\nAge:"+rs.getInt(4)+"\nSalary:"+rs.getInt(5)+"\nCity:"+rs.getString(6)+"\ndep_id:"+rs.getInt(7));
				
			}
	}catch(Exception ex){
		System.out.println(ex);
	}
	}
    //3.  Insertion in Department table
    void AddDepart(int did,String dname,String dcity){
        try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="insert into depart values(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,did);
                        stmt.setString(2,dname);
                         stmt.setString(3,dcity);
			int i=stmt.executeUpdate();
			if(i==1)
                        {
                            System.out.print(" Department data Inserted Successfully");
                        }else{
                            System.out.print("Data Insertion unSuccessful");
                        }            
            }catch(Exception ex){
		System.out.println(ex);
                }   
        
    }
        // 4. delete Operation
    void Delete(int eid){
             try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="delete from employee where e_id=?";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,eid);
			stmt.execute();            
                }catch(Exception ex){
		System.out.println(ex);
                }
        }
    //5. Update Operation
    void UpdateEmp(int eid,int salary){
        try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="update employee set salary=? where e_id=?";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,salary);
                        stmt.setInt(2,eid);
			int i=stmt.executeUpdate();
                        if(i==1){
                            System.out.println("Update Successful");
                        }
                        else{
                            System.out.println(" UnSuccessful Update");
                        }
                }catch(Exception ex){
		System.out.println(ex);
                }
    }
    //6. Display multiple rows data
    void ShowData(int did){
        try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iot83","root","nidhi@091296");	
                        String st="select * from employee where dep_id=?";
			PreparedStatement stmt=con.prepareStatement(st);
                        stmt.setInt(1,did);
			ResultSet rs=stmt.executeQuery();
			   while(rs.next())
                            {
				System.out.println("Emp_Id:"+rs.getInt(1)+"\nF_Name:"+rs.getString(2)+"\nL_name:"+rs.getString(3)+"\nAge:"+rs.getInt(4)+"\nSalary:"+rs.getInt(5)+"\nCity:"+rs.getString(6)+"\ndep_id:"+rs.getInt(7));	
                            }
                       
	}catch(Exception ex){
		System.out.println(ex);
	}
    }
    public static void main(String[] args) {
       DatabaseEmp emp=new DatabaseEmp();
       Scanner sc=new Scanner(System.in);
       System.out.println("1:to insert Employee data\n 2: to display Employee data\n 3: delete Employee data\n 4:update Employee data\n5:Get first 10 employee details\nEnter Choice: ");
       int ch=sc.nextInt();
       if(ch==1)
       {
          System.out.println("Do you Belong to existing department y/n:");
          String s=sc.next();
            if(s.equals("n")){
                System.out.println("Add department First");
                    System.out.println("Enter dep_id");
                        int did=sc.nextInt();
                    System.out.println("Enter Dept Name");
                        String dname=sc.next();
                    System.out.println("Enter Dept City");
                        String dcity=sc.next();
                emp.AddDepart(did,dname,dcity);  
            }
                    System.out.println("enter E_id");
                        int eid=sc.nextInt();
                    System.out.println("Enter F_name");
                        String fname=sc.next();
                    System.out.println("Enter L_name");
                        String lname=sc.next();
                    System.out.println("Enter Age");
                        int age=sc.nextInt();
                    System.out.println("Enter Salary");
                        int salary=sc.nextInt();
                    System.out.println("Enter City");
                        String city=sc.next();
                    System.out.println("Enter dep_id");
                        int did=sc.nextInt();
                emp.InsertEmp(eid,fname,lname,age,salary,city,did);
        
       }
       else if(ch==2){
                System.out.println("Enter emp id");
                int e_id=sc.nextInt();
                emp.display(e_id);    
            }
       else if(ch==3){
                System.out.println("Enter emp id");
                int e_id=sc.nextInt();
                emp.Delete(e_id);    
            }
       else if(ch==4){
                System.out.println("Enter emp id to Update Name:");
                int e_id=sc.nextInt();
                System.out.println("Enter new Salary:");
                int sal=sc.nextInt();
                emp.UpdateEmp(e_id,sal);           
       }
       else if(ch==5){
                System.out.println("Enter depart id:");
                int did=sc.nextInt();
                emp.ShowData(did);
       }
       else{
                System.out.println("Invalid Coice");
            }
    }
    
}
 