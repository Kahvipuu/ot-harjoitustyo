package fribatulosapp.ui;

import fribatulosapp.domain.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * Sovelluksen käyttöliittymästä vastaava luokka
 */
public class AppUi extends Application {

    public static int leveys = 600;
    public static int korkeus = 800;

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(leveys, korkeus);

        HBox topOfScreen = new HBox();
        layout.setTop(topOfScreen);
        topOfScreen.setSpacing(20);

        Button startRound = new Button("Aloita Kierros");
        topOfScreen.getChildren().add(startRound);
        Button createPlayer = new Button("Luo Pelaaja");
        topOfScreen.getChildren().add(createPlayer);
        Button something = new Button("Tee Jotain");
        topOfScreen.getChildren().add(something);

        StackPane startRoundLayout = createLayout("Kierros");
        StackPane createNewPlayerLayout = createLayout("Pelaaja");
        StackPane somethingLayout = createLayout("Jotain");

        startRound.setOnAction((event) -> layout.setCenter(startRoundLayout));
        createPlayer.setOnAction((event) -> layout.setCenter(createNewPlayerLayout));
        something.setOnAction((event) -> layout.setCenter(somethingLayout));

        GridPane createNewPlayerLayout2 = new GridPane();
        createNewPlayerLayout.getChildren().add(createNewPlayerLayout2);

        Label playerNameLabel = new Label("Nimi: ");
        TextField playerNameField = new TextField();
        Button createPlayerButton = new Button("Luo pelaaja");
        createNewPlayerLayout2.add(playerNameLabel, 0, 0);
        createNewPlayerLayout2.add(playerNameField, 1, 0);

        createPlayerButton.setOnAction((event) -> new Player(playerNameField.getText()));  // Pejaajat ehkä Listaan, niin saa otteen uusista.. itse luonti Service-luokkaan
                                                                                            // ja service tämän luokan privaksi
        createNewPlayerLayout2.add(createPlayerButton, 2, 0);

        Scene naytettava = new Scene(layout);

        window.setTitle("Friba");
        window.setScene(naytettava);
        window.show();

    }

    public static void main(String[] args) {
        launch(AppUi.class);
    }

    private StackPane createLayout(String teksti) {

        StackPane asettelu = new StackPane();
        asettelu.setPrefSize(450, 600);
        asettelu.getChildren().add(new Label(teksti));
        asettelu.setAlignment(Pos.CENTER);

        return asettelu;
    }
}
