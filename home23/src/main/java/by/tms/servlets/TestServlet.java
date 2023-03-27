package by.tms.servlets;


import by.tms.service.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.service.Valid.validateDouble;
import static by.tms.service.Valid.validateType;

@WebServlet("/calc") //localhost:8081/calc?name1=4&name2=5&type=sum
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean t = true;
        double  nm1, nm2;
        String res;

        String name1 = req.getParameter("name1");
        if (validateDouble(name1)) {
            nm1 = Double.parseDouble(name1);
        } else {
            t = false;
            nm1 = 0;
        }

        String name2 = req.getParameter("name2");
        if (validateDouble(name2)) {
            nm2 = Double.parseDouble(name2);
        } else {
            t = false;
            nm2 = 0;
        }

        String type = req.getParameter("type");
        if (validateType(type) && t) {
            Calculator calc = new Calculator();
            res = calc.calculate(nm1, nm2, type);

        } else {res="Неправильные параметры";

        }
        resp.setContentType("calc/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Calc</h1>");
        resp.getWriter().println("<p>Result:" + res + "</p>");


    }
}
