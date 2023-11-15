package com.openjfx.qllspahg.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ManHinhChinhController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}