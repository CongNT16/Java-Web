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

/**
 *
 * @author nguye
 */
public class Order extends DBContext {

    String customerId, orderId, orderDate;

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public Order() {
        connectDB();
    }

    public Order(String customerId, String orderId, String orderDate) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void insertOrder(String customerId, String orderdate) {
        try {
            String strSelect = "  insert into [Orders] ([CustomerID],[OrderDate])\n"
                    + "  values (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, customerId);
            pstm.setString(2, orderdate);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }

    }

}
