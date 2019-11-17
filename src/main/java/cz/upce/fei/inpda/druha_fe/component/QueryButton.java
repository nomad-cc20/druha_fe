package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.RoomDto;
import cz.upce.fei.inpda.druha_fe.dto.TemperatureDto;
import javafx.scene.control.Button;
import org.springframework.web.client.RestTemplate;

public class QueryButton extends Button {

    public QueryButton(String text, RoomDto room, Switch what) {
        super(text);

        this.setOnAction(e -> {
            RestTemplate restTemplate = new RestTemplate();

//            restTemplate.postForEntity("http://localhost:8080/temperature", Object.class,
//                    new TemperatureDto(room.getId(), room.getRequiredTemperature()))    ;

            if (what == Switch.UP)
                room.setRequiredTemperature(room.getRequiredTemperature() + 1);
            else
                room.setRequiredTemperature(room.getRequiredTemperature() - 1);

            restTemplate.postForLocation("http://localhost:8080/home/temperature",
                    new TemperatureDto(room.getId(), room.getRequiredTemperature()));


        });
    }

    public enum Switch {
        UP,
        DOWN
    }
}
