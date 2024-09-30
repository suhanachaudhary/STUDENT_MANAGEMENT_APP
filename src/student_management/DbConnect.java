/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_management;
import java.sql.*;
/**
 *
 * @author suhana choudhary
 */
public class DbConnect {
    static Connection con=null;
    public static Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/studmanagement?user=root&password=");
            
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
