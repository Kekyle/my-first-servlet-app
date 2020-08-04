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

    //init
    //service
    //destroy

//    @Override
//    public void init() throws ServletException {
//        System.out.println("init");
//    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        System.out.println("service");
//    }

//    @Override
//    public void destroy() {
//        System.out.println("destroy");
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operationType = req.getParameter("operationType");
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = getResult(operationType, num1, num2);
        PrintWriter writer = resp.getWriter();
        writer.println("num1  = " + num1 + " num2 = " + num2 + " operation = " + operationType + "\n" + "result = " + result);
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
