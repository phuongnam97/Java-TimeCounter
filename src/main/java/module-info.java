module vn.maize.TimeCounter {
    requires javafx.controls;
    requires javafx.fxml;

    opens vn.maize.TimeCounter to javafx.fxml;
    opens vn.maize.TimeCounter.controller to javafx.fxml;
    exports vn.maize.TimeCounter;
}
