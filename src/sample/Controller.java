package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    private JFXTextField txtTime;

    public void showTime() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        txtTime.setText(df.format(new Date()));
    }

}
