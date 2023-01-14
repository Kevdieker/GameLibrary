package at.ac.fhcampuswien.gamelibrary.memory;

import at.ac.fhcampuswien.gamelibrary.MainSceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MemoryController implements Initializable {

    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Integer> numbers = new ArrayList<>();

    private Button first = null;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;

    @FXML
    private Button btn12;

    @FXML
    private Button btn13;

    @FXML
    private Button btn14;

    @FXML
    private Button btn15;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    public void restart(ActionEvent event) {
        for (Button btn:buttons) {
            btn.setText("");
        }
        Collections.shuffle(numbers);
    }
    @FXML
    public void buttonClicked(ActionEvent event) {
        Button btn = (Button) event.getSource();

        if (btn.getText().equals("")) {
            int index = buttons.indexOf(btn);
            int number = numbers.get(index);
            btn.setText(number + "");

            if (first == null){
                first = btn;
            }else{
                int firstIndex = buttons.indexOf(first);
                int firstNumber = numbers.get(firstIndex);
                if (firstNumber == number){
                    new Alert(Alert.AlertType.INFORMATION,"Matched!").showAndWait();
                }else{
                    new Alert(Alert.AlertType.INFORMATION,"Not Matched!").showAndWait();
                    first.setText("");
                    btn.setText("");
                }
                first = null;
            }


        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        buttons.add(btn0);
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);
        buttons.add(btn10);
        buttons.add(btn11);
        buttons.add(btn12);
        buttons.add(btn13);
        buttons.add(btn14);
        buttons.add(btn15);

        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
            numbers.add(i);
        }

        Collections.shuffle(numbers);

    }
    public void switchToMainMenu(ActionEvent e) throws IOException {
        new MainSceneSwitch().switchToMainMenu(e);
    }
}