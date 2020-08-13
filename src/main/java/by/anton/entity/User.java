package by.anton.entity;

public class User {
    private static int incId = 1;
    private int id = incId++;
    private String login;
    private String password;
    private int age;
    private String name;

    public User() {
    }

    public User(String login, String password, int age, String name) {
        this.login = login;
        this.password = password;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
