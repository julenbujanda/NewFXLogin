package model;

import com.google.gson.Gson;
import data.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class UsersModel {

    private Gson gson;
    private HashMap<String, User> users;

    public UsersModel() {
        users = new HashMap<>();
        gson = new Gson();
        try {
            User[] userArray = gson.fromJson(new FileReader("src/data/users.json"), User[].class);
            for (var user : userArray) {
                users.put(user.getId(), user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPassword(String userId, String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);
        return users.get(userId).getPassword().equals(hashedPassword);
    }

}
