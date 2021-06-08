package com.multimedia_pj.was.model;

import java.util.List;

public class Response {

    private final List<BtcData> pastData;
    private final double prediction;


    public Response(List<BtcData> pastData, double prediction) {
        this.pastData = pastData;
        this.prediction = prediction;
    }

    public List<BtcData> getPastData() {
        return pastData;
    }

    public double getPrediction() {
        return prediction;
    }
}
