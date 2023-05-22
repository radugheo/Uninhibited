package com.example.uninhibited.controllers;

import javafx.scene.Scene;

public abstract class GenericController {
    static Scene mainScene;

    public static void setMainScene(Scene mainScene) {
        GenericController.mainScene = mainScene;
    }
}
