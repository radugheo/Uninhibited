package com.example.uninhibited.core;

import javafx.scene.Scene;

public class SceneUtil {
    private static Scene mainScene;

    public static void setMainScene(Scene scene) {
        mainScene = scene;
    }

    public static Scene getMainScene() {
        return mainScene;
    }
}
