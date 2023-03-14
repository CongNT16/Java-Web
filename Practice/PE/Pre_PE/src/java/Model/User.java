/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class User extends DBContext{
    
    public String sid, name, gender, dob;
    
    
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cnn = super.connection;
            System.out.println("Connect success");

        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        
    }

    public User(String account, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean checkUser(String account, String dob) {
        try{
            String strSelect="select * from Users " 
                    + "where account= ? and "      
                    + "dateofbirth=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);           
            pstm.setString(2, dob);
            rs = pstm.executeQuery();
            while(rs.next()){
                //tài khoản tồn tại
                return true;
            }
            
            
        }catch(Exception e){
            System.out.println("check error : " + e.getMessage());     
            
        }
        
        return false;
    }
    
    public ArrayList<User> getAll(){
        ArrayList<User> list = new ArrayList<User>();
        try{
            String strSelect = "select * from Users";
            pstm = cmn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while(rs.next()){
                String account = rs.getString(1);
                String pass = rs.getString("password");
                String name = rs.getString(3);
                String gender = "Male";
                if(!rs.getBoolean(4)){
                    gender = "Female";
                }
                String address = rs.getString(5);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if(rs.getDate(6) != null){
                    dob = f.format(rs.getDate(6));
                }
                User u = new User(account, pass, name, gender, dob, address);
                list.add(u);
            }
        }catch(Exception e){
            System.out.println("GetAll error :" +e.getMessage());
        }
        return list;
    }

    public void insert(String account, String pass, String name, String gender, String address, String dob) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checklogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
