module com.example.uninhibited {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.uninhibited to javafx.fxml;
    exports com.example.uninhibited;
    exports com.example.uninhibited.core;
    opens com.example.uninhibited.core to javafx.fxml;
    exports com.example.uninhibited.controllers;
    opens com.example.uninhibited.controllers to javafx.fxml;
}