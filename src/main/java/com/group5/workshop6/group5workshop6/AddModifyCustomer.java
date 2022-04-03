package com.group5.workshop6.group5workshop6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddModifyCustomer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblMode;

    @FXML
    private TextField tfAgentId;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustBusPhone;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustCountry;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustPostal;

    @FXML
    private TextField tfCustProv;

    @FXML
    void onCancelClicked(MouseEvent event) {

    }

    @FXML
    void onDeleteClicked(MouseEvent event) {

    }

    @FXML
    void onSaveClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert lblMode != null : "fx:id=\"lblMode\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustAddress != null : "fx:id=\"tfCustAddress\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustBusPhone != null : "fx:id=\"tfCustBusPhone\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustCity != null : "fx:id=\"tfCustCity\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustCountry != null : "fx:id=\"tfCustCountry\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustHomePhone != null : "fx:id=\"tfCustHomePhone\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustPostal != null : "fx:id=\"tfCustPostal\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustProv != null : "fx:id=\"tfCustProv\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";

    }

}

