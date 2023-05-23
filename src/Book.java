/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Book {
private int id;
    private String title;
    private String genre;
     private String price;
private boolean issued;
     public Book(int id, String title, String genre,String price,boolean issued) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
       this.issued=issued;
    }
  public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getgenre() {
        return genre;
    }
    public String getprice() {
        return price;
    }
    public boolean getissued() {
        return issued;
    }
}

