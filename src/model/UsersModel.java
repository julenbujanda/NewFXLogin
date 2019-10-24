package model;

import com.google.gson.Gson;
import data.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UsersModel {

    private Gson gson;
    private User[] users;

    public UsersModel() {
        gson = new Gson();
        try {
            users = gson.fromJson(new FileReader("src/data/users.json"), User[].class);
            for (var user : users) {
                System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
