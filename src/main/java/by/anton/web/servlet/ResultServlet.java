package by.anton.web.servlet;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/test")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer result = (Integer) getServletContext().getAttribute("result");
//        Integer attribute = (Integer) req.getSession().getAttribute("result");
//        resp.getWriter().println("Servlet context = " + result + " Session context = " + attribute);
    }
}
