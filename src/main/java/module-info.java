module com.group5.workshop6.group5workshop6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group5.workshop6.group5workshop6 to javafx.fxml;
    exports com.group5.workshop6.group5workshop6;
}