package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import model.UsersModel;

public class LoginController {

    private UsersModel usersModel;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXTextField txtPassword;

    public LoginController() {
        usersModel = new UsersModel();
    }

    @FXML
    public void login() {
        String user = txtUser.getText();
        String password = txtPassword.getText();
        if (usersModel.checkPassword(user,password)){

        } else {

        }
    }

}
