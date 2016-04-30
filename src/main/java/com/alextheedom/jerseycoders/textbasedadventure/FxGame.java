package com.alextheedom.jerseycoders.textbasedadventure;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by atheedom on 20/04/2016.
 */
public class FxGame extends Application {

    private static Decision start;
    private static Decision currentDecision;

    public static void main(String[] args) {
        initGame();
        currentDecision = start;
        Application.launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle( "FX Game" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 400, 400 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.NORMAL, 20);
        gc.setFont( theFont );
        gc.fillText( "Hello, World!", 60, 50 );



        theScene.setOnKeyPressed(
                e -> {
                    gc.clearRect(0, 0, 512,512);

                    String choice = e.getCode().toString();
//                    System.out.println(choice);
                    gc.fillText( "choice: " + choice, 30, 50 );

                    Decision decision = currentDecision.getNextDecision(choice);

//                    System.out.println(decision.getNarrative());
                    gc.fillText( decision.getNarrative(), 30, 70 );

                    for (String key : decision.getNextDecisions().keySet()) {
                        gc.fillText( key + " - " + decision.getKeyPath().get(key), 30, 90 );
//                        System.out.println(key + " - " + decision.getKeyPath().get(key));
                    }

                    currentDecision = decision;
                });

        gc.clearRect(0, 0, 512,512);



        theStage.show();
    }



    public static void initGame(){

        Decision start = new Decision();
        Decision goesLeft = new Decision();
        Decision goesRight = new Decision();
        Decision goesUp = new Decision();
        Decision goesDown = new Decision();
        Decision goesForwardTwoPaces = new Decision();
        Decision goesForwardOnePace = new Decision();

        start.setNarrative("Do you want to go do?");
        start.setNextDecision("L", "Go left (Requires KNIFE)", goesLeft, "KNIFE", null);
        start.setNextDecision("R", "Go right (Picks up MONEY)", goesRight, null, "MONEY");

        goesLeft.setNarrative("You have turned left. What do you want to do?");
        goesLeft.setNextDecision("U", "Go up", goesUp, null, null);
        goesLeft.setNextDecision("D", "Go down", goesDown);

        goesRight.setNarrative("You have turned right. What do you want to do?");
        goesRight.setNextDecision("D", "Go down (Requires MONEY)", goesDown, "MONEY", null);
        goesRight.setNextDecision("U", "Go up", goesUp);

        goesUp.setNarrative("You have gone up. What do you want to do?");
        goesUp.setNextDecision("D", "Go down", goesDown);
        goesUp.setNextDecision("U", "Go up", goesUp);

        goesDown.setNarrative("You have gone down. What do you want to do?");
        goesDown.setNextDecision("F", "Go forward two paces", goesForwardTwoPaces);
        goesDown.setNextDecision("V", "Go forward one pace", goesForwardOnePace);

        goesForwardTwoPaces.setNarrative("You have gone forward two paces. What do you want to do?");
        goesForwardTwoPaces.setNextDecision("D", "Go down", goesDown);
        goesForwardTwoPaces.setNextDecision("U", "Go up", goesUp);

        goesForwardOnePace.setNarrative("You have gone forward one pace. What do you want to do?");
        goesForwardOnePace.setNextDecision("F", "Go forward two paces", goesForwardTwoPaces);
        goesForwardOnePace.setNextDecision("V", "Go forward one pace", goesForwardOnePace);

        FxGame.start = start;
    }
}
