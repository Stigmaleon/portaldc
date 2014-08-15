package com.portaldc.api.data;

public enum DistributionState {
    NEW("N"),
    WRONG_DECORATION("WD"),
    MODERATED("M"),
    DELETED("D");


    private final String stateLabel;
    DistributionState(String stateLabel){
        this.stateLabel = stateLabel;
    }

    public String getState(){
        return stateLabel;
    }

}
