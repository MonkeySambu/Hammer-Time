package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class BuyController {
@FXML
private AnchorPane pane;
    public void initialize() {
        for (int i = 0; i < 3; i++) {

            try {
                //System.out.println(GuiApp.class.getResource("buy.fxml"));
                FXMLLoader fxmlLoader = new FXMLLoader(GuiApp.class.getResource("item.fxml"));
                Node scene = fxmlLoader.load();

                pane.setLayoutY(100*i);
                pane.getChildren().add(scene);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
