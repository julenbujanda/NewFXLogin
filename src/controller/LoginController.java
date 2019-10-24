package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import model.UsersModel;

public class LoginController {

    private UsersModel usersModel;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXPasswordField txtPassword;

    public LoginController() {
        usersModel = new UsersModel();
    }

    @FXML
    public void login() {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        if (usersModel.checkPassword(user, password)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Succesful login", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect credentials", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }

}
