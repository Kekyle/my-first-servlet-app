package by.anton.web.servlet;

import by.anton.entity.User;
import by.anton.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserStorage userStorage = new UserStorage();

    // TODO: 08.08.2020
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String field = req.getParameter("field");
        switch (field) {
            case "all":
                userStorage.findAll();
                break;
            case "findByLogin":
                String login = req.getParameter("login");
                userStorage.findByLogin(login);
                break;
            case "findByName":
                String name = req.getParameter("name");
                userStorage.findByName(name);
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String field = req.getParameter("field");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        switch (field) {
            case "login":
                String login = req.getParameter("login");
                userStorage.updateLoginById(login, currentUser.getId());
                break;
            case "password":
                String password = req.getParameter("password");
                userStorage.updatePasswordById(password, currentUser.getId());
                break;
            case "age":
                // TODO: 08.08.2020
                int age = Integer.parseInt(req.getParameter("age"));
                userStorage.updateAgeById(age, currentUser.getId());
                break;
            case "name":
                String name = req.getParameter("name");
                userStorage.updateNameById(name, currentUser.getId());
                break;
        }

    }
}
