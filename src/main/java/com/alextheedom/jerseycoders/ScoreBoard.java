package com.alextheedom.jerseycoders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atheedom on 13/01/2016.
 */
public class ScoreBoard {

    private List<Score> scores = new ArrayList<>();

    public List<Score> getScores() {
        return scores;
    }

    public void addScore(Score scores) {
        this.scores.add(scores);
    }
}
