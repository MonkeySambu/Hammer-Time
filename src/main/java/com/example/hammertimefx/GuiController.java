package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiController {
    @FXML
    private Button loginB;

    @FXML
    public void initialize() {
        loginB.setOnAction(event -> {
            try {
                // Carica la seconda scena
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                Parent secondRoot = loader.load();
                Scene secondScene = new Scene(secondRoot, 800, 500);

                // Cambia scena nello stesso stage
                Stage stage = (Stage) loginB.getScene().getWindow();
                stage.setScene(secondScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
