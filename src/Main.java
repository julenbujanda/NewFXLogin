import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.UsersModel;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new UsersModel();
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        // Set minimum window size
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(500);
        // Add app icon
        primaryStage.getIcons().add(new Image("img/download.png"));
        // Load fonts
        Font.loadFont(Main.class.getResource("font/Montserrat-Regular.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Montserrat-Bold.ttf").toExternalForm(), 20);
        Font.loadFont(Main.class.getResource("font/Orbitron-Bold.ttf").toExternalForm(), 20);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
