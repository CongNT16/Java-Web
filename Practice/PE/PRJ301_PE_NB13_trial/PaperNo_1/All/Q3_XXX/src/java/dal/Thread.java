package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Thread extends DBContext{
    private int id;
    private String content;
    private List<Answer> list;

    public Thread() {
        list = new ArrayList<>();
    }

    public Thread(int id, String content, List<Answer> list) {
        this.id = id;
        this.content = content;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getList() {
        return list;
    }

    public void setList(List<Answer> list) {
        this.list = list;
    }
    
    public List<Thread> getAll() {
        List<Thread> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Thread";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Thread t = new Thread();
                Answer a = new Answer();
                
                t.setId(rs.getInt(1));
                t.setContent(rs.getString(2));
                t.setList(a.getAll(rs.getInt(1)));
                
                list.add(t);
            } 
        }catch(SQLException e) {}
        
        return list;
    }
}
