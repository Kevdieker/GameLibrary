module at.ac.fhcampuswien.gamelibrary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens at.ac.fhcampuswien.gamelibrary to javafx.fxml;
    exports at.ac.fhcampuswien.gamelibrary;
    exports at.ac.fhcampuswien.gamelibrary.pong;
    opens at.ac.fhcampuswien.gamelibrary.pong to javafx.fxml;
}