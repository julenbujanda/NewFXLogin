import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(500);
        primaryStage.getIcons().add(new Image("img/download.png"));
        Font.loadFont(Main.class.getResource("font/Montserrat-Regular.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Montserrat-Bold.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Orbitron-Bold.ttf").toExternalForm(), 20);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
