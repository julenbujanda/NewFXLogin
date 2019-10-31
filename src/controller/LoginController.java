package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import data.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import model.UsersModel;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.prefs.Preferences;

public class LoginController {

    private UsersModel usersModel;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXPasswordField txtPassword;

    private Preferences preferences;

    public LoginController() {
        usersModel = new UsersModel();
        preferences = Preferences.userRoot();
        String userId = preferences.get("userId", "");
        String loginToken = preferences.get("loginToken", "");
        if (!loginToken.equals("") && !userId.equals("")) {
            User loginUser = usersModel.checkToken(userId, loginToken);
            login(loginUser);
        }
    }

    @FXML
    public void passwordLogin() {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        User loginUser = usersModel.checkPassword(user, password);
        login(loginUser);
    }

    private void login(User user) {
        if (user != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Successful login", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            saveLogin(user);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect credentials", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }

    private void saveLogin(User user) {
        // Creates token
        SecureRandom secureRandom = new SecureRandom(); //threadsafe
        Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        String token = base64Encoder.encodeToString(randomBytes);
        usersModel.updateUserToken(user, token);
        preferences.put("userId", user.getId());
        preferences.put("loginToken", token);
    }

}
