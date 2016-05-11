package com.alextheedom.jerseycoders.textbasedadventurefx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    public void start(Stage theStage) throws InterruptedException {
        theStage.setTitle( "FX Game" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 800, 400 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);

        int y = 90;

        gc.setFont(Font.loadFont("file:resources/fonts/star_jedi/starjout/Starjout.ttf", 20));

        theStage.show();

        gc.fillText( currentDecision.getNarrative(), 30, 70 );
        for (String key : currentDecision.getNextDecisions().keySet()) {
            gc.fillText( key + " - " + currentDecision.getKeyPath().get(key), 30, y=y+20 );
        }

        theScene.setOnKeyPressed(
                e -> {
                    gc.clearRect(0, 0, 800,400);

                    String choice = e.getCode().toString();
                    gc.fillText( "choice: " + choice, 30, 50 );

                    Decision decision = currentDecision.getNextDecision(choice);

                    gc.fillText( decision.getNarrative(), 30, 80 );

                     int x = 90;

                    for (String key : decision.getNextDecisions().keySet()) {
                        gc.fillText( key + " - " + decision.getKeyPath().get(key), 30, x=x+30 );
                    }

                    currentDecision = decision;

                });

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
        start.setNextDecision("L", "Go left", goesLeft);
        start.setNextDecision("R", "Go right", goesRight);

        goesLeft.setNarrative("You have turned left. What do you want to do?");
        goesLeft.setNextDecision("U", "Go up", goesUp);
        goesLeft.setNextDecision("D", "Go down", goesDown);

        goesRight.setNarrative("You have turned right. What do you want to do?");
        goesRight.setNextDecision("D", "Go down", goesDown);
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


    private void starWarifyIt(GraphicsContext gc, Stage theStage) throws InterruptedException {




        new AnimationTimer() {
            @Override
            public void handle(long now) {

                 gc.clearRect(0, 0, 800,400);

                for (int y = 0; y < 400; y=y+5){
                    gc.fillText( "Hello ", 30, y );
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();



    }
}
