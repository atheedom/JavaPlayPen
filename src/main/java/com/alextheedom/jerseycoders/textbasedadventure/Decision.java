package com.alextheedom.jerseycoders.textbasedadventure;

import java.util.HashMap;

/**
 * Created by atheedom on 15/03/2016.
 */
public class Decision {

    private String narrative;
    private Decision previousDecision;
    private HashMap<String, Decision> nextDecisions = new HashMap<>();
    private HashMap<String, String> keyPath = new HashMap<>();
    private String requiredItem;
    private String pickUpItem;

    public HashMap<String, String> getKeyPath() {
        return keyPath;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public void setPreviousDecision(Decision previousDecision) {
        this.previousDecision = previousDecision;
    }

    public HashMap<String, Decision> getNextDecisions() {
        return nextDecisions;
    }

    public Decision getNextDecision(String key) {


        if(nextDecisions.get(key).hasRequiredItem()){
            nextDecisions.get(key).pickUpItem(pickUpItem);
            return nextDecisions.get(key);
        } else {
            System.out.println("You must have a " + nextDecisions.get(key).getRequiredItem() + " to go in that direction.");
            return this;
        }

    }

    private String getRequiredItem() {
        return this.requiredItem;
    }

    private void pickUpItem(String pickUpItem) {
        if(pickUpItem != null) {
            Items.addItem(pickUpItem);
        }
    }

    private boolean hasRequiredItem() {
       return requiredItem == null || Items.hasItem(requiredItem);
    }

    public void setNextDecision(String key, String path, Decision nextDecision) {
        this.nextDecisions.put(key, nextDecision);
        this.keyPath.put(key, path);
        this.nextDecisions.put("B", previousDecision);
        this.keyPath.put("B", "to go back");

        nextDecision.setPreviousDecision(this);
    }

    public void setNextDecision(String key, String path, Decision nextDecision, String requiredItem, String pickUpItem) {

        nextDecision.setRequiredItem(requiredItem);

        //this.requiredItem = requiredItem;
        this.pickUpItem = pickUpItem;
        this.nextDecisions.put(key, nextDecision);
        this.keyPath.put(key, path);
        this.nextDecisions.put("B", previousDecision);
        this.keyPath.put("B", "to go back");

        nextDecision.setPreviousDecision(this);
    }

    private void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem;
    }

}
