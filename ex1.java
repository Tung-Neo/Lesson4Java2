package Lesson4Java2;

import java.sql.*;

public class ex1 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select id, title,  author, price, qty from books";

            ResultSet rset = stmt.executeQuery(strSelect);

            //1.select * from books
            while (rset.next()){
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(id + ", " + title + ", " + author + ", " + price + ", " + qty);
            }
            System.out.println("-------");

            //2.SELECT title, price FROM books WHERE author = 'CodeLean Vn'

            while (rset.next()){
                double price = rset.getDouble("price");
                String title = rset.getString("title");
                String author = rset.getString("author");
                if (author == "CodeLean Vn"){
                    System.out.println(title + ", " + price);
                }
            }
            System.out.println("-------");

            //3.SELECT title,  author, price, qty, FROM books, WHERE author = "CodeLean Vn" OR price >= 30 ORDER BY price DESC, id ASC
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
