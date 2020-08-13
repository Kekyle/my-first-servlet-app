package by.anton.storage;

import by.anton.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();

    public boolean save(User user){
        return users.add(user);
    }

    public List<User> findAll(){
       return new ArrayList<>(users);
    }

    public User findByLogin(String login){
        for (User user : users) {
            if (user == null) break;
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public User findByName(String name){
        for (User user : users) {
            if (user == null) break;
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public String updateLoginById(String newLogin, int id){
        for (User user : users) {
            if (user == null) break;
            if (user.getId() == id) {
                String oldLogin = user.getLogin();
                user.setLogin(newLogin);
                return oldLogin;
            }
        }
        return null;
    }

    public String updatePasswordById(String newPassword, int id){
        for (User user : users) {
            if (user == null) break;
            if (user.getId() == id){
                String oldPassword = user.getPassword();
                user.setPassword(newPassword);
                return oldPassword;
            }
        }
        return null;
    }

    public int updateAgeById(int newAge, int id){
        for (User user : users) {
            if (user == null) break;
            if (user.getId() == id){
                int oldAge = user.getAge();
                user.setAge(newAge);
                return oldAge;
            }
        }
        return -1;
    }

    public String updateNameById(String newName, int id){
        for (User user : users) {
            if (user == null) break;
            if (user.getId() == id){
                String oldName = user.getName();
                user.setName(newName);
                return oldName;
            }
        }
        return null;
    }
}
