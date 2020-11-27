package com.example.quickreport;

public class earthquake {
    private Double magnitude;
    private String smallcity;
    private String bigcity;
    private String date;
    private String url;

    public earthquake(double magnitude, String smallcity,String bigcity, String date,String url) {
        this.magnitude = magnitude;
        this.smallcity = smallcity;
        this.bigcity = bigcity;
        this.date = date;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getSmallcity() {
        return smallcity;
    }

    public String getBigcity(){ return bigcity; }

    public String getDate() {
        return date;
    }

    public String getUrl(){ return url; }
}
