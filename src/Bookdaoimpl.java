/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Bookdaoimpl implements BiookDoa{
private Connection connection;

    public Bookdaoimpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "";
           
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<Book> ViewBooks() {
        List<Book> books = new ArrayList<>();

        try {
            String query = "SELECT * FROM books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String price = resultSet.getString("price");
                 boolean b1=resultSet.getBoolean("issued");
                Book book = new Book(id, title, genre, price,b1);
                books.add(book);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
 public void addBook(Book book) {
        try {
            String query = "INSERT INTO books (id,title,  genre,price,issued) VALUES (?, ?, ?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getgenre());
            preparedStatement.setString(4, book.getprice());
             preparedStatement.setBoolean(5, book.getissued());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public List<Book> getIssuedBooks() {
        List<Book> issuedBooks = new ArrayList<>();

        try {
            String query = "SELECT * FROM books WHERE issued = true";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String price = resultSet.getString("price");
               boolean b1=resultSet.getBoolean("issued");
                Book book = new Book(id, title, genre, price,b1);
                issuedBooks.add(book);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issuedBooks;
    }
   public void issuebook(int bookId) {
        try {
            String query = "UPDATE books SET issued = true WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnbook(int bookId) {
        try {
            String query = "UPDATE books SET issued = false WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
