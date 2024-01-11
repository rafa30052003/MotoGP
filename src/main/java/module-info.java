module com.example.motogp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.motogp to javafx.fxml;
    exports com.example.motogp;
    exports com.example.motogp.model;
    opens com.example.motogp.model to javafx.fxml;
}