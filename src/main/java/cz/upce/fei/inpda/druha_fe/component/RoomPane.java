package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.RoomDto;
import cz.upce.fei.inpda.druha_fe.entity.RoleENum;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class RoomPane extends BorderPane {

    private Label actLabel, desLabel;

    public RoomPane(RoomDto room, RoleENum role) {
        super();

        this.setWidth(50);
        this.setHeight(50);
        this.setPrefSize(500, 100);
        this.setStyle("-fx-border-color: black");

        this.actLabel = new Label("Actual temperature: " + room.getActualTemperature());
        this.desLabel = new Label("Desired temperature: " + room.getRequiredTemperature());

        this.setCenter(new Label(room.getName()));
        this.setTop(desLabel);
        this.setBottom(actLabel);
        if (role == RoleENum.MANAGE || role == RoleENum.LOGIN) {
            this.setLeft(new QueryButton("<", room, QueryButton.Switch.DOWN));
            this.setRight(new QueryButton(">", room, QueryButton.Switch.UP));
        }
    }
}
