package com.group5.workshop6.group5workshop6;

import java.net.URL;
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
            //if mode is "edit", do an update, else, do an insert
            if (mode.equals("edit")) {
                product.setProdName(tvProdName.getText());
                ProductManager.updateProduct(product);
            } else {
                product = new Product(0, tvProdName.getText());
                ProductManager.createProduct(product);
            }
            //get reference to stage and close it
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("COME HERE YOU!");
        }
    }

    @FXML
    void onDeleteProductClicked(MouseEvent event) {
        product = new Product(Integer.parseInt(tvProductId.getText()), tvProdName.getText());
        ProductManager.deleteProduct(product);
        //get reference to stage and close it
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
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
