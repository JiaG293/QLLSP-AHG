package com.openjfx.qllspahg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

import com.openjfx.qllspahg.database.Db;
import javafx.stage.StageStyle;

import static com.openjfx.qllspahg.database.Db.getConnection;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/DangNhap.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
        stage.centerOnScreen(); // Trung tam man hinh
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();
    }


//    public void switchViews(ActionEvent event, String fileLocation, String titleStage) throws IOException {
//
//        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//        scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileLocation)));
//            stage.setTitle(titleStage)
//        stage.setScene(new Scene(scene));
//        stage.centerOnScreen();
//        stage.show();
//    }

    public static void main(String[] args) {

        launch();

    }
}