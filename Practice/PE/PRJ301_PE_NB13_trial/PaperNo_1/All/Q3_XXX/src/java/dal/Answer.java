package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Answer extends DBContext {

    private String name;
    private String context;

    public Answer() {
    }

    public Answer(String name, String context) {
        this.name = name;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Answer> getAll(int threadId) {
        List<Answer> list = new ArrayList<>();
        String sql = "SELECT cid,ctitle,displayname,tid FROM dbo.Comment INNER JOIN dbo.Account\n"
                + "ON Account.userid = Comment.userid\n"
                + "WHERE tid = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, threadId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Answer a = new Answer();
                a.setName(rs.getString(3));
                a.setContext(rs.getString(2));

                list.add(a);
            }

        } catch (SQLException e) {
        }

        return list;
    }
    
    public void addComment(String userId, String comment, int tId) {
        String sql = "INSERT INTO dbo.Comment VALUES (?,?,?)";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, comment);
            st.setString(2, userId);
            st.setInt(3, tId);
            
            st.executeUpdate();
        }catch(SQLException e){}
    }
    
    public static void main(String[] args) {
        Answer a = new Answer();
        
        a.addComment("mra", "Okeeee", 3);
    }
}
