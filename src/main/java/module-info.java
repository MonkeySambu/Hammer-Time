module com.example.hammertimefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hammertimefx to javafx.fxml;
    exports com.example.hammertimefx;
}