package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student extends DBContext{
    private int sid,gender;
    private String name, dob;

    public Student() {
    }

    public Student(int sid, int gender, String name, String dob) {
        this.sid = sid;
        this.gender = gender;
        this.name = name;
        this.dob = dob;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public List<Student> filter(String name) {
        String sql = "SELECT * FROM dbo.Student";
        List<Student> list = new ArrayList<>();
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setGender(rs.getInt(3));
                s.setDob(rs.getString(4));
                
                if (s.getName().contains(name)) list.add(s);
            }
        }catch(SQLException e) {}
        
        return list;
    }
}
