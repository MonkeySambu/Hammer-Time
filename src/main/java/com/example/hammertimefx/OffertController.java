package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class OffertController {
    private Stage dialogStage;

    @FXML
    private Spinner<Integer> prezzo;


    public void confSpinner(Integer prz) {
        SpinnerValueFactory<Integer> vFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(prz+1, 1000000000, prz);
        prezzo.setValueFactory(vFactory);
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    // Gestione del click sul pulsante "OK"
    @FXML
    private void handleOk() {
        dialogStage.close(); // Chiude la finestra di dialogo
    }

    // Gestione del click sul pulsante "Annulla"
    @FXML
    private void handleCancel() {
        dialogStage.close(); // Chiude la finestra di dialogo
    }
    public String getNewPrezzo() {
        return prezzo.getValue().toString();
    }


}
