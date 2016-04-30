package com.alextheedom.jerseycoders.textbasedadventure;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by atheedom on 20/04/2016.
 */
public class DrawPanel extends JPanel
{
    public DrawPanel()                       // set up graphics window
    {
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly


        // Drawing code goes here
        g.drawString("Hello, World", 100, 150);

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

    public static void main(String[] args)
    {

        Decision start = createStory();

        DrawPanel panel = new DrawPanel();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(500, 400);         // window is 500 pixels wide, 400 high
        application.setVisible(true);
    }

    private static Decision createStory() {
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


        // navigate(start);

        return start;
    }



}

