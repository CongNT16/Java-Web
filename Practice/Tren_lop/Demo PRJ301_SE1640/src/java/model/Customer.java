/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
public class Customer extends DBContext{
    
    String CustomerID, CustomerName, Gender, Address, Birthdate;

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }
    
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;
    
    private void connectDB(){
        try {
            
            cnn=super.connection;
            System.out.println("Connect success");
            
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public Customer() {
        connectDB();
    }

    public Customer(String CustomerID, String CustomerName, String Gender, String Address, String Birthdate) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Gender = Gender;
        this.Address = Address;
        this.Birthdate = Birthdate;
    }
    
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> list = new ArrayList<Customer>();
        try{
            String strSelect = "select * from [Customers]";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String gender = "Male";
                if(!rs.getBoolean(3)){
                    gender = "Female";
                }
                String address = rs.getString(4);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if(rs.getDate(5) != null){
                    dob = f.format(rs.getDate(5));
                }
                Customer c = new Customer(id, name, gender, address, dob);
                list.add(c);
            }
        }catch(Exception e){
            System.out.println("GetAll error :" +e.getMessage());
        }
        return list;
    }
    
    
    
    
    

    
}
