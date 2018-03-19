package context;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComputerUi extends Application {

    private static final int PADDING = 10;
    private static final int SPACING = 10;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Computer computer;
    private Text stateText;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Computer Power State Demo");

        computer = new Computer();

        primaryStage.setScene(computerScene());
        primaryStage.show();
    }

    private Scene computerScene() {
        VBox mainBox = getVBox();

        stateText = new Text(computer.getStateText());

        Button powerButton = getPowerButton();

        Button fiveSecondButton = getTimeButton(5);
        Button fifteenSecondButton = getTimeButton(15);


        mainBox.getChildren().addAll(stateText, powerButton, fiveSecondButton, fifteenSecondButton);

        return new Scene(mainBox, WIDTH, HEIGHT);

    }

    private VBox getVBox() {
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(PADDING));
        mainBox.setSpacing(SPACING);
        return mainBox;
    }

    private Button getTimeButton(int time) {
        Button timeButton = new Button("Add " + time + " Seconds");

        if (time == 5) {
            timeButton.setOnAction(event -> {
                computer.send5Seconds();
                changeStateText(computer.getStateText());
            });
        } else if (time == 15) {
            timeButton.setOnAction(event -> {
                computer.send15Seconds();
                changeStateText(computer.getStateText());
            });
        }

        return timeButton;
    }

    private Button getPowerButton() {
        Button powerButton = new Button("Power");

        powerButton.setOnAction(event -> {
            computer.sendPowerSignal();
            changeStateText(computer.getStateText());
        });
        return powerButton;
    }

    private void changeStateText(String newStateText) {
        stateText.setText(newStateText);
    }


}
