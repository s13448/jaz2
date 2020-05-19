package pl.jaz.jazapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("average")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String numbers = req.getParameter("numbers");
        PrintWriter writer = resp.getWriter();
        int sum = 0;
        String[] tmp = numbers.split(",");

        for (String number : tmp) {
            sum = sum + Integer.parseInt(number);
        }

        double avarage = (double) sum / tmp.length;

        writer.println("sum:" + sum + " " + Arrays.toString(tmp) + " " + Math.floor(avarage * 100) / 100);
        resp.setStatus(200);
        resp.setContentType("text/plain");
    }
}
