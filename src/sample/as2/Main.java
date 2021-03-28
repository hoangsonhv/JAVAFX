package sample.as2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Assignment2.fxml"));
        primaryStage.setTitle("Assignment2");
        primaryStage.setScene(new Scene(root, 850, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
