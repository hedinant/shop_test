package app.servlets;


import app.model.ModelUsers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/authorize.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        String flag = null;
        req.setAttribute("email",email);

        flag = ModelUsers.getInstanse().checkUser(email,pass) ? "success" : "fail";
        req.setAttribute("flag", flag);

        doGet(req,resp);

        //TODO: connection to DB for checking user || Authorization via java AuthentificationByForm
    }
}
