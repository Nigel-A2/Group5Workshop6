package com.group5.workshop6.group5workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

// this can be changed if desired
public class StartMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBookings;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnProducts;

    @FXML
    void onBookingsClicked(MouseEvent event) {

    }

    @FXML
    void onCustomersClicked(MouseEvent event) {

    }

    @FXML
    void onPackagesClicked(MouseEvent event) {

    }

    @FXML
    void onProductsClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnCustomers != null : "fx:id=\"btnCustomers\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'start-menu-view.fxml'.";

    }

}
