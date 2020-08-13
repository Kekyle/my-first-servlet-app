package by.anton.web.servlet;

import by.anton.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/history")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type){
            case "all":
                List<String> history = (List<String>) getServletContext().getAttribute("history");
                for (String s : history) {
                    resp.getWriter().println(s);
                }
                break;
            case "user":
                List<String> attribute = (List<String>) req.getSession().getAttribute("history");
                for (String s : attribute) {
                    resp.getWriter().println(s);
                }
                break;
        }
    }
}
