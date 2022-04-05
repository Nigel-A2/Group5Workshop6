package com.group5.workshop6.group5workshop6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddModifyProduct {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDeleteProduct;

    @FXML
    private Button btnSaveProduct;

    @FXML
    private Label lblMode;

    // accidentally used "tv" because I was thinking about Android's TextView
    @FXML
    private TextField tvProdName;

    @FXML
    private TextField tvProductId;

    private String mode;

    Product product;

    @FXML
    void onSaveProductClicked(MouseEvent event) {
        try {
            product.setProdName(tvProdName.getText());
            // NullPointerException on add, this.product is null apparently

            //
            //String user = "";
            // String password = "";
            // String url = "";
            // String dbProtocol = "";
            // String db = "";
            // String port = "";
            // String host = "";
            //
            // FileInputStream fis = null;
            // try {
            //     fis = new FileInputStream("c:\\connection.properties");
            //     //ConnectionManager conMan  = (ConnectionManager) ConnectionManager.getConnection();
            //     Properties p = new Properties();
            //     p.load(fis);
            //     url = (String) p.get("url");
            //     user = (String) p.get("user");
            //     password = (String) p.get("password");
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }
            //
            //
            // try{
            //
            //     Connection conn = DriverManager.getConnection(url, user, password);
            //     String sql = null;
            //if mode is "edit", do an update, else, do an insert
            if (mode.equals("edit")) {
                ProductManager.updateProduct(product);
            } else {
                ProductManager.createProduct(product);
            }
            //     PreparedStatement stmt = conn.prepareStatement(sql);
            //     stmt.setString(1, tvProdName.getText());
            //     if (mode == "edit") {
            //         stmt.setInt(2, Integer.parseInt(tvProductId.getText()));
            //     }
            //     int numRows = stmt.executeUpdate();
            //     if (numRows == 0)
            //     {
            //         System.out.println("update failed");
            //     }
            //    conn.close();
            //     //get reference to stage and close it
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("COME HERE YOU!");
        }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }

    @FXML
    void onDeleteProductClicked(MouseEvent event) {
        product = new Product(Integer.parseInt(tvProductId.getText()), tvProdName.getText());
        ProductManager.deleteProduct(product);

//        String user = "";
//        String password = "";
//        String url = "";
//        try {
//            FileInputStream fis = new FileInputStream("c:\\connection.properties");
//            Properties p = new Properties();
//            p.load(fis);
//            url = (String) p.get("url");
//            user = (String) p.get("user");
//            password = (String) p.get("password");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try{
//            Connection conn = DriverManager.getConnection(url, user, password);
//            String sql = "DELETE FROM `products` WHERE ProductId=?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, Integer.parseInt(tvProductId.getText()));
//            int numRows = stmt.executeUpdate();
//            if (numRows == 0)
//            {
//                System.out.println("update failed");
//            }
//            conn.close();
            //get reference to stage and close it
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void initialize() {
        assert btnDeleteProduct != null : "fx:id=\"btnDeleteProduct\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert btnSaveProduct != null : "fx:id=\"btnSaveProduct\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert lblMode != null : "fx:id=\"lblMode\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert tvProdName != null : "fx:id=\"tvProdName\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert tvProductId != null : "fx:id=\"tvProductId\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
    }

    public void processProduct(Product p) {
        product = p;
        tvProductId.setText(p.getProductId() + "");
        tvProdName.setText(p.getProdName());
    }

    public void passModeToDialog(String mode){
        this.mode = mode;
        //display the mode on the dialog
        lblMode.setText(mode);

        //if this is in add mode, hide the delete button, as there is nothing to delete
        if (mode.equals("add"))
        {
            btnDeleteProduct.setVisible(false);
        }
    }
}
