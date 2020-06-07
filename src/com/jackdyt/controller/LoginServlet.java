package com.jackdyt.controller;

import com.jackdyt.entity.Admin;
import com.jackdyt.entity.Book;
import com.jackdyt.entity.Borrow;
import com.jackdyt.entity.Reader;
import com.jackdyt.service.BookService;
import com.jackdyt.service.LoginService;
import com.jackdyt.service.impl.BookServiceImpl;
import com.jackdyt.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    /**
     *  deal with login
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Object object = loginService.login(username, password, type);

        if (object != null){
            HttpSession session = req.getSession();
            switch (type){
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader", reader);
                    resp.sendRedirect("/book?page=1");
                    break;
                case"admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin", admin);
                    //Model
                    resp.sendRedirect("/admin?method=findAllBorrow&page=1");

                    break;
            }

        }else{
            resp.sendRedirect("login.jsp");
        }


    }


}
