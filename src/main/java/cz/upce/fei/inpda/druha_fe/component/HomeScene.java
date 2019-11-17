package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.HomeDto;
import cz.upce.fei.inpda.druha_fe.dto.RoomDto;
import cz.upce.fei.inpda.druha_fe.entity.RoleENum;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class HomeScene extends Scene {

    HomeDto home;
    GridPane myPane = new GridPane();
    RestTemplate restTemplate;
    Label heatLabel = new Label();
    Label coolLabel = new Label();
    RoleENum role;


    HomeScene(Parent root, HomeDto home, Scene prev, Stage stage, RoleENum role) {
        super(root);

        this.home = home;
        this.role = role;
        this.restTemplate = new RestTemplate();

        coolLabel.setStyle("-fx-background-color: blue");
        heatLabel.setStyle("-fx-background-color: red");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        update();
                    }
                });
            }
        };
        Timer timer = new Timer();

        Button backButton = new Button("^ BACK ^");
        backButton.setOnAction(event -> {
            timer.cancel();
            stage.setScene(prev);
        });

        ((BorderPane)root).setTop(backButton);
        ((BorderPane)root).setCenter(myPane);
        ((BorderPane)root).setBottom(new VBox(coolLabel, heatLabel));

        update();

        timer.schedule(timerTask, 0, 1000);
    }

    public void update() {
        this.home = restTemplate.getForObject("http://localhost:8080/home/home/{id}", HomeDto.class, Long.toString(home.getId()));

        List<RoomDto> rooms = home.getRooms();
        rooms.sort((RoomDto room, RoomDto anotherRoom) -> (int)(room.getId() - anotherRoom.getId()));

        myPane.getChildren().clear();
        for (int i = 0; i < rooms.size(); i++) {
            myPane.add(new RoomPane(rooms.get(i), role), i % 3, i / 3);
        }

        coolLabel.setText("Cooler power consumption: " + this.home.getCooler().getPower());
        heatLabel.setText("Heater power consumption: " + this.home.getHeater().getPower());
    }
}
