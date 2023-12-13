package com.openjfx.qllspahg.gui.util;

import com.openjfx.qllspahg.entity.TaiKhoan;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControlFlow {
    public static void switchViews(ActionEvent event, String fileLocation, String titleStage) throws IOException {

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(Objects.requireNonNull(ControlFlow.class.getResource(fileLocation)));
        stage.setTitle(titleStage);
        stage.setScene(new Scene(scene));
        stage.centerOnScreen();
        stage.show();
    }
    public static void switchViewsSetSize(ActionEvent event, String fileLocation, String titleStage, int width, int height) throws IOException {

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(Objects.requireNonNull(ControlFlow.class.getResource(fileLocation)));
        stage.setTitle(titleStage);
        stage.setScene(new Scene(scene));
        stage.setWidth(width);
        stage.setHeight(height);
        stage.centerOnScreen();
        stage.show();
    }


}
