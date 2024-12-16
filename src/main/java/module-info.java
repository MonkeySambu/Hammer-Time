module com.example.hammertimefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hammertimefx to javafx.fxml;
    exports com.example.hammertimefx;
}