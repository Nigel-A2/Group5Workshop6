package com.group5.workshop6.group5workshop6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booking-table-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookingTable dialogController = fxmlLoader.<BookingTable>getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Bookings");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    void onCustomersClicked(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-table-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CustomerTable dialogController = fxmlLoader.<CustomerTable>getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Customers");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    void onPackagesClicked(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("package-table-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PackageTable dialogController = fxmlLoader.<PackageTable>getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Packages");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    void onProductsClicked(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-table-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProductTable dialogController = fxmlLoader.<ProductTable>getController();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Products");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnBookings != null : "fx:id=\"btnBookings\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnCustomers != null : "fx:id=\"btnCustomers\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnPackages != null : "fx:id=\"btnPackages\" was not injected: check your FXML file 'start-menu-view.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'start-menu-view.fxml'.";

    }

}
