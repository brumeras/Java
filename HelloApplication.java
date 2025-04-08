package org.example.emiolija;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Skaiciuokle.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 800);
        stage.setTitle("Paskolų palūkanų skaičiuoklė");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
