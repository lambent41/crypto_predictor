package com.multimedia_pj.was.model;

import org.springframework.lang.NonNull;

import java.sql.Timestamp;

public class BtcData {

    @NonNull
    private final Timestamp timeStamp;
    private final double open;
    private final double high;
    private final double low;
    private final double close;
    private final double volume;

    public BtcData(@NonNull Timestamp timeStamp, double open, double high, double low, double close, double volume) {
        this.timeStamp = timeStamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    @NonNull
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public double getVolume() {
        return volume;
    }
}
