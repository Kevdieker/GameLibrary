module at.ac.fhcampuswien.gamelibrary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    exports at.ac.fhcampuswien.gamelibrary;
    opens at.ac.fhcampuswien.gamelibrary to javafx.fxml;

    exports at.ac.fhcampuswien.gamelibrary.tetris;
    opens at.ac.fhcampuswien.gamelibrary.tetris to javafx.fxml;

    exports at.ac.fhcampuswien.gamelibrary.ropasc;
    opens at.ac.fhcampuswien.gamelibrary.ropasc to javafx.fxml;

    exports at.ac.fhcampuswien.gamelibrary.memory;
    opens at.ac.fhcampuswien.gamelibrary.memory to javafx.fxml;

    exports at.ac.fhcampuswien.gamelibrary.pong;
    opens at.ac.fhcampuswien.gamelibrary.pong to javafx.fxml;
}