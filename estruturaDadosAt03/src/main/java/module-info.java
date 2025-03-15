module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens application to javafx.fxml;
    exports application;
}
