/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public interface BiookDoa {
List<Book> ViewBooks();
    Book returnbook(int bookId);
    void addBook(Book book);
    void issuebook(int bookId);
void List<Book> getIssuedBooks();
}
