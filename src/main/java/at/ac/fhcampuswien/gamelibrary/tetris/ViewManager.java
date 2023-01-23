package at.ac.fhcampuswien.gamelibrary.tetris;

import javafx.animation.*;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

//Main Method
public class ViewManager extends Application
{
    public static void main (String[] args)
    {
        launch(args);
    }
    //Start Method for menu stage
    public void start(Stage secondaryStage)
    {
        //Object and Stage declaration for choosing background color
        TetrisMain object = new TetrisMain();
        //start
        Stage stage = new Stage();

        //pane setting and scene for stage making
        Pane panes = new Pane();
        panes.setBackground(new Background(new BackgroundImage(new Image("application/space.jpg"), BackgroundRepeat.NO_REPEAT,   BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,  new BackgroundSize(1.0, 1.0, true, true, false, true))));
        Scene scene = new Scene(panes, 500, 500);
        secondaryStage.setResizable(false);
        secondaryStage.setScene(scene);
        secondaryStage.show();

        //Tooltip for start button
        Tooltip a = new Tooltip("Start Game");
        // Button for Starting Game
        Button menu = new Button();
        menu.setText("Start");
        menu.setTextFill(Color.WHITE);
        menu.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        menu.clipProperty();
        menu.setLayoutX(140);
        menu.setLayoutY(400);
        menu.setMaxSize(100, 50);
        menu.setTooltip(a);
        Font font = Font.font("Courier New", FontWeight.BOLD, 20);
        menu.setFont(font);

        //Event handler when Start button is pressed
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secondaryStage.close();
                try {
                    object.start(stage);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        menu.setOnAction(event1);
        panes.getChildren().add(menu);

        //Tooltip for exit button
        Tooltip b = new Tooltip("Exit Game");

        Button exit = new Button();
        exit.setText("Exit");
        exit.setTextFill(Color.WHITE);
        exit.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        exit.clipProperty();
        exit.setLayoutX(300);
        exit.setLayoutY(400);
        exit.setTooltip(b);
        exit.setMaxSize(100, 50);
        exit.setTooltip(b);
        exit.setFont(font);

        //Event handler when exit button is pressed
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secondaryStage.close();

            }
        };
        exit.setOnAction(event2);
        panes.getChildren().add(exit);

    }}
