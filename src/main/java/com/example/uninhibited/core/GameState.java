package com.example.uninhibited.core;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.NumberFormat;
import java.util.Locale;

public class GameState {
    private static GameState instance;

    private ObservableList<String> eventList;

    private GameState() {
        this.eventList = FXCollections.observableArrayList();
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public ObservableList<String> getEventList() {
        return eventList;
    }
    public String formatMoney(int money){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        return numberFormat.format(money);
    }
}