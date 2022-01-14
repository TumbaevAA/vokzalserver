package com.example.vokzalserver.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Этот класс нужен для отображения даты в json так, как требует фронтенд
public class Date {
    private String year;
    private String month;
    private String day;
    private String time;

    public Date() {
    }

    public Date(String year, String month, String day, String time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }


    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}
