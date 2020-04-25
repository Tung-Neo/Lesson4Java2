package Lesson4Java2;

import java.sql.*;
import java.util.Scanner;

public class ex2 {
    //1.hiển thị danh sách khách hàng
    public static void yc1() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from customers";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                String CustomerID = rset.getString("CustomerID");
                String CompanyName = rset.getString("CompanyName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String City = rset.getString("City");
                String Region = rset.getString("Region");
                String PostalCode = rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");

                System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle + ", " + Address + ", " + City + ", " + Region + ", " + PostalCode + ", " + Country + ", " + Phone + ", " + Fax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //2.Tìm khách hàng theo tên
    public static void yc2() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên khách hàng: ");
            String a = sc.nextLine();
            String strSelect = "select * from customers where ContactName='" + a + "'";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                String CustomerID = rset.getString("CustomerID");
                String CompanyName = rset.getString("CompanyName");
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                String Address = rset.getString("Address");
                String City = rset.getString("City");
                String Region = rset.getString("Region");
                String PostalCode = rset.getString("PostalCode");
                String Country = rset.getString("Country");
                String Phone = rset.getString("Phone");
                String Fax = rset.getString("Fax");

                System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle + ", " + Address + ", " + City + ", " + Region + ", " + PostalCode + ", " + Country + ", " + Phone + ", " + Fax);
                            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.Hiển thị danh sách sản phẩm
    public static void yc3() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select ProductName from products";
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("Danh sách sản phẩm:");
            while (rset.next()){
                String ProductName = rset.getString("ProductName");

                System.out.println(ProductName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //4.Tìm sản phẩm theo giá bán trong khoảng do người dùng nhập vào
    public static void yc4() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập khoảng giá từ: ");
            double duoi = sc.nextDouble();
            System.out.println("đến: ");
            double tren = sc.nextDouble();
            String strSelect = "select ProductName, UnitPrice from products where UnitPrice between " + duoi + " and " + tren + "";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                String ProductName = rset.getString("ProductName");
                double UnitPrice = rset.getDouble("UnitPrice");

                System.out.println(ProductName + ", " + UnitPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //5.Hiển thị thông tin chi tiết của một đơn hàng
    public static void yc5() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from products";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                int ProductID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");
                int SupplierID = rset.getInt("SupplierID");
                int CategoryID = rset.getInt("CategoryID");
                String QuantityPerUnit = rset.getString("QuantityPerUnit");
                int UnitPrice = rset.getInt("UnitPrice");
                int UnitsInStock = rset.getInt("UnitsInStock");
                int UnitsOnOrder = rset.getInt("UnitsOnOrder");
                int ReorderLevel = rset.getInt("ReorderLevel");
                int Discontinued = rset.getInt("Discontinued");

                System.out.println(ProductID + ", " + ProductName + ", " + SupplierID + ", " + CategoryID + ", " + QuantityPerUnit + ", " + UnitPrice + ", " + UnitsInStock + ", " + UnitsOnOrder + ", " + ReorderLevel + ", ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        yc1();
        System.out.println("--------");
        yc2();
        System.out.println("--------");
        yc3();
        System.out.println("--------");
        yc4();
        System.out.println("--------");
        yc5();
    }
}
