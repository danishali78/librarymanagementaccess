/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class userdoa implements Userrdoa {
private Connection connection;

    public userdoa() {

        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<User> getalluser() {
        List<User> users = new ArrayList<>();

        try {
            String query = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(id, username,password);
                users.add(user);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return users;
}
public void adduser(User user) {
        try {
            String query = "INSERT INTO User (uid,username,  password) VALUES ( ?,?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getuid());
            preparedStatement.setString(2, user.getusername());
            preparedStatement.setString(3, user.getpassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
