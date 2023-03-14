package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends DBContext{

    private String username, password, displayName;

    public User() {
    }

    public User(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM dbo.Account\n"
                + "WHERE userid = ? AND [password] = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        }catch(SQLException e) {}
        
        return false;
    }
    
    public User getUser(String username, String password) {
        String sql = "SELECT * FROM dbo.Account\n"
                + "WHERE userid = ? AND [password] = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setDisplayName(rs.getString(3));
                
                return u;
            }
        }catch(SQLException e) {}
        
        return null;
    }
}
