package com.example.motogp.controller;


import com.example.motogp.Race;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RaceController {
    @FXML
    private VBox resultadosVBox;

    @FXML
    private Button iniciarCarreraButton;

    private Race race;

    public void initialize() {
        race = new Race();
    }

    @FXML
    private void iniciarCarrera() {
        try {
            race.iniciarCarrera();
            mostrarResultados();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mostrarResultados() {
        resultadosVBox.getChildren().clear();
        for (int i = 0; i < Race.NUM_MOTOCICLISTAS; i++) {
            Label label = new Label("Motociclista " + i + ": " + Race.posicion[i].get());
            resultadosVBox.getChildren().add(label);
        }
    }
}
