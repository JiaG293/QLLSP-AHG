package com.openjfx.qllspahg.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class Samplecontroller {

    @FXML
    private BorderPane TestScene;

    @FXML
    private MenuItem logOut;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

//    Dat ten file theo yeu cau gui: <TenManHinh>Controller
    @FXML
    void onLogOut(ActionEvent event) throws IOException {
        try {
            new SceneSwitchSample(TestScene, "fxml/DangNhap.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
