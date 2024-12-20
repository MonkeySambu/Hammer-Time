package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ItemController {
    @FXML
    private TextField product;
    @FXML
    private TextField seller;
    @FXML
    private TextField price;
    @FXML
    private TextField date;
    @FXML
    private ImageView image;
    @FXML
    private TextArea descItem;
    @FXML
    private TextField num;


    public void setProduct(String s)  {
        product.setText(s);
    }

    public void setDescItem(String s)  {
        descItem.setText(s);
    }

    public void setDate(String s)  {
        date.setText(s);
    }

    public void setPrice(String s)  {
        price.setText(s);
    }

    public void setSeller(String s) {
        seller.setText(s);
    }

    public void setPhoto(String photo) {
        image.setImage(new Image("file:" + photo));
    }

    public void setNum(Integer num) {
        this.num.setText(num.toString());
    }

    public Integer getPriceV(){
        return Integer.parseInt(price.getText());
    }

    public void offri(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("offert.fxml"));
            Parent root = fxmlLoader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Finestra di dialogo");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            dialogStage.setScene(new Scene(root));

            OffertController controller = fxmlLoader.getController();
            controller.setDialogStage(dialogStage);
            controller.confSpinner(getPriceV());
            dialogStage.showAndWait();

            GuiApp.out.println(num.getText());
            GuiApp.out.println(controller.getNewPrezzo());
            price.clear();
            price.setText(controller.getNewPrezzo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
