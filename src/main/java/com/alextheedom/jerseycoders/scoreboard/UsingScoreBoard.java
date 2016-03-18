package com.alextheedom.jerseycoders.scoreboard;

import java.util.Comparator;

/**
 * Created by atheedom on 13/01/2016.
 */
public class UsingScoreBoard {

    public static void main(String... args){

        ScoreBoard scoreBoard = new ScoreBoard();

        Score score1 = new Score("ABC", 1234);
        Score score2 = new Score("CVF", 432);
        Score score3 = new Score("QWE", 3);

        scoreBoard.addScore(score1);
        scoreBoard.addScore(score2);
        scoreBoard.addScore(score3);

        scoreBoard.getScores().sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });

        for(Score score : scoreBoard.getScores()){
            System.out.println(score.getName() + " - " + score.getScore());
        }


    }

}






