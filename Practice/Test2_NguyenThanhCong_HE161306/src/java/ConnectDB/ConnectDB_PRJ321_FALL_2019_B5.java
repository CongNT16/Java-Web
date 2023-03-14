/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ConnectDB_PRJ321_FALL_2019_B5 {
    protected Connection connection;
    public ConnectDB_PRJ321_FALL_2019_B5()
    {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {   
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://LAPUTA:1433;databaseName=PRJ321_FALL_2019_B5";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectDB_PRJ321_FALL_2019_B5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
