package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class BuyController {
@FXML
private VBox vBox;
@FXML
private AnchorPane pane;
@FXML
private Button bottone;

    public void loadProduct() {
        vBox.getChildren().clear();
        try {
            ArrayList<Prodotto> prodotti= (ArrayList<Prodotto>)GuiApp.input.readObject();
            if (!prodotti.isEmpty()){
                for (Prodotto p : prodotti) {
                    FXMLLoader fxmlLoader = new FXMLLoader(GuiApp.class.getResource("item.fxml"));
                    Node scene = fxmlLoader.load();

                    ItemController controller = fxmlLoader.getController();

                    controller.setPhoto(p.getFoto());
                    controller.setSeller(p.getUtente());
                    controller.setDate(p.getData().toString());
                    controller.setPrice(p.getPrezzo());
                    controller.setDescItem(p.getDescrizione());
                    controller.setProduct(p.getNome());
                    controller.setNum(p.getID_P());

                    pane.setPrefHeight(pane.getPrefHeight() + 300);
                    vBox.getChildren().add(scene);
                }
            }else {
                System.out.println("Impossibile prodotti");
            }
        } catch (IOException e) {
            System.out.println(e +e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e){
        System.out.println(e.getStackTrace());
        }

        bottone.setVisible(false);
    }
}


