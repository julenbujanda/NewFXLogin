package model;

import com.google.gson.Gson;
import data.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.HashMap;

public class UsersModel {

    private static final String FILE = "src/data/users.json";

    private Gson gson;
    private HashMap<String, User> users;

    public UsersModel() {
        users = new HashMap<>();
        gson = new Gson();
        try {
            User[] userArray = gson.fromJson(new FileReader(FILE), User[].class);
            for (var user : userArray) {
                users.put(user.getId(), user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateData() throws IOException {
        try (Writer writer = new FileWriter(FILE)) {
            Gson gson = new Gson();
            gson.toJson(users.values().toArray(), writer);
        }
    }

    public void updateUserToken(User user, String token) {
        user.setLoginToken(token);
        try {
            updateData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User checkPassword(String userId, String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);
        return users.get(userId).getPassword().equals(hashedPassword) ? users.get(userId) : null;
    }

}
