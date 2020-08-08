package by.anton.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    //servlet context (application context)
    //session context
    //request context

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String operationType = req.getParameter("operationType");
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = getResult(operationType, num1, num2);

//        getServletContext().setAttribute("result", result);
//        req.getSession().setAttribute("result", result);
        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/second").forward(req, resp);
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
