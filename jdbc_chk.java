//
import java.sql.*;
public class jdbc_chk {
    public static void main(String args[]){
        String url="jdbc:mysql://localhost/library";
       String user="root";
       String pwd= "1234";
       String query= "select * from books;";
       try
       {
           Connection conn= DriverManager.getConnection(url,user,pwd);
           Statement stm=conn.createStatement();
           ResultSet rs= stm.executeQuery(query);
           while(rs.next())
           {
               String bookid=rs.getString("BOOK_ID");
               String category=rs.getString("CATEGORY");
               String name=rs.getString("NAME"); 
               String author=rs.getString("AUTHOR");
               int copies=rs.getInt("COPIES");
               System.out.println(bookid + " " + category + " " + name + " " + author + " " + copies);   
           }
           rs.close();
           stm.close(); 
       }
       catch(Exception e){
           System.out.println(e.getMessage()); 
       }  

    }
    
}
