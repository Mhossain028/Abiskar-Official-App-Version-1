package com.edu.abiskar.Model;

public class AlertMessageClass {

    private Integer hour;
    private Integer minute;
    private String alertMessage;

    public AlertMessageClass() {
    }

    public AlertMessageClass(Integer hour, Integer minute, String alertMessage) {
        this.hour = hour;
        this.minute = minute;
        this.alertMessage = alertMessage;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}
