package by.anton.web.servlet;

import by.anton.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    //servlet context (application context)
    //session context
    //request context

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getSession().getAttribute("history") == null){
            req.getSession().setAttribute("history", new ArrayList<>());
        }
        if (getServletContext().getAttribute("history") == null){
            getServletContext().setAttribute("history", new ArrayList<>());
        }

        String operationType = req.getParameter("operationType");
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = getResult(operationType, num1, num2);

        List<String> history = (List<String>) req.getSession().getAttribute("history");
        history.add("Result :" + result);

        User currentUser = (User) req.getSession().getAttribute("currentUser");

        List<String> attribute = (List<String>) getServletContext().getAttribute("history");
        attribute.add(currentUser.getName() + " Result :" + result);
    }

    private int getResult(String operationType, int num1, int num2) {
        int result = 0;
        switch (operationType) {
            case "sum":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
