/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import ConnectDB.ConnectDB_Blog;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class UserDAO extends ConnectDB_Blog {
    //Lưu ý phải mở nguồn connect database
//    cnn = super.connection;
    //có thể đóng database
//    finally{
//            pstm.close();
//        }

    public UserDAO() {
        connectDB();

    }

    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        System.out.println(u.checklogin("user0", "123"));
//        ArrayList<Users> list = (ArrayList<Users>)u.getAll();
//        for (Users users : list) {
//            System.out.println(users.getUser_account());
        Users list = u.getUser("user0", "1234");

//        System.out.println(list.getUser_role());
//get time local
        LocalDate getdate = LocalDate.now();
        LocalTime gettime = LocalTime.now();

        String createdate = String.valueOf(getdate);

        String createtime = String.valueOf(gettime);
        System.out.println(createdate + "   " + createtime);

        u.insertUser("64527421", "nguyencong1", "nguyencong1@gmail.com", "123", "2022-10-25", "11:01:58");
        u.insertUserRole("1627354623");
//        Users userInfor = u.getUser("user0", "123");
//        String userid = String.valueOf(userInfor.getUser_id());
//        Users userRoleId = u.getUserRoleId(userid);
//
//        String userRole = String.valueOf(userRoleId.getRole_id());
//        
//        System.out.println(userInfor.getUser_id()); 
//        System.out.println(userRole);

    }

    //Khai bao cac thanh phan xu ly
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

    public boolean checklogin(String account, String password) {

        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
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

    public boolean checkUser(String account, String email) {
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_email=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUser2(String account, String password) {

        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;

    }

    public boolean checkUserId(String user_id) {
        try {
            String strSelect = "select * from Users "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserAccount(String user_account) {
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_account);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserEmail(String user_emal) {
        try {
            String strSelect = "select * from Users "
                    + "where user_email= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_emal);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public boolean checkUserRole(String user_id) {
        try {
            String strSelect = "select * from User-Role "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //tài khoản tồn tại
                return true;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return false;
    }

    public Users getUserRoleId(String user_id) {

        Users userRoleId = new Users();

        try {
            String strSelect = "select * from UserRole "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String userId = rs.getString("user_id");
                String roleId = rs.getString("role_id");

                Users u = new Users(userId, roleId);

                userRoleId = u;
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }

        return userRoleId;

    }

    public void insertUser(String user_id, String account, String email, String password1, String createdate, String createtime) {

        try {

            String strSelect = "INSERT INTO [dbo].[Users] ([user_id],[user_account],[user_email],[user_password],[user_create_date],[user_create_time])\n"
                    + "VALUES (?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            pstm.setString(2, account);
            pstm.setString(3, email);
            pstm.setString(4, password1);
            pstm.setString(5, createdate);
            pstm.setString(6, createtime);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }

    }

    public void insertUserRole(String user_id) {

        try {

            String strSelect = "INSERT INTO [dbo].[UserRole] ([user_id])\n"
                    + "VALUES (?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }

    }

    public void insertUserRoleID(String user_id, String role_id) {

        try {

            String strSelect = "INSERT INTO [dbo].[UserRole] ([user_id],[role_id])\n"
                    + "VALUES (?,?)";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            pstm.setString(2, role_id);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }

    }

    public void updatePassword(String account, String newpassword1) {

        try {
            String strSelect = "update Users "
                    + "set user_password= ? "
                    + "where user_account= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, newpassword1);
            pstm.setString(2, account);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }

    }

//    public Users getUser(String account, String password) throws SQLException {
//            Users user = null;
//        try {
//
//            String strSelect = "Select * from Users \n"
//                    + "where user_account = ? and user_password = ?;";
//            pstm = cnn.prepareStatement(strSelect);
//            pstm.setString(1, account);
//            pstm.setString(2, password);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                //tài khoản tồn tại
//                user.setUser_id(rs.getString("user_id"));
//                user.setUser_account(rs.getString("user_account"));
//                user.setUser_password(rs.getString("user_password"));
//                user.setUser_email(rs.getString("user_email"));
//                user.setUser_name(rs.getString("user_name"));
//                user.setUser_gender(rs.getString("user_gender"));
//                user.setUser_dob(rs.getString("user_dateofbirth"));
//                user.setUser_address(rs.getString("user_address"));
//                user.setUser_phone(rs.getString("user_phone"));
//                user.setUser_avatar(rs.getString("user_avatar"));
//                
//                   
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        finally{
////            pstm.close();
////        }
//        return user;
//        
//
//    }
    public Users getUser(String acc, String pass) {
        Users userInfor = new Users();
        try {
            String strSelect = "select * from Users "
                    + "where user_account= ? and "
                    + "user_password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("user_id");
                String account = rs.getString("user_account");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String firstname = rs.getString("user_firstname");
                String lastname = rs.getString("user_lastname");

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String phone = rs.getString("user_phone");
                String address = rs.getString("user_address");

                String avatar = rs.getString("user_avatar");
                String about = rs.getString("user_about");

                Users u = new Users(id, account, email, password, createdate, createtime, firstname, lastname, gender, dob, phone, address, avatar, about);
                userInfor = u;
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return userInfor;
    }

    public Users getUserInfor(String userid) {
        Users userInfor = new Users();
        try {
            String strSelect = "select * from Users "
                    + "where user_id= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, userid);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("user_id");
                String account = rs.getString("user_account");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String firstname = rs.getString("user_firstname");
                String lastname = rs.getString("user_lastname");

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String phone = rs.getString("user_phone");
                String address = rs.getString("user_address");

                String avatar = rs.getString("user_avatar");
                String about = rs.getString("user_about");

                Users u = new Users(id, account, email, password, createdate, createtime, firstname, lastname, gender, dob, phone, address, avatar, about);
                userInfor = u;
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return userInfor;
    }

    public void UpdateInfor(String user_id, String user_account, String user_email, String user_firstname, String user_lastname, String user_gender, String user_dateofbirth, String user_phone, String user_address, String user_avatar, String user_about) {

        try {
            String strSelect = "update Users "
                    + "set user_account= ? , user_email= ? , user_firstname= ? , user_lastname= ? , user_gender= ? , user_dateofbirth= ? , user_phone= ? ,  user_address= ? , user_avatar= ? , user_about=? "
                    + "where user_id= ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_account);
            pstm.setString(2, user_email);
            pstm.setString(3, user_firstname);
            pstm.setString(3, user_lastname);
            pstm.setString(4, user_gender);
            pstm.setString(5, user_dateofbirth);
            pstm.setString(6, user_phone);
            pstm.setString(7, user_address);
            pstm.setString(8, user_avatar);
            pstm.setString(8, user_about);
            pstm.setString(9, user_id);
            pstm.execute();

        } catch (Exception e) {
            System.out.println("update error : " + e.getMessage());

        }
    }

    public ArrayList<Users> getAllUser() {
        ArrayList<Users> listUser = new ArrayList<Users>();
        try {
            String strSelect = "Select u.*,ur.role_id,r.role_name from Users u \n"
                    + "join UserRole ur on u.user_id = ur.user_id\n"
                    + "join Roles r on r.role_id = ur.role_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String user_id = rs.getString(1);
                String user_account = rs.getString(2);
                String user_email = rs.getString(3);
                String user_password = rs.getString(4);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String user_firstname = rs.getString(7);
                String user_lastname = rs.getString(8);

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String post_phone = rs.getString(11);
                String post_address = rs.getString(12);
                String post_avatar = rs.getString(13);
                String post_about = rs.getString(14);
                String role_id = rs.getString(15);
                String role_name = rs.getString(16);

                Users u = new Users(user_id, user_account, user_email, user_password, createdate, createtime, user_firstname, user_lastname, gender, dob, post_phone, post_address, post_avatar, post_about, role_id, role_name);

                listUser.add(u);
            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }
        return listUser;

    }

    public ArrayList<Users> getListUser() {
        ArrayList<Users> listUser = new ArrayList<Users>();
        try {
            String strSelect = "Select u.*,ur.role_id from Users u\n"
                    + "join UserRole ur on u.user_id = ur.user_id";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String user_id = rs.getString(1);
                String user_account = rs.getString(2);
                String user_email = rs.getString(3);
                String user_password = rs.getString(4);

                SimpleDateFormat cd = new SimpleDateFormat("dd-MM-yyyy");
                String createdate = "";
                if (rs.getDate("user_create_date") != null) {
                    createdate = cd.format(rs.getDate("user_create_date"));
                }
                String createtime = String.valueOf(rs.getTime("user_create_time"));

                String user_firstname = rs.getString(7);
                String user_lastname = rs.getString(8);

                String gender = "Male";
                if (!rs.getBoolean("user_gender")) {
                    gender = "Female";
                }

                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                String dob = "";
                if (rs.getDate("user_dateofbirth") != null) {
                    dob = f.format(rs.getDate("user_dateofbirth"));
                }

                String post_phone = rs.getString(11);
                String post_address = rs.getString(12);
                String post_avatar = rs.getString(13);
                String post_about = rs.getString(14);
                String role_id = rs.getString(15);

                Users u = new Users(user_id, user_account, user_email, user_password, createdate, createtime, user_firstname, user_lastname, gender, dob, post_phone, post_address, post_avatar, post_about, role_id);

                listUser.add(u);

            }
        } catch (Exception e) {
            System.out.println("GetAll error :" + e.getMessage());
        }

        return listUser;

    }

    public void deleteUserByUserId(String user_id) {
            try {
            String strSelect = "DELETE FROM UserRole WHERE user_id= ?\n" +
                                "DELETE FROM Users WHERE user_id= ?" ;
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user_id);
            pstm.setString(2, user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                //product tồn tại
                
            }

        } catch (Exception e) {
            System.out.println("check error : " + e.getMessage());

        }
    }

}
