package com.group5.workshop6.group5workshop6;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerTable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Button btnAddCustomer;



    @FXML
    private TableView<Customer> tvCustomers;

    @FXML
    private TableColumn<Customer, Integer> colAgentId;

    @FXML
    private TableColumn<Customer, String> colCustAddress;

    @FXML
    private TableColumn<Customer, String> colCustBusPhone;

    @FXML
    private TableColumn<Customer, String> colCustCity;

    @FXML
    private TableColumn<Customer, String> colCustCountry;

    @FXML
    private TableColumn<Customer, String> colCustEmail;

    @FXML
    private TableColumn<Customer, String> colCustFirstName;

    @FXML
    private TableColumn<Customer, String> colCustHomePhone;

    @FXML
    private TableColumn<Customer, String> colCustLastName;

    @FXML
    private TableColumn<Customer, String> colCustPostal;

    @FXML
    private TableColumn<Customer, String> colCustProv;

    @FXML
    private TableColumn<Customer, Integer> colCustomerId;

    private String mode = "edit";

    @FXML
    void onAddCustomerClicked(MouseEvent event) {
        //load the dialog in "add" mode. No customer is needed.
        mode = "add";
        openDialog(null, mode);
    }

    @FXML
    void initialize() {
        assert btnAddCustomer != null : "fx:id=\"btnAddCustomer\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert tvCustomers != null : "fx:id=\"tvCustomers\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colAgentId != null : "fx:id=\"colAgentId\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustAddress != null : "fx:id=\"colCustAddress\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustBusPhone != null : "fx:id=\"colCustBusPhone\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustCity != null : "fx:id=\"colCustCity\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustCountry != null : "fx:id=\"colCustCountry\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustEmail != null : "fx:id=\"colCustEmail\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustFirstName != null : "fx:id=\"colCustFirstName\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustHomePhone != null : "fx:id=\"colCustHomePhone\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustLastName != null : "fx:id=\"colCustLastName\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustPostal != null : "fx:id=\"colCustPostal\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustProv != null : "fx:id=\"colCustProv\" was not injected: check your FXML file 'customer-table-view.fxml'.";
        assert colCustomerId != null : "fx:id=\"colCustomerId\" was not injected: check your FXML file 'customer-table-view.fxml'.";

        // get the database data into the table view
        colCustomerId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerId"));
        colCustFirstName.setCellValueFactory(new PropertyValueFactory<Customer, String>("custFirstName"));
        colCustLastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("custLastName"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("custAddress"));
        //5-8
        colCustCity.setCellValueFactory(new PropertyValueFactory<Customer, String>("custCity"));
        colCustProv.setCellValueFactory(new PropertyValueFactory<Customer, String>("custProv"));
        colCustPostal.setCellValueFactory(new PropertyValueFactory<Customer, String>("custPostal"));
        colCustCountry.setCellValueFactory(new PropertyValueFactory<Customer, String>("custCountry"));
        //9-12
        colCustHomePhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("custHomePhone"));
        colCustBusPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("custBusPhone"));
        colCustEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("custEmail"));
        colAgentId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("agentId"));

        getCustomers();

        tvCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observableValue, Customer customer, Customer t1) {
                //this property fires twice -- once when the current item is selected, once when the previous item is de-selected,
                //so block the deselection pass to avoid double processing
                if (tvCustomers.getSelectionModel().isSelected(tvCustomers.getSelectionModel().getSelectedIndex()))
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            mode = "edit";
                            openDialog(t1, mode);
                        }
                    });
            }
        });
    }

    private void openDialog(Customer customer, String mode)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-modify-customer-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddModifyCustomer dialogController = fxmlLoader.<AddModifyCustomer>getController();
        dialogController.passModeToDialog(mode);
        if (mode.equals("edit")) {
            //if a customer's information is being edited, pass their data to the dialog
            dialogController.processCustomer(customer);
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        getCustomers();
    }

    private void getCustomers() {
        //clear the observable list prior to adding the data
        tvCustomers.setItems(FXCollections.observableArrayList(CustomerManager.getCustomerList()));
    }

}
