package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private Button buyB;
    @FXML
    private Button addB;

    @FXML
    public void initialize() {
        buyB.setOnAction(event -> {
            try {
                // Carica la seconda scena
                FXMLLoader loader = new FXMLLoader(getClass().getResource("buy.fxml"));
                Parent secondRoot = loader.load();
                Scene secondScene = new Scene(secondRoot, 800, 500);

                // Cambia scena nello stesso stage
                Stage stage = (Stage) buyB.getScene().getWindow();
                stage.setScene(secondScene);
                GuiApp.out.println(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addB.setOnAction(event -> {
            try {
                // Carica la seconda scena
                FXMLLoader loader = new FXMLLoader(getClass().getResource("sell.fxml"));
                Parent secondRoot = loader.load();
                Scene secondScene = new Scene(secondRoot, 800, 500);

                // Cambia scena nello stesso stage
                Stage stage = (Stage) addB.getScene().getWindow();
                stage.setScene(secondScene);
                GuiApp.out.println(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
