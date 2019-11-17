package cz.upce.fei.inpda.druha_fe;

import cz.upce.fei.inpda.druha_fe.component.MainScene;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("NomadovoThermControl 1.0");
        primaryStage.setScene(new MainScene(new BorderPane(), primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
