package com.example.t2009m1_helloworld.Model;

import com.example.t2009m1_helloworld.util.ConnectionHelper;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserModel implements UserModel{
    @Override
    public boolean save(User user) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(username, passwordHash, status) values (?,?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPasswordHash());
            preparedStatement.setInt(3, user.getStatus());
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean update(int id, User updateUser) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set username = ?, passwordHash = ?, status = ? where id = ?");
            preparedStatement.setString(1, updateUser.getUsername());
            preparedStatement.setString(2, updateUser.getPasswordHash());
            preparedStatement.setInt(3, updateUser.getStatus());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update users set status = ? where id = ?");
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where status = ?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                int status = resultSet.getInt("status");
                User user = new User(id, username, passwordHash, status);
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where status = ? and id = ?");
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                int status = resultSet.getInt("status");
                User user = new User(id, username, passwordHash,status);
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
