package com.group5.workshop6.group5workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ProductTable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddProduct;

    @FXML
    private TableView<?> tvProducts;

    @FXML
    void onAddProductClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAddProduct != null : "fx:id=\"btnAddProduct\" was not injected: check your FXML file 'product-table-view.fxml'.";
        assert tvProducts != null : "fx:id=\"tvProducts\" was not injected: check your FXML file 'product-table-view.fxml'.";
    }

}
