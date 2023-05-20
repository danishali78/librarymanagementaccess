/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Bookdaoimpl implements BiookDoa{
private Connection connection;

    public BookdaoImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
public List<Book> viewBooks() {
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

                Book book = new Book(id, title, genre, price);
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
            String query = "INSERT INTO books (id,title,  genre,price) VALUES (1, "b", "AA","200RS")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getgenre());
            preparedStatement.setString(4, book.getprice());
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
                String author = resultSet.getString("genre");
                String isbn = resultSet.getString("price");

                Book book = new Book(id, title, genre, price);
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
            String query = "UPDATE books SET issued = true WHERE id = 1";
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
            String query = "UPDATE books SET issued = false WHERE id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
