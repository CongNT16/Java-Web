/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nguye
 */
public class accountDAO extends DBContext {

    public accountDAO() {
        connectDB();
    }

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

    public boolean checkLogin(String username, String password) {
        try {
            String strSelect = "select * from [dbo].[Account] "
                    + "where username= ? and "
                    + "password= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());

        }

        return false;

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
}
