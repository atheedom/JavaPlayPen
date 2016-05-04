package com.alextheedom.jerseycoders.textbasedadventurefx;

import java.util.HashMap;

/**
 * Created by atheedom on 15/03/2016.
 */
public class Decision {

    private String narrative;
    private Decision previousDecision;
    private HashMap<String, Decision> nextDecisions = new HashMap<>();
    private HashMap<String, String> keyPath = new HashMap<>();

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
        if(nextDecisions.containsKey(key)){
            return nextDecisions.get(key);
        }
        return this;
    }

    public void setNextDecision(String key, String path, Decision nextDecision) {
        this.nextDecisions.put(key, nextDecision);
        this.keyPath.put(key, path);
        this.nextDecisions.put("B", previousDecision);
        this.keyPath.put("B", "to go back");

        nextDecision.setPreviousDecision(this);
    }


}
