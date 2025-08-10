import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        ToggleGroup group = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Option 1");
        radioButton1.setToggleGroup(group);
        RadioButton radioButton2 = new RadioButton("Option 2");
        radioButton2.setToggleGroup(group);

        VBox vbox = new VBox(radioButton1, radioButton2);

        Scene scene = new Scene(vbox, 200, 100);
        primaryStage.setTitle("RadioButton Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
