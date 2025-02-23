package com.openjfx.qllspahg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/TaiKhoan/DangNhap.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 700);
        stage.centerOnScreen(); // Trung tam man hinh
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}