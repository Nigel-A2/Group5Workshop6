package com.group5.workshop6.group5workshop6;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerManager {
    static Alert errorMessage = new Alert(Alert.AlertType.ERROR);
    
    /**
     * Get a list of all the customers
     * @return A list of Customers, or an empty list if anything goes wrong
     * */
    public static List<Customer> getCustomerList() {
        Connection conn = ConnectionManager.getConnection();
        List<Customer> customerList = new ArrayList<>();

        if (conn == null) {
            System.err.println("No connection available.");
            errorMessage.setContentText("No connection available.");
            errorMessage.show();
            return customerList;
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM customers ORDER BY CustomerId";
            ResultSet results = stmt.executeQuery(query);
            while (results.next()) {
                customerList.add(new Customer(results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        results.getString(6),
                        results.getString(7),
                        results.getString(8),
                        results.getString(9),
                        results.getString(10),
                        results.getString(11),
                        results.getInt(12)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage.setContentText("Could not retrieve customers from the database.");
            errorMessage.show();
            System.out.println("IT'S RAW!!");
        }
        return customerList;
    }

    /**
     * Get data about a customer based on their id
     * @param id The id of the customer to retrieve
     * @return The customer data as a Customer object, or null if that customer doesn't exist
     * */
    static Customer getCustomerById(int id) {
        Connection conn = ConnectionManager.getConnection();
        Customer customer = null;

        if (conn == null) {
            System.err.println("No connection available.");
            errorMessage.setContentText("No connection available.");
            errorMessage.show();
            return customer;
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM customers WHERE CustomerId = " + id;
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                customer = new Customer(results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5),
                        results.getString(6),
                        results.getString(7),
                        results.getString(8),
                        results.getString(9),
                        results.getString(10),
                        results.getString(11),
                        results.getInt(12)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage.setContentText("Could not retrieve customer information from the database");
            errorMessage.show();
            System.out.println("IT'S RAW!!");
        }

        return customer;
    }

    /**
     * Update the data of a customer
     * @param customer The new product data to store in the database
     * */
    static boolean updateCustomer(Customer customer) {
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null) {
                errorMessage.setContentText("No connection available.");
                errorMessage.show();
                return false;
            }
            System.out.println("Updating customer id " + customer.getCustomerId());
            String query = "UPDATE customers SET CustFirstName=?, CustLastName=?, CustAddress=?, CustCity=?, CustProv=?, CustPostal=?, CustCountry=?, CustHomePhone=?, CustBusPhone=?, CustEmail=?, AgentId=? WHERE CustomerId=?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getCustFirstName());
            stmt.setString(2, customer.getCustLastName());
            stmt.setString(3, customer.getCustAddress());
            stmt.setString(4, customer.getCustCity());
            stmt.setString(5, customer.getCustProv());
            stmt.setString(6, customer.getCustPostal());
            stmt.setString(7, customer.getCustCountry());
            stmt.setString(8, customer.getCustHomePhone());
            stmt.setString(9, customer.getCustBusPhone());
            stmt.setString(10, customer.getCustEmail());
            stmt.setInt(11, customer.getAgentId());
            stmt.setInt(12, customer.getCustomerId());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage.setContentText("Could not update customer data");
            errorMessage.show();
            System.out.println("IT'S RAW!!");
            return false;
        }
        return true;
    }

    /**
     * Insert new customer into the database
     * @param customer The new customer data to store in the database
     */
    static boolean createCustomer(Customer customer){
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null) {
                errorMessage.setContentText("No connection available.");
                errorMessage.show();
                return false;
            }
            String query = "INSERT INTO `customers`(`CustomerId`,`CustFirstName`," +
                    "`CustLastName`," +
                    "`CustAddress`," +
                    "`CustCity`," +
                    "`CustProv`," +
                    "`CustPostal`," +
                    "`CustCountry`," +
                    "`CustHomePhone`," +
                    "`CustBusPhone`," +
                    "`CustEmail`," +
                    "`AgentId`) VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getCustFirstName());
            stmt.setString(2, customer.getCustLastName());
            stmt.setString(3, customer.getCustAddress());
            stmt.setString(4, customer.getCustCity());
            stmt.setString(5, customer.getCustProv());
            stmt.setString(6, customer.getCustPostal());
            stmt.setString(7, customer.getCustCountry());
            stmt.setString(8, customer.getCustHomePhone());
            stmt.setString(9, customer.getCustBusPhone());
            stmt.setString(10, customer.getCustEmail());
            stmt.setInt(11, customer.getAgentId());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            errorMessage.setContentText("Could not create customer");
            errorMessage.show();
            System.out.println("IT'S RAW!!");
            return false;
        }
        return true;
    }

    /**
     * Deletes a customer from the database.
     * There should be a popup dialog for confirmation
     * @param customer The customer to delete
     */
    static boolean deleteCustomer(Customer customer){
        try {
            Connection conn = ConnectionManager.getConnection();

            if (conn == null) {
                errorMessage.setContentText("No connection available.");
                errorMessage.show();
                return false;
            }
            String query = "DELETE FROM `customers` WHERE CustomerId=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, customer.getCustomerId());
            int result = stmt.executeUpdate();
            System.out.println("Rows updated: " + result);
            conn.close();
            if (result < 1)
                return false;
        }
        catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            errorMessage.setContentText("This customer has data referenced by other parts of the database, and cannot be deleted");
            errorMessage.show();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            errorMessage.setContentText("Could not delete customer");
            errorMessage.show();
            System.out.println("IT'S RAW!!");
            return false;
        }

        return true;
    }
}
