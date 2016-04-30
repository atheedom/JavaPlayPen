package com.alextheedom.jerseycoders.textbasedadventure;

import java.util.Scanner;

/**
 * Created by atheedom on 15/03/2016.
 */
public class Story {


    public static void main(String... args) {

        Decision start = new Decision();
        Decision goesLeft = new Decision();
        Decision goesRight = new Decision();
        Decision goesUp = new Decision();
        Decision goesDown = new Decision();
        Decision goesForwardTwoPaces = new Decision();
        Decision goesForwardOnePace = new Decision();

        start.setNarrative("What do you want to do?");
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


        navigate(start);

    }


    public static void navigate(Decision decision) {

        System.out.println(decision.getNarrative());
        for (String key : decision.getNextDecisions().keySet()) {
            System.out.println(key + " - " + decision.getKeyPath().get(key));
        }

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        navigate(decision.getNextDecision(choice));
    }


}
