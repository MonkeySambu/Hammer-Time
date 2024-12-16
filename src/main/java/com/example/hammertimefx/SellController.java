package com.example.hammertimefx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SellController {
    @FXML
    private ImageView imageNew;
    @FXML
    private TextArea areaTesto;
    @FXML
    private DatePicker DataP;
    @FXML
    private TextField campoTesto;
    @FXML
    private TextField prezzoIn;

    private Path targetFilePath;



    public void selectAndSaveImage() {
        // Aprire il FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona un'immagine");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Immagini", "*.png", "*.jpg", "*.jpeg")
        );

        // Selezionare il file
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Copiare il file nella cartella interna "images"
                String targetDirectory = "images";
                Path targetPath = Paths.get(targetDirectory);

                // Creare la directory se non esiste
                if (!Files.exists(targetPath)) {
                    Files.createDirectory(targetPath);
                }

                // Percorso relativo e copia del file
                targetFilePath = targetPath.resolve(selectedFile.getName());
                Files.copy(selectedFile.toPath(), targetFilePath);

                // Salvare il percorso relativo nel database
                //saveImagePathToDatabase(targetFilePath.toString());

                System.out.println("Immagine copiata e salvata correttamente: " + targetFilePath);

            } catch (IOException e) {
                System.err.println("Errore durante la copia del file: " + e.getMessage());
            }
            Image image = new Image(selectedFile.toURI().toString());
            imageNew.setImage(image);
        } else {
            System.out.println("Nessun file selezionato.");
        }
    }

    public void server(){
        GuiApp.out.println(areaTesto.getText());
        GuiApp.out.println(campoTesto.getText());
        GuiApp.out.println(prezzoIn.getText());
        GuiApp.out.println(targetFilePath.toString());
        GuiApp.out.println(DataP.getValue().toString());

        // finestra di conferma e ritorna alla home


    }
}



