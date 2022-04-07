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
    private TextField tfCustomerId;

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

    Customer customer;

    private String mode;

    @FXML
    void onCancelClicked(MouseEvent event) {
        //get reference to stage and close it
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onDeleteClicked(MouseEvent event) {
        customer = new Customer(Integer.parseInt(tfCustomerId.getText()),
                tfCustFirstName.getText(),
                tfCustLastName.getText(),
                tfCustAddress.getText(),
                tfCustCity.getText(),
                tfCustProv.getText(),
                tfCustPostal.getText(),
                tfCustCountry.getText(),
                tfCustHomePhone.getText(),
                tfCustBusPhone.getText(),
                tfCustEmail.getText(),
                Integer.parseInt(tfAgentId.getText()));
        CustomerManager.deleteCustomer(customer);
        //get reference to stage and close it
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSaveClicked(MouseEvent event) {
        try {
            //if mode is "edit", do an update, else, do an insert
            if (mode.equals("edit")) {
                customer.setCustFirstName(tfCustFirstName.getText());
                customer.setCustLastName(tfCustLastName.getText());
                customer.setCustAddress(tfCustAddress.getText());
                customer.setCustCity(tfCustCity.getText());
                customer.setCustProv(tfCustProv.getText());
                customer.setCustPostal(tfCustPostal.getText());
                customer.setCustCountry(tfCustCountry.getText());
                customer.setCustHomePhone(tfCustHomePhone.getText());
                customer.setCustBusPhone(tfCustBusPhone.getText());
                customer.setCustEmail(tfCustEmail.getText());
                customer.setAgentId(Integer.parseInt(tfAgentId.getText()));
                CustomerManager.updateCustomer(customer);
            } else {
                customer = new Customer(0, tfCustFirstName.getText(),
                        tfCustLastName.getText(),
                        tfCustAddress.getText(),
                        tfCustCity.getText(),
                        tfCustProv.getText(),
                        tfCustPostal.getText(),
                        tfCustCountry.getText(),
                        tfCustHomePhone.getText(),
                        tfCustBusPhone.getText(),
                        tfCustEmail.getText(),
                        Integer.parseInt(tfAgentId.getText()));
                CustomerManager.createCustomer(customer);
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
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert lblMode != null : "fx:id=\"lblMode\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
        assert tfCustomerId != null : "fx:id=\"tfCustomerId\" was not injected: check your FXML file 'add-modify-customer-view.fxml'.";
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

    public void processCustomer(Customer c) {
        customer = c;
        tfCustomerId.setText(c.getCustomerId() + "");
        tfCustFirstName.setText(c.getCustFirstName());
        tfCustLastName.setText(c.getCustLastName());
        tfCustAddress.setText(c.getCustAddress());
        tfCustCity.setText(c.getCustAddress());
        tfCustBusPhone.setText(c.getCustBusPhone());
        tfCustHomePhone.setText(c.getCustHomePhone());
        tfCustProv.setText(c.getCustProv());
        tfCustCountry.setText(c.getCustCountry());
        tfAgentId.setText(c.getAgentId() + "");
        tfCustEmail.setText(c.getCustEmail());
        tfCustPostal.setText(c.getCustPostal());
    }

    public void passModeToDialog(String mode){
        this.mode = mode;
        //display the mode on the dialog
        lblMode.setText(mode);

        //if this is in add mode, hide the delete button, as there is nothing to delete
        if (mode.equals("add"))
        {
            btnDelete.setVisible(false);
        }
    }

}
