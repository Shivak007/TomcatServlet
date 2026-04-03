package com.bridgelabz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/LoginServlet",
        initParams = {
                @WebInitParam(name = "user", value = "Sriram"),
                @WebInitParam(name = "password", value = "Bridge@1")
        }
)
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (!user.matches("[A-Z][a-zA-Z]{2,}")) {
            out.println("<h3 style='color:red'>Invalid Name</h3>");
            request.getRequestDispatcher("login.html").include(request, response);
            return;
        }

        if (!pwd.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            out.println("<h3 style='color:red'>Invalid Password</h3>");
            request.getRequestDispatcher("login.html").include(request, response);
            return;
        }

        String dbUser = getServletConfig().getInitParameter("user");
        String dbPwd = getServletConfig().getInitParameter("password");

        if (dbUser.equals(user) && dbPwd.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request, response);
        } else {
            out.println("<h3 style='color:red'>Invalid Credentials</h3>");
            request.getRequestDispatcher("login.html")
                    .include(request, response);
        }
    }
}