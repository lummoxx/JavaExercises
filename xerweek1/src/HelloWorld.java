
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("hej");

        Button button = new Button();

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        System.out.println("hej 2");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("hej 3");

    }

    public static void main(String[] args) {
        launch(args);
    }
}