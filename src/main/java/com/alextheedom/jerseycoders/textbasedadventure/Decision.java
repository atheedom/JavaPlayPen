package com.alextheedom.jerseycoders.textbasedadventure;

import java.util.HashMap;

/**
 * Created by atheedom on 15/03/2016.
 */
public class Decision {

    private String narative;
    private Decision previousDecision;
    private HashMap<String, Decision> nextDecisions = new HashMap<>();
    private HashMap<String, String> keyPath = new HashMap<>();


    public HashMap<String, String> getKeyPath() {
        return keyPath;
    }

    public String getNarative() {
        return narative;
    }

    public void setNarative(String narative) {
        this.narative = narative;
    }

    public void setPreviousDecision(Decision previousDecision) {
        this.previousDecision = previousDecision;
    }

    public HashMap<String, Decision> getNextDecisions() {
        return nextDecisions;
    }

    public Decision getNextDecision(String key) {
        return nextDecisions.get(key);
    }

    public void setNextDecision(String key, String path, Decision nextDecision) {
        this.nextDecisions.put(key, nextDecision);
        this.keyPath.put(key, path);
        this.nextDecisions.put("B", previousDecision);
        this.keyPath.put("B", "to go back");

        nextDecision.setPreviousDecision(this);
    }

}
