package by.anton.web.servlet;

import by.anton.entity.User;
import by.anton.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization")
public class UserAuthorizationServlet extends HttpServlet {
    private UserStorage userStorage = new UserStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = userStorage.findByLogin(login);
        if (byLogin != null){
            if (byLogin.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", byLogin);
            }else {
                resp.getWriter().println("Неверный пароль");
            }
        }else {
            resp.getWriter().println("Пользователя с таким логином не существует");
        }
    }
}
