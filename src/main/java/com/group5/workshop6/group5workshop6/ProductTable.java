package com.group5.workshop6.group5workshop6;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductTable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddProduct;

    @FXML
    private TableView<Product> tvProducts;

    @FXML
    private TableColumn<Product, String> colProdName;

    @FXML
    private TableColumn<Product, Integer> colProductId;

//    private ObservableList<Product> productData = FXCollections.observableArrayList();

    private String mode = "edit";

    @FXML
    void onAddProductClicked(MouseEvent event) {
        //load the dialog in "add" mode. No product is needed.
        mode = "add";
        openDialog(null, mode);
    }

    @FXML
    void initialize() {
        assert btnAddProduct != null : "fx:id=\"btnAddProduct\" was not injected: check your FXML file 'product-table-view.fxml'.";
        assert tvProducts != null : "fx:id=\"tvProducts\" was not injected: check your FXML file 'product-table-view.fxml'.";
        assert colProdName != null : "fx:id=\"colProdName\" was not injected: check your FXML file 'product-table-view.fxml'.";
        assert colProductId != null : "fx:id=\"colProductId\" was not injected: check your FXML file 'product-table-view.fxml'.";

        // get the database data into the table view
        colProductId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        colProdName.setCellValueFactory(new PropertyValueFactory<Product, String>("prodName"));

        getProducts();

        tvProducts.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                //this property fires twice -- once when the current item is selected, once when the previous item is de-selected,
                //so block the deselection pass to avoid double processing
                if (tvProducts.getSelectionModel().isSelected(tvProducts.getSelectionModel().getSelectedIndex()))
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

    private void openDialog(Product product, String mode)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-modify-product-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddModifyProduct dialogController = fxmlLoader.<AddModifyProduct>getController();
        dialogController.passModeToDialog(mode);
        if (mode.equals("edit")) {
            //if a product is being edited, pass the product to the dialog
            dialogController.processProduct(product);
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        getProducts();
    }

    private void getProducts() {
        //clear the observable list prior to adding the data
        tvProducts.setItems(FXCollections.observableArrayList(ProductManager.getProductList()));
//        List<Integer> id = ProductManager.getProductIdList();
//        for (int i=1; i < id.size(); i++)
//        {
//            ProductManager.getProductById(i);
//        }

        // load products from database
//        String user = "";
//        String password = "";
//        String url = "";
//        // that connection.properties file needs to be replaced with the one we have in the project
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
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from products");
//            while (rs.next())
//            {
//                productData.add(new Product(rs.getInt(1), rs.getString(2)));
//            }
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
