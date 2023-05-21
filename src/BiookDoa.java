/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
public interface BiookDoa {
List<Book> ViewBooks();
    void returnbook(int bookId);
    void addBook(Book book);
    void issuebook(int bookId);
 List<Book> getIssuedBooks();
}
