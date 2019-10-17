import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        Font.loadFont(Main.class.getResource("font/Montserrat-Regular.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Montserrat-Bold.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Orbitron-Bold.ttf").toExternalForm(), 20);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
