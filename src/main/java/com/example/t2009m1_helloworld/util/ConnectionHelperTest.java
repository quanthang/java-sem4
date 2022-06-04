package com.example.t2009m1_helloworld.util;

import com.example.t2009m1_helloworld.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHelperTest {
    public void test(){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where status = ? and id = ?");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("password");
                int status = resultSet.getInt("status");
                User user = new User(id, username, passwordHash, status);
                users.add(user);
            }
            for (User user: users){
                System.out.println(user.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

