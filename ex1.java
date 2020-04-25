package Lesson4Java2;

import java.sql.*;

public class ex1 {
    public static void yc1() {
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
            while (rset.next()) {
                int id = rset.getInt("id");
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(id + ", " + title + ", " + author + ", " + price + ", " + qty);
            }
            System.out.println("-------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void yc2() {
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

            ResultSet rset2 = stmt.executeQuery("select title, price, author from books  where author = 'CodeLean Vn'");

            //2.SELECT title, price FROM books WHERE author = 'CodeLean Vn'
            while (rset2.next()) {
                double price = rset2.getDouble("price");
                String title = rset2.getString("title");
                String author = rset2.getString("author");
                if (author.equals("CodeLean Vn")) {
                    System.out.println(title + ", " + price);
                }
            }
            System.out.println("-------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void yc3() {
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

            ResultSet rset2 = stmt.executeQuery("select id, title,  author, price, qty from books where author = 'CodeLean Vn' || price >= 30 order by price desc, id asc");


            //3.SELECT title,  author, price, qty, FROM books WHERE author = "CodeLean Vn" OR price >= 30 ORDER BY price DESC, id ASC
            while (rset2.next()) {
                String title = rset2.getString("title");
                String author = rset2.getString("author");
                double price = rset2.getDouble("price");
                int qty = rset2.getInt("qty");
                if (author == "CodeLean Vn" || price >= 30) {
                    System.out.println(title + ", " + price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        yc1();
        yc2();
        yc3();
    }
}
