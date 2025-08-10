import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class HyperlinkExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Hyperlink hyperlink = new Hyperlink("Visit Google");
        hyperlink.setOnAction(e -> getHostServices().showDocument("https://www.google.com"));
        Scene scene = new Scene(hyperlink, 200, 100);
        primaryStage.setTitle("Hyperlink Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
