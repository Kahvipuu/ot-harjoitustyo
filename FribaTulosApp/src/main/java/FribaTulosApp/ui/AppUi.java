package fribatulosapp.ui;

import FribaTulosApp.dao.FileCourseDao;
import FribaTulosApp.dao.FilePlayerDao;
import FribaTulosApp.dao.FileRoundOfPlayDao;
import fribatulosapp.domain.AppService;
import fribatulosapp.domain.Course;
import fribatulosapp.domain.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Sovelluksen käyttöliittymästä vastaava luokka
 */
public class AppUi extends Application {

    public static int leveys = 600;
    public static int korkeus = 800;

    private AppService appservice;
    private VBox playersCreated;
    private VBox coursesCreated;

    public void redrawLists() {
        playersCreated.getChildren().clear();
        coursesCreated.getChildren().clear();

        List<Player> playerlist = appservice.getAllPlayers();
        List<Course> courselist = appservice.getAllCourses();

        for (Player p : playerlist) {
            playersCreated.getChildren().add(new Label(p.getName()));
        }
        for (Course c : courselist) {
            coursesCreated.getChildren().add(new Label(c.getName()));
        }

    }

    @Override
    public void init() throws Exception {
        String playerFile = "players.txt"; //jatkoa varten, muuten ei tarvitsisi erikseen
        String courseFile = "courses.txt";
        String roundsFile = "rounds.txt";

        FilePlayerDao playerDao = new FilePlayerDao(playerFile);
        FileCourseDao courseDao = new FileCourseDao(courseFile);
        FileRoundOfPlayDao ropDao = new FileRoundOfPlayDao(roundsFile, courseDao, playerDao);
        appservice = new AppService(playerDao, courseDao, ropDao);
        playersCreated = new VBox();
        coursesCreated = new VBox();
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(leveys, korkeus);

        HBox topOfScreen = new HBox();
        layout.setTop(topOfScreen);
        topOfScreen.setSpacing(20);

        Button startRound = new Button("Aloita Kierros");
        Button createPlayer = new Button("Luo uusi pelaaja");
        Button createCourse = new Button("Luo uusi rata");
        Button archive = new Button("Arkisto");
        topOfScreen.getChildren().addAll(startRound, createPlayer, createCourse, archive);

        FlowPane startRoundLayout = new FlowPane(Orientation.VERTICAL);
        FlowPane createNewPlayerLayout = new FlowPane(Orientation.VERTICAL);
        FlowPane createNewCourseLayout = new FlowPane(Orientation.VERTICAL);
        FlowPane archiveLayout = new FlowPane(Orientation.VERTICAL);

        startRound.setOnAction((event) -> layout.setCenter(startRoundLayout));
        createPlayer.setOnAction((event) -> layout.setCenter(createNewPlayerLayout));
        createCourse.setOnAction((event) -> layout.setCenter(createNewCourseLayout));
        archive.setOnAction((event) -> layout.setCenter(archiveLayout));

        //pelaajan luontia
        Label playerNameLabel = new Label("Nimi: ");
        TextField playerNameField = new TextField();
        Button createPlayerButton = new Button("Luo pelaaja");
        Label playersExistingLabel = new Label("Olemassaolevat pelaajat:");

        createNewPlayerLayout.getChildren().addAll(playerNameLabel, playerNameField, createPlayerButton, playersExistingLabel, playersCreated);

        createPlayerButton.setOnAction(e -> {
            appservice.createPlayer(playerNameField.getText());
            playerNameField.setText("");
            redrawLists();

        });

        //Radan luontia
        Label courseNameLabel = new Label("Nimi: ");
        Label courseHolesLabel = new Label("Väylien määrä: ");
        TextField courseNameField = new TextField();
        TextField courseHolesField = new TextField("18");
        Button createCourseButton = new Button("Luo uusi rata");
        Label coursesExistingLabel = new Label("Olemassaolevat radat:");

        createNewCourseLayout.getChildren().addAll(courseNameLabel, courseNameField, courseHolesLabel, courseHolesField, createCourseButton, coursesExistingLabel, coursesCreated);

        createCourseButton.setOnAction(e -> {
            int i = Integer.parseInt(courseHolesField.getText());
            appservice.createCourse(courseNameField.getText(), i);
            courseNameField.setText("");
            courseHolesField.setText("18");
            redrawLists();
        });

        // Kierros
        Label courseToStartLabel = new Label("Mikä rata valitaan?");
        TextField courseToStartField = new TextField();
        Button createNewRound = new Button("Aloita uusi kierros");
        Label playersToStartCourseLabel = new Label("Kierrokselle lisättävä pelaaja:");
        TextField playersToStartCourseField = new TextField();
        Button playersToStartCourseButton = new Button("Lisää pelaaja kierrokselle");
        Label courseStartedLabel = new Label("");
        HBox playersOnCourse = new HBox();

        startRoundLayout.getChildren().addAll(courseToStartLabel, courseToStartField, createNewRound, playersToStartCourseLabel, playersToStartCourseField,
                playersToStartCourseButton, courseStartedLabel, playersOnCourse);

        createNewRound.setOnAction(e -> {
            appservice.createROP(appservice.getCourseByName(courseToStartField.getText()));
            courseStartedLabel.setText(appservice.getCurrentCourseName());
            courseToStartField.setText("");
        });

        playersToStartCourseButton.setOnAction(e -> {
            try {
                appservice.addPlayerToROP(appservice.getPlayerByName(playersToStartCourseField.getText()));
                VBox playerResults = createLayoutForPlayerOnRound(playersToStartCourseField.getText());
                startRoundLayout.getChildren().add(playerResults);
            } catch (Exception ex) {
                System.out.println("Pelaajan lisäämisessä ongelma");;
            }

        });

        // set Scene yms.
        redrawLists();

        Scene onScene = new Scene(layout);

        window.setTitle("Friba");
        window.setScene(onScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(AppUi.class);
    }

    private VBox createLayoutForPlayerOnRound(String name) {
        VBox toReturn = new VBox();
        Label playerName = new Label(name);
        int holes = appservice.getNumberOfHoles();
        toReturn.getChildren().add(playerName);

        for (int x = 1; x <= holes; x++) {
            HBox toAdd = createTextFieldsForLayout(holes, name);
            toReturn.getChildren().add(toAdd);
        }
        return toReturn;
    }

    private HBox createTextFieldsForLayout(int holenumber, String name) {
        HBox toReturn = new HBox();
        Label holeNumberLabel = new Label("" + holenumber);
        TextField result = new TextField();
        Button finished = new Button();

        finished.setOnAction(e -> {
            appservice.addResultForPlayer(name, holenumber, Integer.parseInt(result.getText()));
        });

        toReturn.getChildren().addAll(holeNumberLabel, result, finished);
        return toReturn;
    }

    private StackPane createLayout(String teksti) { //Käyttämätön

        StackPane asettelu = new StackPane();
        asettelu.setPrefSize(450, 600);
        asettelu.getChildren().add(new Label(teksti));
        asettelu.setAlignment(Pos.CENTER);

        return asettelu;
    }
}
