package com.group5.workshop6.group5workshop6;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProductManager {
    /**
     * Get a list of all the products
     * @return A list of Products, or an empty list if anything goes wrong
     * */
    public static List<Product> getProductList() {
        Connection conn = ConnectionManager.getConnection();
        List<Product> productList = new ArrayList<>();

        if (conn == null) {
            System.err.println("No connection available.");
            return productList;
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM products ORDER BY ProductId";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                productList.add(new Product(results.getInt(1), results.getString(2)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    /**
     * Get data about a product based on its id
     * @param id The id of the product to retrieve
     * @return The product data as an Product object, or null if that product doesn't exist
     * */
    static Product getProductById(int id) {
        Connection conn = ConnectionManager.getConnection();
        Product product = null;

        if (conn == null) {
            System.err.println("No connection available.");
            return product; // it says product is always null
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM products WHERE ProductId = " + id;
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                product = new Product(
                        results.getInt(1),
                        results.getString(2)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    /**
     * Update the data of a product
     * @param product The new product data to store in the database
     * */
    static boolean updateProduct(Product product) {
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null)
                return false;

            String query = "UPDATE products SET ProdName=? WHERE ProductId=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProdName());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Insert new product into the database
     * @param product The new product data to store in the database
     */
    static boolean createProduct(Product product){
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null)
                return false;

            String query = "INSERT INTO `products`(`ProductId`,`ProdName`) VALUES (null,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProdName());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Deletes a product from the database.
     * There should be a popup dialog for confirmation
     * @param product The product to delete
     */
    static boolean deleteProduct(Product product){
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null)
                return false;

            String query = "DELETE FROM `products` WHERE ProductId=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProdName());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
