package com.group5.workshop6.group5workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    @FXML
    private TextField tvProdName;

    @FXML
    private TextField tvProductId;

    @FXML
    void onSaveProductClicked(MouseEvent event) {

    }

    @FXML
    void onDeleteProductClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDeleteProduct != null : "fx:id=\"btnDeleteProduct\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert btnSaveProduct != null : "fx:id=\"btnSaveProduct\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert lblMode != null : "fx:id=\"lblMode\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert tvProdName != null : "fx:id=\"tvProdName\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";
        assert tvProductId != null : "fx:id=\"tvProductId\" was not injected: check your FXML file 'add-modify-product-view.fxml'.";

    }

}
