package cz.upce.fei.inpda.druha_fe.component;

import cz.upce.fei.inpda.druha_fe.dto.CredentialsDto;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;

public class MainScene extends Scene {

    public MainScene(Parent root, Stage stage) {
        super(root);

        TextField loginTf = new TextField();
        TextField pwdTf = new TextField();
        Button okButton = new Button("Log in");

        okButton.setOnAction(event -> {
            RestTemplate restTemplate = new RestTemplate();

            String token = restTemplate.postForEntity("http://localhost:8080/user/login", new CredentialsDto(loginTf.getText(), pwdTf.getText()), String.class).getBody();

            loginTf.clear();
            pwdTf.clear();

            if (token.length() > 0) {
                stage.setScene(new UserScene(new BorderPane(), token, this, stage));
            }
        });

        ((BorderPane)root).setCenter(new VBox(
                new Label("Username:"),
                loginTf,
                new Label("Password:"),
                pwdTf,
                okButton
        ));
    }
}
