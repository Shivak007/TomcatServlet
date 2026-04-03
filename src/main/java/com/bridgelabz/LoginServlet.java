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
                @WebInitParam(name = "password", value = "BridgeLabz")
        }
)
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String dbUser = getServletConfig().getInitParameter("user");
        String dbPwd = getServletConfig().getInitParameter("password");

        if (dbUser.equals(user) && dbPwd.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<h3 style='color:red'>Invalid Credentials</h3>");
            request.getRequestDispatcher("login.html")
                    .include(request, response);
        }
    }
}