package tender_manaement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
	 // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //  Database credentials
    private static final String USER = "postgres";
    private static final String PASS = "shimpa";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet resultSet = null;
    private static Scanner sc;
    
    
    public static void main(String arg[])
    {

        sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome Admin");
        while (!exit) {
            System.out.println("1.F1");
            System.out.println("2.F2");
            System.out.println("3.F3");
            System.out.println("4.F4");
            System.out.println("5.F5");
            System.out.println("6.F6");
            System.out.println("7.F7");
            System.out.println("8.F8");
            System.out.println("9.F9");
            System.out.println("10.F10");
            System.out.println("11.F11");
            System.out.println("12.F12");
            System.out.println("13.F13");
            System.out.println("14.F14");
            System.out.println("15.F15");
            System.out.println("16.F16");
            System.out.println("17.F17");
            System.out.println("18.F18");
            System.out.println("19.F19");
            System.out.println("20.F20");
            System.out.println("21.F21");
            System.out.println("22.F22");
            System.out.println("23.F23");
            System.out.println("24.F24");
            System.out.println("25.F25");
            System.out.println("26.F26");
            System.out.println("27.F27");
            System.out.println("28.F28");
            System.out.println("29.F29");
            System.out.println("30.F30");
            System.out.println("31.EXIT");
            System.out.println("Select an option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                 f1();
                    break;
                case 2:
                	f2();
                    break;
                case 3:
                	f3();
                    break;
                case 4:
                	f4();
                	break;
                case 5:
                    f5();
                       break;
                   case 6:
                   	f6();
                       break;
                   case 7:
                   	f7();
                       break;
                   case 8:
                   	f8();
                   	break;
                   case 9:
                       f9();
                          break;
                      case 10:
                      	f10();
                          break;
                      case 11:
                      	f11();
                          break;
                      case 12:
                      	f12();
                      	break;
                     case 13:
                          f13();
                             break;
                       case 14:
                         	f14();
                             break;
                         case 15:
                         	f15();
                             break;
                         case 16:
                         	f16();
                         	break;
                         case 17:
                             f17();
                                break;
                            case 18:
                            	f18();
                                break;
                            case 19:
                            	f19();
                                break;
                            case 20:
                            	f20();
                            	break;
                            case 21:
                                f21();
                                   break;
                               case 22:
                               	f22();
                                   break;
                               case 23:
                               	f23();
                                   break;
                               case 24:
                               	f24();
                               	break;
                              case 25:
                                   f25();
                                      break;
                                  case 26:
                                  	f26();
                                      break;
                                  case 27:
                                  	f27();
                                      break;
                                  case 28:
                                  	f28();
                                  	break;
                                  case 29:
                                      f29();
                                         break;
                                     case 30:
                                     	f30();
                                         break;
                case 31:
                    exit = true;
                    break;

            }
        }}
    	
    
    private static void f1() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter 1 to view road tender, 2 to view pipeline tender, 3 to view water pipeline tenders:");
            int a=sc.nextInt();
            String did;
            if(a==1)
            {
            	did="RT%";
            }
            else if(a==2)
            {
            	did="PT%";
            }
            else
            {
            	did="WT%";
            }
            PreparedStatement pstmt = conn.prepareStatement("Select * from tender.r_engineer where tender_id like ?;");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1)+"                engineer_id :"+ resultSet.getString(2));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

            pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f2() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter 1 to view complete tenders and 2 to view ongoing");
            int a=sc.nextInt();
            String did;
            if(a==1)
            {
            	did="complete";
            }
            else
            {
            	did="ongoing";
            }
            PreparedStatement pstmt = conn.prepareStatement("Select tender_id  from tender.tender where status=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

            pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f3() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter machienary id :");
           String did = sc.next();
           System.out.println("enter model number  :");
           String a=sc.next();
           System.out.println("enter type  :");
           String b=sc.next();
           
        
            PreparedStatement pstmt = conn.prepareStatement("Insert into tender.machienary values (?,?,?)");
            pstmt.setString(1, did);
            pstmt.setString(2, a);
            pstmt.setString(3, b);
            
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1)+"                engineer_id :"+ resultSet.getString(2));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }

    private static void f4() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter department id to view all employees:");
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement(" Select ename,sdate,contact,salary from tender.employee where department_id=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("ename :" + resultSet.getString(1)+"   sdate :"+ resultSet.getString(2)+"   contact : "+resultSet.getString(3)+"  salary  : "+resultSet.getString(4));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f5() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
         //   System.out.println("Enter upload date:");
          
          //  Date did = sc.();
            PreparedStatement pstmt = conn.prepareStatement("Drop table employee");
           // pstmt.setDate(1,Date.valueOf(did));
            
           pstmt.executeUpdate();
       //     while (resultSet.next())
         //   {
          //      System.out.println("tender_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
           // }

           pstmt.close();
            //resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f6() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter tender id:");
        
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select contractor_id from tender.bids where tender_id=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("contractor_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f7() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter machienary_id to update:");
            
            String did = sc.next();
System.out.println("Enter machienary model to update:");
            
            String did1 = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Update tender.machienary set model=? where machienary_id=?");
           pstmt.setString(2, did);
           pstmt.setString(1, did1);
            
            pstmt.executeUpdate();
          //  while (resultSet.next())
            //{
              //  System.out.println("tender_id:" + resultSet.getString(1)+"                engineer_id :"+ resultSet.getString(2));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            //}

           pstmt.close();
       //     resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f8() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter department id:");
            
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select dname from tender.department where department_id=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("department name :" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f9() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter employee id:");
          
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select ename,employee_id from tender.employee where employee_id=?");
           pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("ename :" + resultSet.getString(1)+"      employee_id :"+ resultSet.getString(2));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f10() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter salary:");
            int a=sc.nextInt();
            
            PreparedStatement pstmt = conn.prepareStatement("Select employee_id from tender.employee where salary>?");
          //  pstmt.setString(1, did);
            pstmt.setInt(1, a);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("employee_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f11() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        //    System.out.println("Enter tender type to view:");
         //   int a=sc.nextInt();
        //    String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Drop table tender.contractor");
          //  pstmt.setString(1, did);
            
            pstmt.executeUpdate();
       //     while (resultSet.next())
         //   {
           //     System.out.println("tender_id:" + resultSet.getString(1)+"                engineer_id :"+ resultSet.getString(2));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            //}

           pstmt.close();
            //resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f12() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter employee id:");
          
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select employee_id from tender.employee where salary> (select salary from tender.employee where employee_id=?)");
          pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("employee_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f13() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter tender id to view:");
           
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select * from tender.tender where tender_id=?");
           pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("budget:" + resultSet.getString(2)+"  sdate :"+ resultSet.getString(3)+"    edate  :" + resultSet.getString(4)+"  status :"+ resultSet.getString(5)+"   location:" + resultSet.getString(6)+"  udate :"+ resultSet.getString(7)+"  cdate:" + resultSet.getString(8));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f14() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Press 1 for building tender, 2 for road tender, 3 for water pipeline tender");
            
            int a=sc.nextInt();
            System.out.println("Press 1 for complete tenders, press 2 for ongoing tenders");
            int b=sc.nextInt();
            String did,did1;
            
            PreparedStatement pstmt = conn.prepareStatement("Select tender_id from tender.tender where tender_id like ? and status=?");
            if(a==1)
            {
            	did="BT%";
            }
            else if(a==2)
            {
            	did="RT%";
            }
            else
            {
            	
            	did="PT%";
            }
            
            if(b==1)
            {
            	did1="complete";
            }
            else
            {
            	did1="ongoing";
            }
            pstmt.setString(1, did);
            pstmt.setString(2,did1);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f15() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter tender id  :");
           
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select machienary_id from tender.r_machienary where tender_id=?");
           pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("machienary_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f16() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter budget :");
            int a=sc.nextInt();
          
            PreparedStatement pstmt = conn.prepareStatement("Select tender_id from tender.tender where budget>?");
           pstmt.setInt(1, a);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f17() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter tender id  :");
            
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select labour_id from tender.r_labour where tender_id=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("labour_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f18() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter labour id :");
            
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select wages from tender.labour where labour_id=?");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("wages :" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f19() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter tender id:");
            
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select wages from tender.labour l, tender.r_labour r where r.tender_id=? and r.labour_id=l.labour_id;");
            pstmt.setString(1, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("wages  :" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f20() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("press 1 for heavy and 2 for light machienary  :");
            int a=sc.nextInt();
            System.out.println("Enter tender id  :");
          String did1;
            String did = sc.next();
            PreparedStatement pstmt = conn.prepareStatement("Select distinct  r.machienary_id from tender.r_machienary r, tender.machienary m where m.type=? and r.tender_id =?");
            if(a==1)
            {
            	did1="H";
            }
            else
            {
            	did1="L";
            }
            pstmt.setString(1, did1);
            pstmt.setString(2, did);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("machienary_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
    
    private static void f21() 
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Enter length of pipeline  :");
            String a=sc.next();
            
            PreparedStatement pstmt = conn.prepareStatement("Select tender_id from tender.water_pipeline_tender where length_km>?");
            pstmt.setString(1, a);
            
            resultSet = pstmt.executeQuery();
            while (resultSet.next())
            {
                System.out.println("tender_id:" + resultSet.getString(1));
                /*System.out.println("3."+resultSet.getInt(3));
                System.out.println("4."+resultSet.getString(2));*/
            }

           pstmt.close();
            resultSet.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try 
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }
    }
        
        private static void f22()
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter cement in kgs  :");
                String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("Select tender_id from tender.building_tender where cement>?");
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("tender_id:" + resultSet.getString(1));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f23() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
              //  System.out.println("Enter tender id:");
               
                PreparedStatement pstmt = conn.prepareStatement("select wages,labour_id from tender.labour;");
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("wages  :" + resultSet.getString(1)+"    labour_id :"+ resultSet.getString(2));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
               resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        private static void f24() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter 1 to view road tender, 2 to view building tender and 3 to vie pipeline tender :");
                int a=sc.nextInt();
                String did;
                PreparedStatement pstmt = conn.prepareStatement("select contractor_id, tender_id from tender.bidS where tender_id like ?");
               if(a==1)
               {
            	   did="RT%";
               }
               else if (a==2)
               {
            	   did="BT%";
               }
               else
               {
            	   did="PT%";
               }
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("tender_id:" + resultSet.getString(1)+"                engineer_id :"+ resultSet.getString(2));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f25() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter location");
              
                String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select count(tender_id) from tender.tender where location=?");
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("tender number  :" + resultSet.getString(1));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f26() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter engineer id  :");
           //     int a=sc.nextInt();
              String did=sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select t.tar,r.engineer_id from tender.r_engineer r, tender.road_tender t where r.engineer_id=? and t.tender_id=r.tender_id");
            
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("tar amount :" + resultSet.getString(1)+"   engineer_id :"+ resultSet.getString(2));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f27() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
         //       System.out.println("Enter tender type to view:");
           
             //   String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select distinct m.machienary_id from tender.machienary m,tender.r_machienary r,tender.water_pipeline_tender t where m.type='H' and r.tender_id like 'PT%' and r.tender_id=t.tender_id order by m.machienary_id");
              //  pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("machienary_id:" + resultSet.getString(1));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f28() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter contractor_id to view:");
              //  int a=sc.nextInt();
                String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select a.employee_id,b.contractor_id,b.tender_id,b.status from tender.bids b,tender.approves a where a.bid=b.bid and b.contractor_id=?");
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("employee_id:" + resultSet.getString(1)+"   contractor_id :"+ resultSet.getString(2)+"   tender_id  :"+resultSet.getString(3)+"  status  :"+resultSet.getString(4));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f29() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter contractor id:");
               // int a=sc.nextInt();
                String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select e.ename,r.engineer_id,b.contractor_id from tender.engineer e,tender.r_engineer r,tender.bids b where b.contractor_id=? and b.status='yes' and b.tender_id=r.tender_id and r.engineer_id=e.engineer_id");
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("engineer name:" + resultSet.getString(1)+"       engineer_id :"+ resultSet.getString(2)+"    contractor id  :"+resultSet.getString(3));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        
        private static void f30() 
        {
            try
            {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                System.out.println("Enter sand quantity:");
               // int a=sc.nextInt();
                String did = sc.next();
                PreparedStatement pstmt = conn.prepareStatement("select e.ename, e.engineer_id,e.etype from tender.engineer e, tender.r_engineer r,tender.road_tender t where e.engineer_id=r.engineer_id and e.etype='civil' and r.tender_id like'RT%' and t.sand_kg=? and t.tender_id=r.tender_id");
                pstmt.setString(1, did);
                
                resultSet = pstmt.executeQuery();
                while (resultSet.next())
                {
                    System.out.println("enineer name:" + resultSet.getString(1)+"      engineer_id :"+ resultSet.getString(2)+"   engineer type  :"+resultSet.getString(3));
                    /*System.out.println("3."+resultSet.getInt(3));
                    System.out.println("4."+resultSet.getString(2));*/
                }

               pstmt.close();
                resultSet.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            } finally
            {
                //finally block used to close resources
                try
                {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
                try 
                {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se)
                {
                    se.printStackTrace();
                }//end finally try
            }
        }
        }

    
  