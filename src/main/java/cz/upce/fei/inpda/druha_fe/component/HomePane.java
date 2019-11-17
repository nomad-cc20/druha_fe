package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.HomeDto;
import cz.upce.fei.inpda.druha_fe.dto.HomeForUserDto;
import cz.upce.fei.inpda.druha_fe.entity.RoleENum;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

public class HomePane extends BorderPane {

    public HomePane(Parent root, HomeForUserDto home, Scene parent, Stage stage, RoleENum role) {
        super();

        this.setWidth(50);
        this.setHeight(50);
        this.setPrefSize(500, 100);
        this.setStyle("-fx-border-color: black");

        this.setCenter(new Label("Home #" + Long.toString(home.getId())));
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            RestTemplate restTemplate = new RestTemplate();

            stage.setScene(new HomeScene(
                    new BorderPane(),
                    restTemplate.getForObject("http://localhost:8080/home/home/{id}", HomeDto.class, Long.toString(home.getId())),
                    parent,
                    stage,
                    role
                    ));
        });
    }
}
