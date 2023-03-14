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
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Product extends DBContext {

    String code, name, price, stock, image;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getImage() {
        return image;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product() {
        connectDB();
    }

    public Product(String code, String name, String price, String stock, String image) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.image = image;
        connectDB();
    }

    Connection cmn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;

    private void connectDB() {
        try {

            cmn = super.connection;
            System.out.println("Connect success");

        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSelect = "select * from Products ";
            pstm = cmn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                String stock = rs.getString(4);
                String image = rs.getString(5);
//                if(!rs.getBoolean(4)){
//                    gender = "Female";
//                }
//                String address = rs.getString(5);
//                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
//                String dob = "";
//                if(rs.getDate(6) != null){
//                    dob = f.format(rs.getDate(6));
//                }
                Product y = new Product(code, name, price, stock, image);
                list.add(y);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return list;
    }

    public void getProductbyId(String id) {

        try {
            String strSelect = "select * from Products where Productid = ?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.code = rs.getString(1);
                this.name = rs.getString(2);
                this.price = rs.getString(3);
                this.stock = rs.getString(4);
                this.image = rs.getString(5);

            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
    }

    public void deleteProductbyId(String productid) {
        
        try {
            String strSelect = "DELETE FROM Products WHERE ProductID= ?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, productid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        

    }

    public boolean checkProductId(String productid) {
        try {
            String strSelect = "select * from Products "
                    + "where ProductID= ? ";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, productid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkProductname(String productname) {
        try {
            String strSelect = "select * from Products "
                    + "where ProductName= ? ";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, productname);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public void insertproduct( String productname, String unitprice, String instock, String image, String categoryid, String discountinued) {
        try{
            String strSelect="insert into Products " 
                    + "values(?,?,?,?,?,?) ";
            pstm = cmn.prepareStatement(strSelect);
            
            pstm.setString(1, productname);
            pstm.setString(2, unitprice);
            pstm.setString(3, instock);
            pstm.setString(4, image);
            pstm.setString(5, categoryid);
            pstm.setString(6, discountinued);
            pstm.execute();
            
            
            
        }catch(Exception e){
            System.out.println("update error : " + e.getMessage());     
            
        }
    }

    public void updateProductNP(String productid, String productname, String unitprice) {
        
        try {
            String strSelect = "UPDATE Products\n" +
                                "SET [ProductName] = ?, [UnitPrice]= ?\n" +
                                "WHERE [ProductID] = ?";
            pstm = cmn.prepareStatement(strSelect);
            pstm.setString(1, productname);
            pstm.setString(2, unitprice);
            pstm.setString(3, productid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        
    }

    public void updateStock(String codeproduct, String íntockproduct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
