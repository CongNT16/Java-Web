/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class User extends DBContext {

    String account, password, fullname, sdt, email, address, gender, dateofbirth, role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public User(String account, String password, String fullname, String sdt, String email, String address, String gender,String dateofbirth) {
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.sdt = sdt;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
    }

    public User() {
        connectDB();
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connectDB();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDareofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    //Khai bao cac thanh phan xu ly DB
    Connection cnn;//Ket noi DB
    Statement stm;//Thuc hien cau lenh sql
    ResultSet rs;//Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connectDB() {
        try {
            cnn = super.connection;
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Connect error:" + e.getMessage());
        }
    }

    public boolean check(String acc, String pass) {
        try {
            String strSelect = "select * from Users "
                    + "where account=? and "
                    + "password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //Tai khoan ton tai
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error" + e.getMessage());
        }
        return false;
    }

    public Boolean checklogin() {
        try {
            String strSelect = "select * from Users "
                    + " where account =? and "
                    + " password =?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;

    }

    public void updatePass(String acc, String newpass) {
        try {
            String strSelect = "update Users "
                    + "set Password=? "
                    + "where account=?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpass);
            pstm.setString(2, acc);
            rs = pstm.executeQuery();

        } catch (Exception e) {
            System.out.println("Update error" + e.getMessage());
        }
    }

    public boolean checkAccount(String account) {
        try {
            String strSelect = "select * from Users "
                    + "where account=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //Tai khoan ton tai
                return true;
            }
        } catch (Exception e) {
            System.out.println("Check error:" + e.getMessage());
        }
        return false;
    }

    public void insert(String account, String password, String fullname, String email, String sdt, String address, String gender, String dob) {
        try {
            String strSelect = "INSERT INTO Users (account,Password,fullname,email,sdt,address,gender,dateofbirth) VALUES (?,?,?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            pstm.setString(3, fullname);
            pstm.setString(4, email);
            pstm.setString(5, sdt);
            pstm.setString(6, address);
            pstm.setString(7, gender);
            pstm.setString(8, dob);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Insert error:" + e.getMessage());
        }

    }

    public boolean checkUser(String account, String sdt) {
        try {
            String strSelect = "select * from Users where account =? and sdt =?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, String.valueOf(sdt));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login error : " + e.getMessage());
        }
        return false;

    }

    public void update(String account, String newpass) {
        try {
            String strSelect = "update Users set Password =? where account =? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpass);
            pstm.setString(2, account);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("Update error : " + e.getMessage());
        }

    }

    public void updateNewPass(String account, String newpass) {
        try {
            String strSelect = "update Users "
                    + " set password =?"
                    + " where account =? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, newpass);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("Update error : " + e.getMessage());
        }
    }

   

    public void getProfileByAccount(String id) {
        try {
            String strSelect = "select * from Users where account=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.password = rs.getString(2);
                this.fullname = rs.getString(3);
                this.email = rs.getString(4);
                this.sdt = rs.getString(5);
                this.address = rs.getString(6);
                this.gender = rs.getString(7);
                this.dateofbirth = rs.getString(8);

            }
        } catch (Exception e) {
            System.out.println("GetAll error:" + e.getMessage());
        }
    }

    public void profile(String account, String password) {
        try {
            String strSelect = "select * from Users where account=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.password = rs.getString(2);
                this.fullname = rs.getString(3);
                this.email = rs.getString(4);
                this.sdt = rs.getString(5);
                this.address = rs.getString(6);
                this.gender = rs.getString(7);
            }
        } catch (Exception e) {
            System.out.println("GetAll error:" + e.getMessage());
        }
    }

   

    public ArrayList<User> getAccByID(String acc) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            String strSelect = " select * from Users where account = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //2 cach goi : so hoac ten
                String account = rs.getString(2);
                String pass = rs.getString(3);
                String fullname = rs.getString(4);
                String email = rs.getString(5);
                String sdt = rs.getString(6);
                String address = rs.getString(7);
                String gender = rs.getString(8);
                if (gender.equals("1")) {
                    gender = "Male";
                }else{
                    gender = "Female";
                }
                String dateofbirth = rs.getString(9);

                User u = new User(account, pass, fullname, email, sdt, gender, address, dateofbirth);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Get byID errr" + e.getMessage());
        }

        return list;
    }

}
