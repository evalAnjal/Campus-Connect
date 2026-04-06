package com.eventmgmt.demo.DAO;

import com.eventmgmt.demo.model.User;
import com.eventmgmt.demo.util.DBconnection;
import java.sql.*;

public class UserDAO {
    public User validateUser (String email, String password){
        User user = null;
        String sql = "select * from users where email =? and password = ?";

        try(Connection conn = DBconnection.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)        
    ){
        st.setString(1,email);
        st.setString(2,password);
        

        ResultSet rs = st.executeQuery();

        if(rs.next()){
            user = new User();
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString(("role")));
            user.setUsername(rs.getString(("username")));
        }


        
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return user;
    }
}
