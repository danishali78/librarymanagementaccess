/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class userdoa implements Userrdoa {
private Connection connection;

    public userdoa() {
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<User> getalluser() {
        List<User> users = new ArrayList<>();

        try {
            String query = "SELECT * FROM User";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
public void adduser(User user) {
        try {
            String query = "INSERT INTO User (id,username,  password) VALUES (1, "11b", "11AA",)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getuid());
            preparedStatement.setString(2, user.getusername());
            preparedStatement.setString(3, user.getpassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
