/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 794980
 */
public class loginServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "See you later you have logged out");
        }
        if (session.getAttribute("user") != null){
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService account = new AccountService();
        HttpSession session = request.getSession(false);
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

         if (userName != null && password != null) {
            if (account.login(userName, password) != null) {
                User user = account.login(userName, password);
                session.setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                request.setAttribute("username", userName);
                request.setAttribute("password", password);
                request.setAttribute("message", "Username or password don't match");
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("username", userName);
            request.setAttribute("password", password);            
            request.setAttribute("message", "Username and password must be filled in");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
