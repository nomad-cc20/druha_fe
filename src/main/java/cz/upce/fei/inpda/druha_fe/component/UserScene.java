package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.HomeForUserDto;
import cz.upce.fei.inpda.druha_fe.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class UserScene extends Scene {

    private final String secret = "ajfn2372nf32bg28prjgergoerjerjojhep5ughrnsoeirgpo34hnpgo34ugoun4poghwp4ougn2p34uhgp984hwpfgw4ohgpw4h8pgo4hpg9whr4p9wuhpg9uw4hpg9w4hpg9hw4p9g8hwp4ghwp4hgpow4ihb3g";


    public UserScene(Parent root, String token, Scene prev, Stage stage) {
        super(root);

        GridPane gridPane = new GridPane();

        UserDto user = extractUser(token);
        List<HomeForUserDto> homes = user.getHomes();
        homes.sort((HomeForUserDto home, HomeForUserDto anotherHome) -> (int)(home.getId() - (int)anotherHome.getId()));

        for (int i = 0; i < homes.size(); i++) {
            gridPane.add(new HomePane(new BorderPane(), homes.get(i), this, stage, user.getRole()), i % 3, i / 3);
        }

        Button backButton = new Button("^ BACK ^");
        backButton.setOnAction(event -> stage.setScene(prev));

        ((BorderPane)root).setCenter(gridPane);
        ((BorderPane)root).setTop(backButton);
    }

    public UserDto extractUser(String token) {

        token = token.substring(7);


        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        long id = Integer.toUnsignedLong((Integer)((LinkedHashMap)body.get("user")).get("id"));

        return (new RestTemplate()).getForEntity("http://localhost:8080/user/{id}", UserDto.class, Long.toString(id)).getBody();
    }
}
